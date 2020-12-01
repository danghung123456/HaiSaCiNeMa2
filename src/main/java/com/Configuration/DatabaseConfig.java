package com.Configuration;

import com.sun.istack.NotNull;
import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class DatabaseConfig {
@NotNull
	private String url;

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}


}