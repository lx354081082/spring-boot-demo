package com.lx.springbootdemo.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
@Data
public class OrderDTO {
    private String name;
    private String phone;
    private String address;
    private String openid;
    private List<ProductItemDTO> items;

    public void setItems(String items) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.items = objectMapper.readValue(items, new TypeReference<List<ProductItemDTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
