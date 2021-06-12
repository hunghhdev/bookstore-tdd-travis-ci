package dev.hunghh.bookstoretdd.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BookDto", description = "All details about book")
public class BookDto {

    @ApiModelProperty(
            value = "UUID",
            dataType = "UUID",
            example = "50bc98e1-f51d-4b89-88d1-b3fa15e09e21",
            notes = "The database generated uuid for book id"
    )
    private UUID id;
    @ApiModelProperty(
            value = "title",
            dataType = "String",
            example = "book title",
            notes = "Book title",
            required = true
    )
    private String title;
    @ApiModelProperty(
            value = "description",
            dataType = "String",
            example = "book description",
            notes = "Book description",
            required = true
    )
    private String description;
    @ApiModelProperty(
            value = "releaseYear",
            dataType = "int",
            example = "2020",
            notes = "Book releaseYear",
            required = true
    )
    private int releaseYear;

}
