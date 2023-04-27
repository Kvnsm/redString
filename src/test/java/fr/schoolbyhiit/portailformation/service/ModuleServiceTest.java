package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailformation.mapper.ModuleMapper;
import fr.schoolbyhiit.portailformation.mapper.ModuleMapperImpl;
import fr.schoolbyhiit.portailformation.persistence.ModuleRepository;
import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static fr.schoolbyhiit.portailformation.testData.ModuleTestData.givenDtoEntity;
import static fr.schoolbyhiit.portailformation.testData.ModuleTestData.givenEntity;
import static fr.schoolbyhiit.portailformation.testData.ModuleTestData.givenListEntityModule;
import static fr.schoolbyhiit.portailformation.testData.ModuleTestData.givenListEntityModuleDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Disabled
class ModuleServiceTest {

    @Mock
    private ModuleRepository moduleRepository;
    @Spy
    private ModuleMapper moduleMapperMock = new ModuleMapperImpl();

    @InjectMocks
    private ModuleService moduleService;

    @Test
    public void addModuleTest() {
        // Given
        ModuleDto moduleDto = givenDtoEntity();
        Module module = givenEntity();

        // When
        when(moduleRepository.save(any(Module.class))).thenReturn(module);

        ModuleDto actual = moduleService.saveModule(moduleDto);


        // Then
        assertThat("module_test_1").isEqualTo(module.getName());
        assertThat("module_test_1").isEqualTo(actual.getName());
        assertThat(1L).isEqualTo(module.getId());
        assertThat(1L).isEqualTo(actual.getId());
        assertThat("course_test_1_1").isEqualTo(module.getCourses().get(0).getName());
        assertThat("course_test_1_1").isEqualTo(actual.getCourses().get(0).getName());
    }

    @Test
    void findModuleByIdWorks() {
        // given
        when(moduleRepository.findById(anyLong())).thenReturn(Optional.of(givenEntity()));
        when(moduleMapperMock.toDto(givenEntity())).thenReturn(givenDtoEntity());

        // when
        ModuleDto actual = moduleService.findModuleById(1L);

        // then
        assertThat(actual).isEqualTo(givenDtoEntity());
    }

    @Test
    void findModuleByIdNotFoundException() {
        // given
        when(moduleRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThatExceptionOfType(ModuleNotFoundException.class)
                .isThrownBy(() -> moduleService.findModuleById(1L));
    }

    @Test
    void findAllModule() {
        //given
        int page = 0;
        int size = 20;
        Pageable pageable = PageRequest.of(page, size);
        when(moduleRepository.findAll(pageable)).thenReturn(givenListEntityModule(pageable));

        //when
        Page<ModuleDto> actual = moduleService.findAllModule(pageable);

        //then
        assertThat(actual).isEqualTo(givenListEntityModuleDto(pageable));
        assertThat(actual.getPageable().getPageSize()).isEqualTo(size);
    }

    @Test
    void findAllModuleUnPaged() {
        //given
        Pageable pageable = Pageable.unpaged();
        when(moduleRepository.findAll(pageable)).thenReturn(givenListEntityModule(pageable));

        //when
        Page<ModuleDto> actual = moduleService.findAllModule(pageable);

        //then
        assertThat(actual).isEqualTo(givenListEntityModuleDto(pageable));
    }

    @Test
    public void deleteModuleTest() {
        // When
        moduleService.deleteModule(4L);
        // Then
        verify(moduleRepository, times(1)).deleteById(eq(4L));
    }
}