package fr.schoolbyhiit.portailformation;

import fr.schoolbyhiit.portailformation.web.CourseController;
import fr.schoolbyhiit.portailformation.web.EventController;
import fr.schoolbyhiit.portailformation.web.ModuleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Disabled
class PortailFormationApplicationTests {

    @Autowired
    private ModuleController moduleController;

    @Autowired
    private CourseController courseController;

    @Autowired
    private EventController eventController;

    @Test
    void contextLoads() {
        assertThat(moduleController).isNotNull();
        assertThat(courseController).isNotNull();
        assertThat(eventController).isNotNull();
    }

}
