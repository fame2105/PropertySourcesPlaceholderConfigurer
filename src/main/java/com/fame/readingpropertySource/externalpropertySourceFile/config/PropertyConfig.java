package com.fame.readingpropertySource.externalpropertySourceFile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.fame.readingpropertySource.externalpropertySourceFile.dataSource.FakeDataSource;

/**
 * Created by fame.issrani on 6/30/18.
 */
@Configuration
@PropertySource("classpath:dataSource.properties")
public class PropertyConfig {

    @Value("${user.username}")
    String user;
    
    @Value("${user.password}")
    String password;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(this.user);
        fakeDataSource.setPassword(this.password);
        return fakeDataSource;
    }
    

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new
                PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
