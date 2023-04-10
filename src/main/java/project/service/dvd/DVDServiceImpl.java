package project.service.dvd;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dto.DVDDTO;
import project.errorhandling.exception.DVDNotFoundException;
import project.errorhandling.exception.NumberOfPiecesException;
import project.errorhandling.exception.TitleCannotBeUpdatedException;
import project.mapper.DVDMapper;
import project.persistence.entity.DVDEntity;
import project.persistence.repository.DVDRepository;

@Service
public class DVDServiceImpl implements DVDService {
    private final DVDRepository dvdRepository;


    @Autowired
    public DVDServiceImpl(DVDRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }


    @Override
    public DVDDTO create(DVDDTO dvdDTO) {
        DVDEntity dvdEntity = DVDMapper.mapDTOToEntity(dvdDTO);
        return DVDMapper.mapEntityToDTO(dvdRepository.save(dvdEntity));
    }

    @Override
    public DVDDTO findById(String id) {
        Optional<DVDEntity> dvdEntity = dvdRepository.findById(id);
        if (dvdEntity.isPresent()) {
            return DVDMapper.mapEntityToDTO(dvdEntity.get());
        }
        throw new DVDNotFoundException(id);
    }

    @Override
    @Transactional
    public void delete(String id) {
        if (dvdRepository.existsById(id)) {
            dvdRepository.deleteById(id);
            return;
        }
        throw new DVDNotFoundException(id);
    }

    @Override
    public DVDDTO update(String  id, DVDDTO dvddto) {
        findById(id);
        if(dvddto.getTitle() != null){
            throw  new TitleCannotBeUpdatedException();
        }
        if(dvddto.getNumberOfPieces() > 0){
            DVDEntity dvdEntity = DVDMapper.mapDTOToEntity(dvddto);
            dvdEntity.setId(id);
            DVDEntity updateEntity = dvdRepository.save(dvdEntity);
            return DVDMapper.mapEntityToDTO(updateEntity);
        }
        throw new NumberOfPiecesException();

    }

    @Override
    public DVDDTO findByTitle(String title) {

        Optional<DVDEntity> dvdEntity = dvdRepository.findByTitle(title);
        if (dvdEntity.isPresent()) {
            return DVDMapper.mapEntityToDTO(dvdEntity.get());
        }
        throw new DVDNotFoundException(title);

    }

    @Override
    public boolean existsByTitle(String title) {
        Optional<DVDEntity> dvdEntity = dvdRepository.findByTitle(title);
        return dvdEntity.isPresent();
    }

    @Override
    public List<DVDDTO> findAll() {
        return DVDMapper.mapEntityListToDTOList(dvdRepository.findAll());
    }
}
