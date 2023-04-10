package project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Data;
import project.persistence.DVDTypeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;


@Data
public class DVDDTO {
    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    @NotNull(message = "must not be null")
    private String title;

    @NotNull(message = "must not be null")
    private DVDTypeEnum  type;

    @NotNull(message = "must not be null")
    private int numberOfPieces;

}
