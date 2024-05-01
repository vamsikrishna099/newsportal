package com.gofortrainings.newsportal.core.listeners;

import com.day.cq.replication.ReplicationAction;
import com.gofortrainings.newsportal.core.service.imp.NPUtilService;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class,
            immediate = true,
        property = {
        
                    EventConstants.EVENT_TOPIC +"="+ ReplicationAction.EVENT_TOPIC,
                   // EventConstants.EVENT_FILTER +"=(& (type = ACTIVATE) (paths=/content/newsportal/us/en/article-pages/*) )"
                }
)

public class ArticleActivationHandler implements EventHandler
{
    @Reference
    NPUtilService npUtilService;

    private static final Logger log = LoggerFactory.getLogger(ArticleActivationHandler.class);
    @Override
    public void handleEvent(Event event) {
        log.info("inside the handle event method..");
        String [] pathsp= (String[])event.getProperty("paths");
        String eventType = event.getProperty("type").toString();

        try (ResourceResolver resolver= npUtilService.getResourceResolver()){
            for(String path : pathsp) {
                if (path.startsWith("/content/newsportal/us/en/article-pages") && eventType.equals("ACTIVATE")) {
                    Resource resource = resolver.getResource(path + "/jcr:content");
                    ModifiableValueMap mprop = resource.adaptTo(ModifiableValueMap.class);
                    mprop.put("page is activated", true);
                }
            }
            resolver.commit();
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}
