package com.gofortrainings.newsportal.core.service;

import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class pageReleaseService {
    public static final Logger log = LoggerFactory.getLogger(pageReleaseService.class);

    @Reference
    AriticleService articleService;

    @Activate
    public void activate(){
        log.info(articleService.getArticle());
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
}
