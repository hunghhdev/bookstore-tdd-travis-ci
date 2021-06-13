package dev.hunghh.bookstoretdd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
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
