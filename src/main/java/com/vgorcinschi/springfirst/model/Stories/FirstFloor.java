/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model.Stories;

import com.vgorcinschi.springfirst.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author vgorcinschi
 */
@Qualifier("first")
public class FirstFloor implements Storey{
    private List<Office> offices;

    public FirstFloor(List<Office> offices) {
        this.offices = offices;
    }

    @Override
    public List<Office> getOffices(){
        return offices;
    }
}
