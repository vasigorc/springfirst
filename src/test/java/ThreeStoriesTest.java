/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vgorcinschi.springfirst.contextconfig.FlexibleBuildingConfig;
import com.vgorcinschi.springfirst.model.*;
import com.vgorcinschi.springfirst.model.Stories.Storey;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={FlexibleBuildingConfig.class})
@ActiveProfiles("threeFloors")
public class ThreeStoriesTest {
    
    @Autowired
    private Building building;
    
    @Autowired
    @Qualifier("second")
    private Storey secondOne;
    
    @Autowired
    @Qualifier("third")
    private Storey theThird;
    
    @Test
    public void anyConfRooms(){
        assertTrue(secondOne.getOffices().get(2).isCONFERENCE_ROOM());
    }
    
    /*
    This is a recall from the 
    two stories' test
    */
    @Test
    public void checkShape(){
        assertEquals("Circle", building.getGround().getOffices().get(0).getShape());
    }
    
    //Check if the wiFi is on in Office 201 at the moment of test run
    @Test
    public void testWiFiIn201(){
        assertTrue(building.getFirst().getOffices().get(1).isWifi());
    }
    
    @Test
    public void testFourthFloor(){
        assertNotNull(theThird);
    }
    
    @Test
    public void verifyAddy(){
        assertEquals("200 Rene Levesque Ouest, Montreal, QC", building.getAddress());
    }
}
