package com.productk12Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String pname;
    private int qty;
    private int cid;
    private String cname;
    private String avg;
    private float price;
    private int sid;

}
