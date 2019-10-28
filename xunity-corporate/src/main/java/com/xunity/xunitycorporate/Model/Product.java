package com.xunity.xunitycorporate.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private Integer productId;
    private String productName;
    private String productDescription;
    private double price;
    private Integer stock;
    private Integer cvPoints;
    private Integer status;
    private String imageUrl;

}
