package fr.schoolbyhiit.portailformation.testData;

import fr.schoolbyhiit.portailformation.persistence.entity.Course;
import fr.schoolbyhiit.portailformation.web.dto.CourseDto;

import java.util.List;

public final class CourseTestData {

    private static final String COURSE_1_1 = "course_test_1_1";
    private static final String COURSE_1_2 = "course_test_1_2";
    private static final String REFEREE_1 = "teacher_1";
    private static final String REFEREE_2 = "teacher_2";
    private static final Long TOTAL_HOUR_COUNT_1 = 2L;
    private static final Long TOTAL_HOUR_COUNT_2 = 5L;

    public CourseTestData() {
    }

    public static List<Course> givenEntityList() {
        return List.of(CourseTestData.givenEntity(), CourseTestData.givenEntity2());
    }

    public static List<CourseDto> givenEntityListDto() {
        return List.of(CourseTestData.givenDto(), CourseTestData.givenDto2());
    }

    public static Course givenEntity() {
        return Course
                .builder()
                .name(COURSE_1_1)
                .totalHourCount(TOTAL_HOUR_COUNT_1)
                .referee(REFEREE_1)
                .build();
    }

    public static Course givenEntity2() {
        return Course
                .builder()
                .name(COURSE_1_2)
                .totalHourCount(TOTAL_HOUR_COUNT_2)
                .referee(REFEREE_2)
                .build();
    }

    public static CourseDto givenDto() {
        return CourseDto
                .builder()
                .name(COURSE_1_1)
                .totalHourCount(TOTAL_HOUR_COUNT_1)
                .referee(REFEREE_1)
                .build();
    }

    public static CourseDto givenDto2() {
        return CourseDto
                .builder()
                .name(COURSE_1_2)
                .totalHourCount(TOTAL_HOUR_COUNT_2)
                .referee(REFEREE_2)
                .build();
    }
}