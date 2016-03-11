package com.tutorial.spring.boot.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
@PropertySource(value = { "classpath:application.properties" })
public class Config extends AbstractCouchbaseConfiguration {

	@Value("${hosts:localhost}")
	private String couchbaseHosts;
	
	@Value("${bucketName:default}")
	private String bucketName;
	
	@Value("${bucketPassword:}")
	private String bucketPassword;
	
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(couchbaseHosts);
    }
	
    protected String getBucketName() {
        return this.bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return this.bucketPassword;
    }

    /*
     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
     * Remove this bean if you are not using @Value annotations for injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}