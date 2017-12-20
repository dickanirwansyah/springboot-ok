package com.dicka.ngboot.springok.mapper;

import com.dicka.ngboot.springok.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateProduct {

    @NotNull
    private int idproduct;

    @NotNull
    private String name;

    @NotNull
    private int quantity;

    @NotNull
    private int price;

    @NotNull
    private Boolean active;

    @NotNull
    private Category category;
}
