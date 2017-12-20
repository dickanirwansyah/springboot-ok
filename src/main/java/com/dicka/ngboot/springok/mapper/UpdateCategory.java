package com.dicka.ngboot.springok.mapper;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateCategory {

    @NotNull
    private int idcategory;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Boolean active;

}
