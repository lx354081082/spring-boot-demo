package com.lx.springbootdemo.pojo;

import com.lx.springbootdemo.enums.OrderStatusEnum;
import com.lx.springbootdemo.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lx on 2018/1/22
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //微信openId
    private String buyerOpenid;
    //订单总价
    private BigDecimal buyerAmount;
    //订单状态 默认0 新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //制服状态 默认0 未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
}
