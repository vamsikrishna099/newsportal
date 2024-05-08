package com.gofortrainings.newsportal.core.servlets;

import com.gofortrainings.newsportal.core.service.AriticleService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ArticleListServletTest {

    AemContext context= new AemContext();

    ArticleListServlet articleListServlet;
    @Mock
    AriticleService ariticleService;

    @Mock
    SlingHttpServletResponse response;
    @Mock
    PrintWriter printWriter;
    @Mock
    SlingHttpServletRequest request;
    @BeforeEach
    void setUp(){
        articleListServlet = new ArticleListServlet();
        articleListServlet.articleService=ariticleService;
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        when(ariticleService.getArticle()).thenReturn("api data");
        when(response.getWriter()).thenReturn(printWriter);
        articleListServlet.doGet(request,response);
    }

}