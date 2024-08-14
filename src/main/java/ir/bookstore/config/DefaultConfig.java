package ir.bookstore.config;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;


import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

@Configuration
public class DefaultConfig {
    @Bean
     public MessageSource messageSource(){
         ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource
                 = new ReloadableResourceBundleMessageSource();
         reloadableResourceBundleMessageSource.setBasename("classpath:messages");
         reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
         return reloadableResourceBundleMessageSource;
     }
     @Bean
    public LocalValidatorFactoryBean getValidator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
     }
    @Bean
     public MessageSourceAccessor messageSourceAccessor(){
        return new MessageSourceAccessor(messageSource());
     }
    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        DataSource originalDataSource = dataSourceProperties.initializeDataSourceBuilder().build();

        return ProxyDataSourceBuilder
                .create(originalDataSource)
                .name("MyDS")
                .listener(new SLF4JQueryLoggingListener())  // This logs queries in multiple lines
                .build();
    }
}
