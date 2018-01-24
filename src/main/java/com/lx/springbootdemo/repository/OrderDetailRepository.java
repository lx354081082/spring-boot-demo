package com.lx.springbootdemo.repository;

import com.lx.springbootdemo.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lx on 2018/1/22
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
