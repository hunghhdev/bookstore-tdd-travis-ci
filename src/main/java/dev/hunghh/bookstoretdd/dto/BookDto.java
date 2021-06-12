package dev.hunghh.bookstoretdd.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookDto {

    private UUID id;
    private String title;
    private String description;
    private int releaseYear;

}
