package com.gofortrainings.newsportal.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class)
//@SlingServletPaths(value = {"/newsportal/recent-articles","/newsportal/featured-articles"})
@SlingServletResourceTypes(resourceTypes = "newsportal/recent-articles")
public class RecentArticleServlets extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("response from path based servlet - do get.");

    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver resolver = request.getResourceResolver();
        Resource userresource = resolver.getResource("/content/users");
        Map<String, Object> props = new HashMap<>();

        props.put("firstName", "krishna999");
        props.put("lastName", "vamsi");
        props.put("email", "krishna999@gmail");
        props.put("phone", "12345");

        resolver.create(userresource, "krishna0999", props);
        resolver.commit();
        response.getWriter().write("node created successfully.");
    }

    @Override
    protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("response from path based servlet - do put.");
    }

    @Override
    protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("response from path based servlet - do delete.");
    }


}
