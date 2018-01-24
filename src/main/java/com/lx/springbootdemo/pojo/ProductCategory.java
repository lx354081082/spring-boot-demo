package com.lx.springbootdemo.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lx on 2018/1/20
 * Data lombok
 * 自动生成get set
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    //主键自增
    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}
