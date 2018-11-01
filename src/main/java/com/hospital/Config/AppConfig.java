package com.hospital.Config;

import com.hospital.Security.jwt.JwtTokenFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

@Configuration
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(JwtTokenFilter.class);
    }
}
