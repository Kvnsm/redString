package fr.schoolbyhiit.portailformation.mapper;

import fr.schoolbyhiit.portailformation.persistence.entity.Event;
import fr.schoolbyhiit.portailformation.web.dto.EventDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(Event event);

    Event toDao(EventDto event);
}
