package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //查询所有产品
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") int page,@RequestParam(name = "size",defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
    //添加一个产品
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String[] ids){
        if(ids!=null) {
            for (int i = 0; i < ids.length; i++) {
                productService.delete(ids[i]);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/openStatus")
    public String openStatus(String[] ids){
        for (int i = 0; i < ids.length; i++) {
            productService.openStatus(ids[i]);
        }
        return "redirect:findAll";
    }

    @RequestMapping("/findLike")
    public ModelAndView findLike(String productName,@RequestParam(name = "page",defaultValue = "1") int page,@RequestParam(name = "size",defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Product> list =  productService.findLike(productName,page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
}
