package com.vgorcinschi.springfirst.contextconfig;

/**
 * Created by V_GORCIN on 6/30/2015.
 */

import com.vgorcinschi.springfirst.model.Building;
import com.vgorcinschi.springfirst.model.CircularOffice;
import com.vgorcinschi.springfirst.model.SquareOffice;
import com.vgorcinschi.springfirst.model.Stories.FirstFloor;
import com.vgorcinschi.springfirst.model.Stories.GroundFloor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.vgorcinschi.springfirst.model.Office;
import com.vgorcinschi.springfirst.model.RectangularOffice;
import com.vgorcinschi.springfirst.model.Stories.SecondFloor;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FlexibleBuildingConfig {

    @Bean
    @Profile({"twoFloors", "threeFloors"})
    public List<Office> getCircularOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new CircularOffice(001));
        ofs.add(new CircularOffice(002));
        ofs.add(new CircularOffice(003));
        return ofs;
    }

    @Bean
    @Profile({"twoFloors", "threeFloors"})
    public GroundFloor groundFloor(){
        return new GroundFloor(getCircularOffices());
    }

    @Bean
    @Profile({"twoFloors", "threeFloors"})
    public List<Office> getSquareOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new SquareOffice(101));
        ofs.add(new SquareOffice(102));
        ofs.add(new SquareOffice(103));
        return ofs;
    }

    @Bean
    @Profile({"twoFloors", "threeFloors"})
    public FirstFloor firstFloor(){
        return new FirstFloor(getSquareOffices());
    }

    @Bean
    @Profile("threeFloors")
    public List<Office> getRectangularOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new RectangularOffice(201));
        ofs.add(new RectangularOffice(202));
        ofs.add(new RectangularOffice(203));
        return ofs;
    }
   
    @Bean
    @Profile("threeFloors")
    public SecondFloor secondFloor(){
        return new SecondFloor(getRectangularOffices());
    }
    
    @Bean
    @Profile("twoFloors")
    public Building smallerBuilding(){
        return new Building(groundFloor(),firstFloor());
    }
    
    @Bean
    @Profile("threeFloors")
    public Building biggerBuilding(){
        Building muilding = new Building(groundFloor(),firstFloor());
        muilding.setSecond(secondFloor());
        return muilding;
    }
}
