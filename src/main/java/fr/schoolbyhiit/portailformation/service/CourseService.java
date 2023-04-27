package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.exception.ModuleNotFoundException;
import fr.schoolbyhiit.portailformation.mapper.CourseMapper;
import fr.schoolbyhiit.portailformation.persistence.CourseRepository;
import fr.schoolbyhiit.portailformation.web.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;
    private final ModuleService moduleService;

    public CourseDto createCourse(CourseDto courseDto) {
        if (null != moduleService.findModuleById(courseDto.getModuleId())) {
            return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDto)));
        } else {
            throw new ModuleNotFoundException();
        }
    }
}
