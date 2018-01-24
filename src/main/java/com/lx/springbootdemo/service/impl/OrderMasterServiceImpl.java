package com.lx.springbootdemo.service.impl;

import com.lx.springbootdemo.dto.OrderDTO;
import com.lx.springbootdemo.dto.ProductItemDTO;
import com.lx.springbootdemo.enums.ExceptionEnum;
import com.lx.springbootdemo.exception.MyException;
import com.lx.springbootdemo.pojo.OrderDetail;
import com.lx.springbootdemo.pojo.OrderMaster;
import com.lx.springbootdemo.pojo.ProductInfo;
import com.lx.springbootdemo.repository.OrderDetailRepository;
import com.lx.springbootdemo.repository.OrderMasterRepository;
import com.lx.springbootdemo.repository.ProductInfoRepository;
import com.lx.springbootdemo.service.OrderMasterService;
import com.lx.springbootdemo.utils.Idutil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    /**
     * 存订单 返回订单信息
     * @return
     */
    @Transactional
    @Override
    public String seveOrder(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(Idutil.genUniqueKey());
        orderMaster.setBuyerName(orderDTO.getName());
        orderMaster.setBuyerPhone(orderDTO.getPhone());
        orderMaster.setBuyerAddress(orderDTO.getAddress());
        orderMaster.setBuyerOpenid(orderDTO.getOpenid());
        //订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        List<ProductItemDTO> prodDTOList = orderDTO.getItems();
        for (ProductItemDTO pd:prodDTOList) {
            OrderDetail orderDetail = new OrderDetail();
            ProductInfo byProductId = productInfoRepository.findByProductId(pd.getProductId());
            BeanUtils.copyProperties(byProductId,orderDetail);

            //减库存
            byProductId.setProductStock(byProductId.getProductStock() - pd.getProductQuantity());

            if (byProductId.getProductStock()>=0)
                productInfoRepository.save(byProductId);
            else
                throw new MyException(ExceptionEnum.PRODUCT_ERROR);
            //计算订单总价
            BigDecimal prodictDmount = byProductId.getProductPrice().multiply(new BigDecimal(pd.getProductQuantity()));
            orderAmount = orderAmount.add(prodictDmount);

            //id
            orderDetail.setDetailId(Idutil.genUniqueKey());
            //订单id
            orderDetail.setOrderId(orderMaster.getOrderId());
            //数量
            orderDetail.setProductQuantity(pd.getProductQuantity());
            //存订单详情
            orderDetailRepository.save(orderDetail);
        }
        //存订单总价
        orderMaster.setBuyerAmount(orderAmount);

        //存订单
        orderMasterRepository.save(orderMaster);
        return orderMaster.getOrderId();
    }
}
