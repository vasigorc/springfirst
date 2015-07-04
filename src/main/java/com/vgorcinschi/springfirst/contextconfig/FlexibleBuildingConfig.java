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
import com.vgorcinschi.springfirst.model.Stories.ThirdFloor;
import com.vgorcinschi.springfirst.model.TriangularOffice;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/vgorcinschi/springfirst/app.properties")
public class FlexibleBuildingConfig {
    
    @Autowired
    Environment env;

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
    @Profile("threeFloors")    
    public List<Office> getTriangularOffices(){
        List<Office> ofs = new ArrayList<>();
        ofs.add(new TriangularOffice(301));
        ofs.add(new TriangularOffice(302));
        ofs.add(new TriangularOffice(303));
        return ofs;
    }
    
    @Bean
    @Profile("threeFloors")
    @Conditional(SystemEnabledFloor.class)
    public ThirdFloor thirdFloor(){
        return new ThirdFloor(getTriangularOffices());
    }
    
    @Bean
    @Profile("twoFloors")
    public Building smallerBuilding(){
        return new Building(groundFloor(),firstFloor(),
                env.getProperty("building.name"), env.getProperty("building.address"));
    }
    
    @Bean
    @Profile("threeFloors")
    public Building biggerBuilding(){
        Building muilding = new Building(groundFloor(),firstFloor(), 
                env.getProperty("building.name"), env.getProperty("building.address"));
        muilding.setSecond(secondFloor());
        return muilding;
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
