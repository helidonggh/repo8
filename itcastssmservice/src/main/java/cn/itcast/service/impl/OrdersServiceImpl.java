package cn.itcast.service.impl;

import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Orders;
import cn.itcast.service.OrdersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        List<Orders> list = ordersDao.findAll();
        return list;
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
