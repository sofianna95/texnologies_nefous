package project.persistence.entity;

import lombok.Data;
import project.persistence.DVDTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class DVDEntity {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private DVDTypeEnum type;

    @Column
    private int numberOfPieces;


}

