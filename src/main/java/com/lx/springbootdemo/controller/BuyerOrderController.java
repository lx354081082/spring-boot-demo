package com.lx.springbootdemo.controller;

import com.lx.springbootdemo.dto.OrderDTO;
import com.lx.springbootdemo.exception.MyException;
import com.lx.springbootdemo.service.OrderMasterService;
import com.lx.springbootdemo.utils.ReturnUtils;
import com.lx.springbootdemo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lx on 2018/1/22
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    OrderMasterService orderMasterService;

    /**
     * 下单
     * 返回订单id
     */
    @PostMapping("/create")
    public ResultVO create(OrderDTO orderDTO) {
        String orderid = orderMasterService.seveOrder(orderDTO);
        return ReturnUtils.success("{'orderId':'" + orderid + "'}");
    }

    @GetMapping("/list")
    public ResultVO getList(Integer pageNo) {
        return ReturnUtils.success(null);
    }
}
