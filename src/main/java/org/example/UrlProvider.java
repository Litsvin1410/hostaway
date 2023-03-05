package org.example;

import org.openqa.selenium.NotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UrlProvider {

    private Properties urlProperties = new Properties();

    private static final String BASE_URL = "base.url";
    private static final String ALL_LISTINGS_ENDPOINT = "all.listings";

    public String getBaseUrl() {
        return provideUrl(BASE_URL);
    }

    public String getAllListingsUrl() {
        return provideUrl(BASE_URL) + provideUrl(ALL_LISTINGS_ENDPOINT);
    }

    private void readUrlProperties() {
        try {
            InputStream input = new FileInputStream("src/main/resources/url.properties");
            urlProperties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String provideUrl(String propertyName) {
        if (urlProperties.isEmpty()) {
            readUrlProperties();
        }
        var value = urlProperties.get(propertyName);
        if (value == null) {
            throw new NotFoundException("Unable to find url for provided property name: " + propertyName);
        }
        return (String) value;
    }

}
