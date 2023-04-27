package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.mapper.EventMapper;
import fr.schoolbyhiit.portailformation.persistence.EventRepository;
import fr.schoolbyhiit.portailformation.persistence.entity.Event;
import fr.schoolbyhiit.portailformation.web.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventDto createEvent(EventDto event) {
        Event eventDao = eventMapper.toDao(event);
        return eventMapper.toDto(eventRepository.save(eventDao));
    }

}
