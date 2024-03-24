package com.example.apisupermarket.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="produto")
@Entity(name = "product")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_price")
    private Float product_price;
    @Column(name = "product_expiry")
    private String product_expiry;
    @Column(name = "product_description")
    private String product_description;
    @Column(name = "product_manufactoring_date")
    private String product_manufacturing_date;
    @Column(name = "product_supplier_id")
    private Integer product_supplier_id;

    public Product(RequestProduct requestProduct){
        this.product_name = requestProduct.product_name();
        this.product_price = requestProduct.product_price();
        this.product_expiry = requestProduct.product_expiry();
        this.product_description = requestProduct.product_description();
        this.product_manufacturing_date = requestProduct.product_manufacturing_date();
        this.product_supplier_id = requestProduct.product_supplier_id();
    }
}
