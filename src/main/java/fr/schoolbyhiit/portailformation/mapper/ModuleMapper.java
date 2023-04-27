package fr.schoolbyhiit.portailformation.mapper;

import fr.schoolbyhiit.portailformation.persistence.entity.Module;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleDto toDto(Module module);

    Module toDao(ModuleDto module);
}