package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userInfoService.findAll();
        mv.addObject("userList", list);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userInfoService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findById(id);
        List<Role> list = userInfoService.findAllRoles(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", list);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids) {
        if (ids != null && userId != null) {
            for (int i = 0; i < ids.length; i++) {
                userInfoService.addRoleToUser(userId,ids[0]);
            }
        }
        return "redirect:findAll";
    }
}
