package com.gofortrainings.newsportal.core.models;

import com.gofortrainings.newsportal.core.service.AriticleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class,
        SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleListModel {

    @ValueMapValue
    public boolean useServlet;

    @OSGiService
    AriticleService ariticleService;


    public String getArticle() {
        return ariticleService.getArticle();
    }

    public boolean getUseServlet() {
        return useServlet;
    }

}
