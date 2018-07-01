package com.fame.readingpropertySource.externalpropertySourceFile.dataSource;

import org.springframework.stereotype.Component;

/**
 * Created by fame.issrani on 6/30/18.
 */
public class FakeDataSource {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
