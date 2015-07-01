
import com.vgorcinschi.springfirst.contextconfig.BuildingConfig;
import com.vgorcinschi.springfirst.model.Building;
import com.vgorcinschi.springfirst.model.Stories.Storey;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.vgorcinschi.springfirst.contextconfig.FlexibleBuildingConfig;
/**
/**
 * Created by V_GORCIN on 6/30/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={FlexibleBuildingConfig.class})
@ActiveProfiles("twoFloors")
public class TwoStoriesTest {

    @Autowired
    private Building building;

    @Test
    public void checkShape(){
        assertEquals("Circle", building.getGround().getOffices().get(0).getShape());
    }
}
