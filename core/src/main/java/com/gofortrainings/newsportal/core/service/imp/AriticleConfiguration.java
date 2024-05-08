package com.gofortrainings.newsportal.core.service.imp;

import org.apache.sling.caconfig.annotation.Configuration;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "task1", description = "this is my task1")

public @interface AriticleConfiguration {
    @AttributeDefinition String api() default "https://gorest.co.in/public/v2/posts";
}
