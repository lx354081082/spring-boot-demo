package com.lx.springbootdemo.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lx on 2018/1/22
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    @Id
    private String detailId;
    //订单id
    private String orderId;
    //商品id
    private String productId;
    //商品名
    private String productName;
    //单价
    private BigDecimal productPrice;
    //数量
    private Integer productQuantity;
    //图
    private String productIcon;
    private Date createTime;
    private Date updateTime;
}
