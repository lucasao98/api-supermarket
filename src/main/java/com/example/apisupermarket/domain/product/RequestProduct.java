package com.example.apisupermarket.domain.product;

import java.util.Date;

public record RequestProduct(String product_name, Float product_price, String product_expiry, String product_description,
                             String product_manufacturing_date, Integer id_user) {
}
