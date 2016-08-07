package com.pastsemester.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pastsemester")
public class WebAppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private static final String VIEWS = "/WEB-INF/views/";
    private static final String RESOURCES_HANDLER = "/assets/**";
    private static final String RESOURCES_LOCATION = "/assets/";

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
    }
//
////    @Bean
////    public ServletContextTemplateResolver servletContextTemplateResolver() {
////        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
////        templateResolver.setPrefix(VIEWS);
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode("HTML5");
////        new ServletContext()
////        return templateResolver;
////    }
//
//    @Bean
//    public SpringTemplateEngine springTemplateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.addTemplateResolver(springResourceTemplateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public ViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver vr = new ThymeleafViewResolver();
//        vr.setTemplateEngine(springTemplateEngine());
//        vr.setOrder(1);
//        vr.setCharacterEncoding("UTF-8");
//        vr.setViewNames(new String[]{"*.html"});
//        return vr;
//    }
//
//    @Bean()
//    public SpringResourceTemplateResolver springResourceTemplateResolver(){
//        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
//        springResourceTemplateResolver.setPrefix(VIEWS);
//        springResourceTemplateResolver.setSuffix(".html");
//        springResourceTemplateResolver.setTemplateMode("HTML5");
//        return springResourceTemplateResolver;
//    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix(VIEWS);
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

}