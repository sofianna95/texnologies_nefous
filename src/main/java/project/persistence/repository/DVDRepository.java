package project.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.persistence.entity.DVDEntity;

@Repository
public interface DVDRepository extends CrudRepository<DVDEntity, Long> {

    Optional<DVDEntity> findByTitle(String title);

    Optional<DVDEntity> findById(String id);

   boolean existsById(String id);

    void deleteById(String  id);

    List<DVDEntity> findAll();
}
