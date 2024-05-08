package com.gofortrainings.newsportal.core.service.imp;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class AriticleServiceImpTest {

    AriticleServiceImp articleService = new AriticleServiceImp();
    @Mock
    AriticleConfiguration config;

    AriticleServiceImp articleServiceImp = new AriticleServiceImp();

    AemContext context = new AemContext();


    @Test
    void testData() {
        articleServiceImp.activate(config);
        articleService.getLink = "https://gorest.co.in/public/v2/posts";
        articleService.getArticle();


    }

}
