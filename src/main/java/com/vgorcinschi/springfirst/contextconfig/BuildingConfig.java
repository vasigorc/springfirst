/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.contextconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author vgorcinschi
 */
@Configuration
@ComponentScan(basePackages={"com.vgorcinschi.springfirst.model",
    "com.vgorcinschi.springfirst.model.Stories"})
public class BuildingConfig {
     @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        PropertySourcesPlaceholderConfigurer pspC = new PropertySourcesPlaceholderConfigurer();
        pspC.setLocation(new ClassPathResource("/com/vgorcinschi/springfirst/app.properties"));
        return pspC;
    }
}
