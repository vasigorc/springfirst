/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.contextconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author vgorcinschi
 */

public class SystemEnabledFloor implements Condition{

    @Override
    public boolean matches(ConditionContext cc, AnnotatedTypeMetadata atm) {
        Environment env = cc.getEnvironment();
        return env.containsProperty("build.fourth.floor");
    }
    
}
