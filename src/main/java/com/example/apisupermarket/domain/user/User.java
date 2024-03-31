package com.example.apisupermarket.domain.user;

import com.example.apisupermarket.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "usuario")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "user_password")
    private String user_password;
    @Column(name = "user_is_active")
    private Boolean user_is_active;
    @Column(name = "user_role")
    private Integer user_role;
    @Column(name = "user_phone")
    private String user_phone;
    @Column(name = "user_cpf")
    private String user_cpf;

    public User(RequestUser requestUser){
        this.user_name = requestUser.user_name();
        this.user_email = requestUser.user_email();
        this.user_cpf = requestUser.user_cpf();
        this.user_phone = requestUser.user_phone();
        this.user_is_active = requestUser.user_is_active();
        this.user_password = requestUser.user_password();
        this.user_role = requestUser.user_role();
    }
}
