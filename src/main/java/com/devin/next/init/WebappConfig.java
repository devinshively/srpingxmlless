package com.devin.next.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * User: dshively
 * Created On: 9/15/14 2:18 PM
 */
@Configuration
@ComponentScan("com.devin.next")
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class WebappConfig extends WebMvcConfigurerAdapter {

    @Autowired Environment env;

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(destroyMethod = "close")
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource(env.getProperty("url"));
        ds.setDriverClassName(env.getProperty("driver"));
        ds.setUsername(env.getProperty("user"));
        ds.setPassword(env.getProperty("pass"));
        return ds;
    }

}
