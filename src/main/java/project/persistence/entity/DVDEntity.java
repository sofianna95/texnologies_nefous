package project.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import project.persistence.DVDTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class DVDEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String  id;

    @Column(nullable = false)
    private String title;

    @Column
    private DVDTypeEnum type;

    @Column
    private int numberOfPieces;


}

