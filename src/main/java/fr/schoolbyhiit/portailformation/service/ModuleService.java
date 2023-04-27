package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailformation.mapper.ModuleMapper;
import fr.schoolbyhiit.portailformation.persistence.ModuleRepository;
import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleMapper moduleMapper;
    private final ModuleRepository moduleRepository;

    public ModuleDto findModuleById(Long id) throws ModuleNotFoundException {
        return moduleMapper.toDto(moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new));
    }

    public ModuleDto saveModule(ModuleDto moduleDto) {
        Module moduleEntity = moduleMapper.toDao(moduleDto);
        moduleEntity.getCourses().forEach(course -> course.setModule(moduleEntity));
        return moduleMapper.toDto(moduleRepository.save(moduleEntity));
    }

    public Page<ModuleDto> findAllModule(Pageable pageable) {
        return moduleRepository.findAll(pageable).map(moduleMapper::toDto);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

}
