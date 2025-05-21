package com.cafe.menu.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIU {
    @NotEmpty
    private String name;

    private String description;

    @NotNull
    private Double price;

    private String imageUrl;


    private Long categoryId;
}
