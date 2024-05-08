package com.gofortrainings.newsportal.core.service.imp;

import com.gofortrainings.newsportal.core.service.AriticleService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Component(service = AriticleService.class)
@Designate(ocd = AriticleConfiguration.class)
public class AriticleServiceImp implements AriticleService {

    private static final Logger LOG = LoggerFactory.getLogger(AriticleServiceImp.class);

    String getLink;
    @Activate
    @Modified
    public void activate(AriticleConfiguration confr) {
        this.getLink = confr.api();
    }

    @Override
    public String getArticle() {
        String result = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(getLink);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            }
        } catch (IOException e) {
            LOG.info("Error while fetching articles from rest API {}",e.getMessage());
        }
        return result;
    }
}


