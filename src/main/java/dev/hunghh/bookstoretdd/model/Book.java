package dev.hunghh.bookstoretdd.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;
    @Column
    @NotNull
    private String title;
    @Column
    @NotNull
    private String description;
    @Column
    @NotNull
    private int releaseYear;

}
