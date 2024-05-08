package com.gofortrainings.newsportal.core.models;

import com.gofortrainings.newsportal.core.service.AriticleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ArticleListModelTest {

    @Mock
    private Resource resource;

    @Mock
    private SlingHttpServletRequest request;

    @Mock
    private AriticleService ariticleService;

    private ArticleListModel model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new ArticleListModel();
    }

    @Test
    void testGetArticle() {
        // Mock behavior of the AriticleService
        when(ariticleService.getArticle()).thenReturn("Mocked article content");

        // Set the AriticleService instance to the model
        model.ariticleService = ariticleService;

        // Call the getArticle method and assert the result
        String result = model.getArticle();
        assertEquals("Mocked article content", result);
    }

    @Test
    void testGetUseServlet() {
        // Set the value of useServlet
        model.useServlet = true;

        // Call the getUseServlet method and assert the result
        boolean result = model.getUseServlet();
        assertEquals(true, result);
    }
}
