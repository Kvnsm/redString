package fr.schoolbyhiit.portailformation.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Mapper
public class CourseDto {

    private Long id;

    private String name;

    private String referee;

    private Long totalHourCount;

    private Long moduleId;
}
