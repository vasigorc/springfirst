/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vgorcinschi.springfirst.contextconfig.BuildingConfig;
import com.vgorcinschi.springfirst.model.Building;
import com.vgorcinschi.springfirst.model.Stories.Storey;

import org.junit.Test;
import static org.junit.Assert.*;
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
@ContextConfiguration(classes={BuildingConfig.class})
@ActiveProfiles("twoFloors")
public class OneStoreyTest {
    
    @Autowired
    private Building building;
    
    @Autowired
    @Qualifier("ground")
    private Storey storey;
    
    @Test
    public void groundSThere(){
        assertNotNull(storey);
    }
    
    @Test
    public void checkOwner(){
        assertEquals("Elena Todorasco", building.getOwner());
    }
}
