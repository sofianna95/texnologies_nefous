package project.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.dto.DVDDTO;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/dvd-managmement")
@Tag(name = "DVDs")
public interface DVDAPI {


    @PostMapping("/dvds/create")
    ResponseEntity<DVDDTO> create(@Valid @RequestBody DVDDTO dvdDTO);

    @GetMapping("dvds")
    ResponseEntity<List<DVDDTO> > search(@RequestParam(required = false) String title,@RequestParam(required = false) String id);


    @DeleteMapping("{id}/delete")
    ResponseEntity<String> delete(@PathVariable("id") String id);


    @PutMapping("/dvds/{id}")
    ResponseEntity<DVDDTO> update(@PathVariable("id") String id, @RequestBody DVDDTO dvdDTO);

}

