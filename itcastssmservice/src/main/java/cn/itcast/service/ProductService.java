package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(int page,int size);


    void save(Product product);

    void delete(String id);

    void openStatus(String id);

    List<Product> findLike(String productName, int page, int size);
}
