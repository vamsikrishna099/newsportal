package com.gofortrainings.newsportal.core.utils;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = GTResourceUtil.class)
public class GTResourceUtil
{
    @Reference
    ResourceResolverFactory factory;

    public ResourceResolver getUserResourceResolver(String subService)
    {
        final Map<String,Object> paraMap = new HashMap<>();
        paraMap.put(ResourceResolverFactory.SUBSERVICE,subService);
        try{
            return factory.getServiceResourceResolver(paraMap);
        } catch (LoginException e) {

        }
        return null;
    }

}
