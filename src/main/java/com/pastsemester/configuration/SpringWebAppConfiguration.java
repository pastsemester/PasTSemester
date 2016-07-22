package com.pastsemester.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adisor on 7/22/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.pastsemester.web", "com.pastsemester.service", "com"})
public class SpringWebAppConfiguration {

}
