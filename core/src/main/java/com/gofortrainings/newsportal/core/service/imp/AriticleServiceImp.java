package com.gofortrainings.newsportal.core.service.imp;

import com.gofortrainings.newsportal.core.service.AriticleService;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = AriticleService.class)
public class AriticleServiceImp implements AriticleService {
    @Reference
    AriticleService ariticleService;
    public static final Logger log = LoggerFactory.getLogger(AriticleService.class);

    @Activate
    public void activate(){
        log.info("Inside activate method....");

    }

    @Deactivate
    public void deactivate(){
        log.info("Inside deactivate method....");

    }

    @Modified
    public void update(){
        log.info("Inside update method....");

    }


    @Override
    public String getArticle() {
        return "this method will return articles";
    }
}
