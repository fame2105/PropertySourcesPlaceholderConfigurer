package com.fame.readingpropertySource.externalpropertySourceFile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.fame.readingpropertySource.externalpropertySourceFile.dataSource.FakeDataSource;
import com.fame.readingpropertySource.externalpropertySourceFile.dataSource.JMSDataSource;

/**
 * Created by fame.issrani on 6/30/18.
 */
@Configuration
//Following are the two ways of importing the properties file in the context.
//@PropertySource({"classpath:dataSource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:dataSource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    private Environment env;

    @Value("${user.username}")
    String user;
    
    @Value("${user.password}")
    String password;

    @Value("${jms.username}")
    String jmsUserName;

    @Value("${jms.password}")
    String jmsPassword;

    @Bean
    public FakeDataSource fakeDataSource() {
        System.out.println(env.getProperty("MY_VAR"));   //Environment_Variable with the key "MY_VAR" is provided
        // in the run time config.
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(this.user);
        fakeDataSource.setPassword(this.password);
        return fakeDataSource;
    }

    @Bean
    public JMSDataSource jmsDataSource(){
        JMSDataSource jmsDataSource = new JMSDataSource();
        jmsDataSource.setUserName(jmsUserName);
        jmsDataSource.setPassword(jmsPassword);
        return jmsDataSource;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new
                PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
