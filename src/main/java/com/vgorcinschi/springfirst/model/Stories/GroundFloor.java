/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model.Stories;

import com.vgorcinschi.springfirst.model.Office;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author vgorcinschi
 */

@Component
@Qualifier("ground")
public class GroundFloor implements Storey {
    private List <Office> offices;

    public GroundFloor(){}
    
    public GroundFloor(List <Office> offices) {
        this.offices = offices;
    }

    @Override
    public List<Office> getOffices(){
        return offices;
    }
}
