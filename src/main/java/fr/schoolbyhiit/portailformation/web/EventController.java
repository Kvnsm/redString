package fr.schoolbyhiit.portailformation.web;

import fr.schoolbyhiit.portailformation.service.EventService;
import fr.schoolbyhiit.portailformation.web.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    @PostMapping
    public EventDto createEvent(@RequestBody EventDto event){
        return eventService.createEvent(event);
    }
}
