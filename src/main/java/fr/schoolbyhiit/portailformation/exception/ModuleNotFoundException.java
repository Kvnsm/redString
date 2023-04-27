package fr.schoolbyhiit.portailformation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ModuleNotFoundException extends ResponseStatusException {
    public ModuleNotFoundException() {
            super(HttpStatus.NOT_FOUND, "Le module n'a pas été trouvé.");
    }
}
