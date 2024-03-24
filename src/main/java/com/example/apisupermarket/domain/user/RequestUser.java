package com.example.apisupermarket.domain.user;

public record RequestUser(String user_name, String user_email, String user_password, Boolean user_is_active,
                          Integer user_role, String user_phone, String user_cpf) {
}
