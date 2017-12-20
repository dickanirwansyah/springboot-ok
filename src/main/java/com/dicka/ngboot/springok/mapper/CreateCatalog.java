package com.dicka.ngboot.springok.mapper;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateCatalog {

    @NotNull
    private String name;
}
