package fr.schoolbyhiit.portailformation.web;

import fr.schoolbyhiit.portailformation.service.ModuleService;
import fr.schoolbyhiit.portailformation.web.dto.ModuleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("modules")
public class ModuleController {

    private final ModuleService moduleService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ModuleDto postModule(@RequestBody ModuleDto module) {
        return moduleService.saveModule(module);
    }

    @GetMapping(value = "/{id}")
    public ModuleDto getModule(@PathVariable("id") Long id) {
        return moduleService.findModuleById(id);
    }

    @GetMapping
    public Page<ModuleDto> getAllModule(
            @PageableDefault(size = 20) Pageable pageable,
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort) {
        if (pageable.isUnpaged()) {
            Page<ModuleDto> modules = moduleService.findAllModule(pageable);
            return new PageImpl<>(modules.toList(), pageable, modules.getTotalElements());
        } else {
            return moduleService.findAllModule(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteModule(@PathVariable("id") Long id) {
        moduleService.deleteModule(id);
    }
}
