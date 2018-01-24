package com.lx.springbootdemo.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lx on 2018/1/22
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
    //名称
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //详情
    private String productDescription;
    //图片
    private String productIcon;
    // 0 正常 1 下架
    private Integer productStatus;
    //类型
    private Integer categoryType;

}
