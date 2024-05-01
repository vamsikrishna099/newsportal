package com.gofortrainings.newsportal.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Date;

import static org.apache.sling.models.annotations.injectorspecific.InjectionStrategy.*;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class AriticleDetailsModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.REQUIRED)
    public String articleTitle;

    @ValueMapValue
    public String articleDesc;

    @ValueMapValue
    public String articleImage;

    @ValueMapValue
    public Date expiryDate;

    private boolean articleExipired;

    @PostConstruct
    public void init(){
        if(expiryDate != null){
            Date today = new Date();
            if(expiryDate.compareTo(today) < 0){
                articleExipired = true;
            } else {
                articleExipired = false;
            }
        }
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public boolean isArticleExipired() {
        return articleExipired;
    }
}
