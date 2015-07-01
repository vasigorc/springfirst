/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author vgorcinschi
 */
@Component
@Qualifier("circle")
public class CircularOffice extends Office{
    private final String shape;

    public CircularOffice() {
        super();
        this.shape = "Circle";
    }

    public CircularOffice(int ofNum){
        super();
        this.shape = "Circle";
        this.officeNumber = ofNum;
    }
    
    @Override
    public String getShape() {
        return shape;
    }
    
}
