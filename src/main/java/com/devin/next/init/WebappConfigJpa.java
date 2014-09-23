package com.devin.next.init;

import javax.sql.DataSource;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.devin.next")
@EnableWebMvc
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class WebappConfigJpa extends WebMvcConfigurerAdapter {

  @Autowired
  Environment env;
  
  
  //Tell SpingMVC where to find view scripts
  @Bean
  public InternalResourceViewResolver setupViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");

    return resolver;
  }
  
  //Enable serving static resources even when DispatcherServlet is mapped to /  
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
  
  //Enable accessing entityManager from view scripts. Required when using lazy loading 
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
    interceptor.setEntityManagerFactory(entityManagerFactory().getObject());
    registry.addWebRequestInterceptor(interceptor);
  }
  

  //Set up dataSource to be used by Hibernate. Also make sure the connection doesn't go down
  @Bean
  public DataSource getDataSource() {
    //Somewhat simpler, but not recommended for production use.
//    DriverManagerDataSource ds = new DriverManagerDataSource(env.getProperty("url"));
//    ds.setDriverClassName(env.getProperty("driver"));
//    ds.setUsername(env.getProperty("user"));
//    ds.setPassword(env.getProperty("pass"));
    
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(env.getProperty("url"));
    ds.setDriverClassName(env.getProperty("driver"));
    ds.setUsername(env.getProperty("user"));
    ds.setPassword(env.getProperty("pass"));
    ds.setValidationQueryTimeout(5);
    ds.setValidationQuery("select 1 from owner");

    return ds;
  }
  

  //Set up JPA and transactionManager
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {    
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(getDataSource());
    emf.setPackagesToScan("com.devin.next.model");
    emf.getJpaPropertyMap().put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();    
    emf.setJpaVendorAdapter(va);    
    return emf;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager() {    
    JpaTransactionManager tm = new JpaTransactionManager(entityManagerFactory().getObject());    
    return tm;
  }


}
