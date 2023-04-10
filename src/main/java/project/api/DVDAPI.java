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
    ResponseEntity<DVDDTO> create(@Valid @RequestBody DVDDTO dvdDTO, @RequestHeader("loggedInUserName") String loggedInUserName,
            @RequestHeader("token") String token);

    @GetMapping("dvds/{id}")
    ResponseEntity<DVDDTO> findById(Long id, @RequestHeader("loggedInUserName") String loggedInUserName,
            @RequestHeader("token") String token);

    @GetMapping("dvds")
    ResponseEntity<List<DVDDTO>> findByAll(@RequestHeader("loggedInUserName") String loggedInUserName,
            @RequestHeader("token") String token);

    @DeleteMapping("{id}/delete")
    ResponseEntity<String> delete(@PathVariable("id") Long id, @RequestHeader("loggedInUserName") String loggedInUserName,
            @RequestHeader("token") String token);


    @PutMapping("/dvds/{id}")
    ResponseEntity<DVDDTO> update(@PathVariable("id") Long id, @RequestBody DVDDTO dvdDTO, @RequestHeader("loggedInUserName") String loggedInUserName,
            @RequestHeader("token") String token);

}

