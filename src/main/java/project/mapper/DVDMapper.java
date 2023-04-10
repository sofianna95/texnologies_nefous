package project.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import project.dto.DVDDTO;
import project.persistence.entity.DVDEntity;

public class DVDMapper {


    public static DVDDTO mapEntityToDTO(DVDEntity dvdEntity) {
        DVDDTO dvddto = new DVDDTO();

        dvddto.setId(dvdEntity.getId());
        dvddto.setTitle(dvdEntity.getTitle());
        dvddto.setType(dvdEntity.getType());
        dvddto.setNumberOfPieces(dvdEntity.getNumberOfPieces());


        return dvddto;
    }

    public static DVDEntity mapDTOToEntity(DVDDTO dvddto) {
        DVDEntity dvdEntity = new DVDEntity();

        dvdEntity.setId(dvddto.getId());
        dvdEntity.setTitle(dvddto.getTitle());
        dvdEntity.setType(dvddto.getType());
        dvdEntity.setNumberOfPieces(dvddto.getNumberOfPieces());

        return dvdEntity;
    }

    public static List<DVDDTO> mapEntityListToDTOList(List<DVDEntity> dvdEntities) {
        List<DVDDTO> dvddtos = new ArrayList<>();
        for (DVDEntity dvdEntity : dvdEntities) {
            dvddtos.add(mapEntityToDTO(dvdEntity));
        }
        return dvddtos;
    }

    public static List<DVDEntity> mapDTOListToEntityList(List<DVDDTO> dvddtos) {
        List<DVDEntity> dvdEntities = new ArrayList<>();
        for (DVDDTO dvddto : dvddtos) {
            dvdEntities.add(mapDTOToEntity(dvddto));
        }
        return dvdEntities;
    }
}
