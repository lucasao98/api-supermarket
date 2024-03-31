package com.example.apisupermarket.domain.product;

import com.example.apisupermarket.domain.user.User;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User usuario;

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Product(RequestProduct requestProduct){
        this.product_name = requestProduct.product_name();
        this.product_price = requestProduct.product_price();
        this.product_expiry = requestProduct.product_expiry();
        this.product_description = requestProduct.product_description();
        this.product_manufacturing_date = requestProduct.product_manufacturing_date();
    }
}
