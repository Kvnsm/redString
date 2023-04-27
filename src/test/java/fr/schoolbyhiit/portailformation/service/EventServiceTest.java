package fr.schoolbyhiit.portailformation.service;

import fr.schoolbyhiit.portailformation.mapper.EventMapper;
import fr.schoolbyhiit.portailformation.persistence.EventRepository;
import fr.schoolbyhiit.portailformation.persistence.entity.Event;
import fr.schoolbyhiit.portailformation.web.dto.EventDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private EventMapper eventMapper;

    @InjectMocks
    private EventService eventService;

    @Test
    @Disabled
    public void createEventTest() {

        EventDto eventDto = new EventDto();
        Event event = new Event();
        when(eventMapper.toDao(eventDto)).thenReturn(event);
        when(eventRepository.save(event)).thenReturn(event);

        EventDto resultEventTest = eventService.createEvent(eventDto);

        verify(eventRepository, times(1)).save(event);
    }
}