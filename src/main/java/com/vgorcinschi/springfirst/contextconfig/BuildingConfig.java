/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.contextconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author vgorcinschi
 */
@Configuration
@ComponentScan(basePackages={"com.vgorcinschi.springfirst.model",
    "com.vgorcinschi.springfirst.model.Stories"})
public class BuildingConfig {
    
}
