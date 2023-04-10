package project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import project.persistence.entity.DVDEntity;
import project.persistence.repository.DVDRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class DataBaseInit {

    private final DVDRepository dvdRepository;

    public DataBaseInit(DVDRepository dvdRepository) throws IOException {
        this.dvdRepository = dvdRepository;
        insertDVDsFromFile();
    }

    private void insertDVDsFromFile() throws IOException {
        List<DVDEntity> dvdRepositoryAll = dvdRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        InputStream inJson = DataBaseInit.class.getResourceAsStream("/dvds/dvds.json");


        List<DVDEntity> dvdEntities = Arrays.asList(objectMapper.readValue(inJson, DVDEntity[].class));
        if (dvdRepositoryAll.isEmpty()) {
            dvdRepository.saveAll(dvdEntities);
        }

    }

}
