/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model;

import com.vgorcinschi.springfirst.model.Stories.Storey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author vgorcinschi
 */
@Component
public class Building {
    private String name;
    private String address;
    private Storey ground, first, second, third, fourth;

    public Building() {
    }

    @Autowired
    public Building(@Value("Montreal Startup") String name, @Value("200 Rene " +
"Levesque Ouest,\nMontreal, QC") String address, @Qualifier("ground") Storey ground) {
        this.name = name;
        this.address = address;
        this.ground = ground;
    }

    public Building(Storey ground, Storey first){
        this.name = "Montreal Startup";
        this.address = "200 Rene Levesque Ouest,\n" +
                "Montreal, QC";
        this.ground = ground;
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Storey getGround() {
        return ground;
    }

    public Storey getFirst() {
        return first;
    }

    public Storey getSecond() {
        return second;
    }

    public Storey getThird() {
        return third;
    }

    public Storey getFourth() {
        return fourth;
    }


    public void setFirst(Storey first) {
        this.first = first;
    }


    public void setSecond(Storey second) {
        this.second = second;
    }


    public void setThird(Storey third) {
        this.third = third;
    }


    public void setFourth(Storey fourth) {
        this.fourth = fourth;
    }
}
