package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.pojo.Order;
import com.asxb.bookstore.pojo.User;
import com.asxb.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 刘斌
 * @date 2021/6/30 8:31
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ResultInfoFactory<List<Order>> factory;

    @RequestMapping("/listMyOrder1")
    public String listMyOrder1(Integer pageNum, Integer size, HttpSession session, Model model) {

        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        int page = (pageNum - 1) * size;
        User user = (User) session.getAttribute("user");
        BigDecimal bigDecimal = new BigDecimal(user.getUserId().longValue());
        List<Order> orders = orderService.findOrderByUserAndType(bigDecimal, 1, page, size);
        BigDecimal total = orderService.totalOrderByUserAndType(bigDecimal, 1);
        ResultInfo<List<Order>> info = factory.getSuccessTemplateObject();
        info.setData(orders);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP));
        // 总行数
        model.addAttribute("total", total);
        model.addAttribute("page", pageNum); // 当前页
        return "listMyOrder1";
    }

    @RequestMapping("/listMyOrder2")
    public String listMyOrder2(Integer pageNum, Integer size, HttpSession session, Model model) {

        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        int page = (pageNum - 1) * size;
        User user = (User) session.getAttribute("user");
        BigDecimal bigDecimal = new BigDecimal(user.getUserId().longValue());
        List<Order> orders = orderService.findOrderByUserAndType(bigDecimal, 2, page, size);
        BigDecimal total = orderService.totalOrderByUserAndType(bigDecimal, 2);
        ResultInfo<List<Order>> info = factory.getSuccessTemplateObject();
        info.setData(orders);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP));
        // 总行数
        model.addAttribute("total", total);
        model.addAttribute("page", pageNum); // 当前页
        return "listMyOrder2";
    }

    @RequestMapping("/listMyOrder3")
    public String listMyOrder3(Integer pageNum, Integer size, HttpSession session, Model model) {

        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        int page = (pageNum - 1) * size;
        User user = (User) session.getAttribute("user");
        BigDecimal bigDecimal = new BigDecimal(user.getUserId().longValue());
        List<Order> orders = orderService.findOrderByUserAndType(bigDecimal, 3, page, size);
        BigDecimal total = orderService.totalOrderByUserAndType(bigDecimal, 3);
        ResultInfo<List<Order>> info = factory.getSuccessTemplateObject();
        info.setData(orders);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP));
        // 总行数
        model.addAttribute("total", total);
        model.addAttribute("page", pageNum); // 当前页
        return "listMyOrder3";
    }

    @RequestMapping("/orderCancel")
    public String orderCancel(BigDecimal orderId) {

        orderService.updateType(orderId, 4);
        return "redirect:listMyOrder1";
    }

    @RequestMapping("/orderSign")
    public String orderSign(BigDecimal orderId) {

        orderService.updateType(orderId, 3);
        return "redirect:listMyOrder2";
    }
}
