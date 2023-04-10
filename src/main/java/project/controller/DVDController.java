package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import project.api.DVDAPI;
import project.dto.DVDDTO;
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
    public ResponseEntity<DVDDTO> create(DVDDTO dvdDTO, String loggedInUserName, String token) {
        DVDDTO dvddto1 = dvdService.create(dvdDTO);
        return new ResponseEntity<>(dvddto1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DVDDTO> findById(Long id, String loggedInUserName, String token) {
//        String loggedInUserRole = authenticationService.verifyToken(token, loggedInUserName);
//        if (Constants.EMPLOYEE.equals(loggedInUserRole) || Constants.CUSTOMER.equals(loggedInUserRole)) {
            return new ResponseEntity<>(dvdService.findById(id), HttpStatus.OK);
//        }
//        throw new VerificationRoleException();

    }

    @Override
    public ResponseEntity<List<DVDDTO>> findByAll(String loggedInUserName, String token) {
//        String loggedInUserRole = authenticationService.verifyToken(token, loggedInUserName);
//        if (Constants.EMPLOYEE.equals(loggedInUserRole) || Constants.CUSTOMER.equals(loggedInUserRole)) {
            return new ResponseEntity<>(dvdService.findAll(), HttpStatus.OK);
//        }
//        throw new VerificationRoleException();
    }



    @Override
    public ResponseEntity<String> delete(Long id, String loggedInUserName, String token) {
//        String loggedInUserRole = authenticationService.verifyToken(token, loggedInUserName);
//        authenticationService.verifyEmployeeRole(loggedInUserRole);
        dvdService.delete(id);
        return new ResponseEntity<>("DVD deleted", HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DVDDTO> update(Long id, DVDDTO dvdDTO, String loggedInUserName, String token) {
//        String loggedInUserRole = authenticationService.verifyToken(token, loggedInUserName);
//        authenticationService.verifyEmployeeRole(loggedInUserRole);
        return new ResponseEntity<>(dvdService.update(id, dvdDTO), HttpStatus.OK);
    }


}
