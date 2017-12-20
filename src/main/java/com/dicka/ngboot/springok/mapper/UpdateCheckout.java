package com.dicka.ngboot.springok.mapper;

import com.dicka.ngboot.springok.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UpdateCheckout {

    @NotNull
    private int idcheckout;

    @NotNull
    private Date checkdate;

    @NotNull
    private List<Product> productList;
}
