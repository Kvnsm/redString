package fr.schoolbyhiit.portailformation.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Mapper
public class ModuleDto {

    private Long id;

    private String name;

    private List<CourseDto> courses;
}
