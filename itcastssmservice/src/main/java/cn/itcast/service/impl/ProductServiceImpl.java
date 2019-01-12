package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(String id) {
        productDao.delete(id);
    }

    @Override
    public void openStatus(String id) {
        productDao.openStatus(id);
    }

    @Override
    public List<Product> findLike(String productName, int page, int size) {
        PageHelper.startPage(page,size);
        return productDao.findLike("%"+productName+"%");
    }
}
