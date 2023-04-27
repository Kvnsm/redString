package fr.schoolbyhiit.portailformation.mapper;

import fr.schoolbyhiit.portailformation.persistence.entity.Course;
import fr.schoolbyhiit.portailformation.web.dto.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "moduleId", source = "module.id")
    CourseDto toDto(Course course);

    @Mapping(target = "module.id", source = "moduleId")
    Course toEntity(CourseDto courseDto);
}
