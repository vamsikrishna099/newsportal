package com.gofortrainings.newsportal.core.service;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;


public interface RssConfig {
    @Property(label = "Rss Path", description = "Define RSS page path")
    String rssPath();
}
