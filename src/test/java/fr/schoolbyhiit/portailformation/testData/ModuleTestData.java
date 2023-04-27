package fr.schoolbyhiit.portailformation.testData;

import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static fr.schoolbyhiit.portailformation.testData.CourseTestData.givenDto;
import static fr.schoolbyhiit.portailformation.testData.CourseTestData.givenDto2;
import static fr.schoolbyhiit.portailformation.testData.CourseTestData.givenEntityList;
import static fr.schoolbyhiit.portailformation.testData.CourseTestData.givenEntityListDto;

public class ModuleTestData {
    private static final String MODULE_TEST_1 = "module_test_1";
    private static final String MODULE_TEST_2 = "module_test_2";

    public ModuleTestData() {
    }

    public static Module givenEntity() {
        return Module.builder()
                .id(1L)
                .name(MODULE_TEST_1)
                .courses(givenEntityList())
                .build();
    }

    public static ModuleDto givenDtoEntity() {
        return ModuleDto.builder()
                .id(1L)
                .name(MODULE_TEST_1)
                .courses(List.of(givenDto(), givenDto2()))
                .build();
    }

    public static Page<Module> givenListEntityModule(Pageable pageable) {
        List<Module> content = List.of(
                Module.builder()
                        .id(1L)
                        .name(MODULE_TEST_1)
                        .courses(givenEntityList())
                        .build(),
                Module.builder()
                        .id(2L)
                        .name(MODULE_TEST_2)
                        .courses(givenEntityList())
                        .build());
        return new PageImpl<>(content, pageable, content.size());
    }

    public static Page<ModuleDto> givenListEntityModuleDto(Pageable pageable) {
        List<ModuleDto> content = List.of(
                ModuleDto.builder()
                        .id(1L)
                        .name(MODULE_TEST_1)
                        .courses(givenEntityListDto())
                        .build(),
                ModuleDto.builder()
                        .id(2L)
                        .name(MODULE_TEST_2)
                        .courses(givenEntityListDto())
                        .build());
        return new PageImpl<>(content, pageable, content.size());
    }
}