package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailformation.mapper.CourseMapper;
import fr.schoolbyhiit.portailformation.mapper.CourseMapperImpl;
import fr.schoolbyhiit.portailformation.persistence.CourseRepository;
import fr.schoolbyhiit.portailformation.persistence.entity.Course;
import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import fr.schoolbyhiit.portailformation.web.dto.CourseDto;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Disabled
public class CourseServiceTest {

    private static final String MODULE = "module";
    private static final String COURSE = "course";
    private static final String REFEREE = "referee";
    private static final Long TOTAL_HOUR_COUNT = 10L;

    private static Module givenModule() {
        return Module.builder()
                .id(1L)
                .name(MODULE)
                .build();
    }

    private static Course givenCourse() {
        return Course.builder()
                .name(COURSE)
                .referee(REFEREE)
                .totalHourCount(TOTAL_HOUR_COUNT)
                .module(givenModule())
                .build();
    }

    private static CourseDto givenCourseDto() {
        return CourseDto.builder()
                .name(COURSE)
                .referee(REFEREE)
                .totalHourCount(TOTAL_HOUR_COUNT)
                .moduleId(givenModule().getId())
                .build();
    }

    @Mock
    private CourseRepository courseRepository;
    @Mock
    private ModuleService moduleService;
    @Spy
    private CourseMapper courseMapper = new CourseMapperImpl();
    @InjectMocks
    private CourseService courseService;

    @Test
    void shouldCreateAndReturnCourse() {
        ModuleDto givenModuleDto = ModuleDto.builder()
                .id(1L)
                .name(MODULE)
                .build();
        when(courseRepository.save(any(Course.class))).thenReturn(givenCourse());
        when(moduleService.findModuleById(anyLong())).thenReturn(givenModuleDto);

        CourseDto createdCourseDto = courseService.createCourse(givenCourseDto());

        assertThat(createdCourseDto).isEqualTo(givenCourseDto());
    }

    @Test
    void createCourseModuleNotFoundException() {
        when(moduleService.findModuleById(anyLong())).thenReturn(isNull());

        assertThatExceptionOfType(ModuleNotFoundException.class)
                .isThrownBy(() -> courseService.createCourse(givenCourseDto())
                );
    }
}
