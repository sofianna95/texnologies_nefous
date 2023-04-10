package project.controller;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import project.api.DVDAPI;
import project.dto.DVDDTO;
import project.errorhandling.exception.DVDAlreadyExistsException;
import project.errorhandling.exception.DVDNotFoundException;
import project.errorhandling.exception.NumberOfPiecesException;
import project.service.dvd.DVDService;

import java.util.List;

@RestController
public class DVDController implements DVDAPI {

    private final DVDService dvdService;


    @Autowired
    public DVDController(DVDService dvdService) {
        this.dvdService = dvdService;
    }


    @Override
    public ResponseEntity<DVDDTO> create(DVDDTO dvdDTO) {
        if (!dvdService.existsByTitle(dvdDTO.getTitle())) {
            if (dvdDTO.getNumberOfPieces() > 0) {
                DVDDTO dvddto1 = dvdService.create(dvdDTO);
                return new ResponseEntity<>(dvddto1, HttpStatus.CREATED);
            }
            throw new NumberOfPiecesException();

        }
        throw new DVDAlreadyExistsException(dvdDTO.getTitle());
    }

    @Override
    public ResponseEntity<List<DVDDTO>> search(String title, String id) {
        if (title == null && id == null  ) {
            return new ResponseEntity<>(dvdService.findAll(), HttpStatus.OK);
        } else if (title != null && id == null) {
            return new ResponseEntity<>(List.of(dvdService.findByTitle(title)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(List.of(dvdService.findById(id)), HttpStatus.OK);
        }
    }


    @Override
    public ResponseEntity<String> delete(String id) {
        dvdService.delete(id);
        return new ResponseEntity<>("DVD deleted", HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DVDDTO> update(String id, DVDDTO dvdDTO) {
        return new ResponseEntity<>(dvdService.update(id, dvdDTO), HttpStatus.OK);
    }


}
