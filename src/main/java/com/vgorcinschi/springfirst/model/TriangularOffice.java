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
@Qualifier("triangle")
public class TriangularOffice extends Office{
    private final String shape;

    public TriangularOffice() {
        super();
        this.shape = "Triangle";
    }

    public TriangularOffice(int ofNum){
        super();
        this.shape = "Triangle";
        this.officeNumber = ofNum;
    }

    @Override
    public String getShape() {
        return shape;
    }
    
}
