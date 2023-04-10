package project.service.dvd;

import java.util.List;
import project.dto.DVDDTO;

public interface DVDService {

    DVDDTO create(DVDDTO dvdDTO);

    DVDDTO findById(String id);

    void delete(String id);

    DVDDTO update(String id, DVDDTO dvddto);

    DVDDTO findByTitle(String title);

    boolean existsByTitle(String title);



    List<DVDDTO> findAll();
}