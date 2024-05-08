package com.gofortrainings.newsportal.core.servlets;

import com.gofortrainings.newsportal.core.service.AriticleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/content/krishna0003")
public class ArticleListServlet extends SlingSafeMethodsServlet {

    @Reference
    AriticleService articleService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//        if(slingSettingsService.getRunModes().contains("pubilsh")) {
        response.setContentType("application/json");
        response.getWriter().write(articleService.getArticle());
//        }

    }


}
