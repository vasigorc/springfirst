/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.springfirst.model;

import java.time.LocalTime;

/**
 *
 * @author vgorcinschi
 */
public abstract class Office {
    private final LocalTime ELECTRICITY_ON = LocalTime.of(6, 0);
    private final LocalTime ELECTRICITY_OFF = LocalTime.of(19, 0);
    //square meters are implied
    private final double AREA = 400.0;
    private final boolean CONFERENCE_ROOM = true;
    private final boolean RECEPTION = true;
    private boolean wifi;
    protected int officeNumber;
    
    /** Construct a default office*/    
    protected Office() {
    }

    /**
     @return if whenever method is called to know if currently wifi is on.
     * It will only be on, when Electricity is on.
     */
    public boolean isWifi() {
        wifi = !(LocalTime.now().isAfter(ELECTRICITY_OFF)||LocalTime.now().isBefore(ELECTRICITY_ON));
        return wifi;
    }

    public LocalTime getELECTRICITY_ON() {
        return ELECTRICITY_ON;
    }

    public LocalTime getELECTRICITY_OFF() {
        return ELECTRICITY_OFF;
    }

    public double getAREA() {
        return AREA;
    }

    public boolean isCONFERENCE_ROOM() {
        return CONFERENCE_ROOM;
    }

    public boolean isRECEPTION() {
        return RECEPTION;
    }  

    /** we want to force this method to be overriden by every concrete 
     *office
     * @return shape peculiar to each floor*/
    public abstract String getShape();

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }
}
