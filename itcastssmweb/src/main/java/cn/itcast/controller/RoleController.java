package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Role> list = roleService.findAll();
        mv.addObject("roleList", list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(String[] ids) {
        if (ids != null) {
            for(int i = 0; i < ids.length; i++) {
                roleService.delete(ids[i]);
            }
        }
        return "redirect:findAll";
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> list =  roleService.findPermission(id);
        mv.addObject("role",role);
        mv.addObject("permissionList",list);
        mv.setViewName("role-permission-add");
        return mv;
    }
}
