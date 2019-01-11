package cn.itcast.service;

import cn.itcast.domain.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int page,int size);

    Orders findById(String id);
}
