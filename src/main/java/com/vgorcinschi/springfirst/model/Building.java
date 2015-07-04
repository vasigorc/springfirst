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
    private String owner;

    public Building() {
    }

    @Autowired
    public Building(@Value("${building.name}")String name, @Value("200 Rene " +
"Levesque Ouest,\nMontreal, QC") String address, 
            @Qualifier("ground") Storey ground, @Value("${building.owner}")String owner) {
        this.name = name;
        this.address = address;
        this.ground = ground;
        this.owner = owner;
    }

    public Building(Storey ground, Storey first, String name, String address){
        this.ground = ground;
        this.first = first;
        this.name = name;
        this.address = address;
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

    public String getOwner() {
        return owner;
    }
}
