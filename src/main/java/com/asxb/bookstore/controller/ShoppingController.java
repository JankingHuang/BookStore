package com.asxb.bookstore.controller;

import com.asxb.bookstore.pojo.Item;
import com.asxb.bookstore.pojo.User;
import com.asxb.bookstore.service.BookService;
import com.asxb.bookstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * @author 刘斌
 * @date 2021/6/29 16:39
 */
@Controller
public class ShoppingController {

    @Autowired
    ItemService itemService;

    @Autowired
    BookService bookService;

    @RequestMapping("/shoppingCar")
    public String shoppingCar(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<Item> items = itemService.findItemByUserId(new BigDecimal(user.getUserId()));
        float sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        // 处理总价字段
        for (Item item : items) {

            item.setTotalPrice(Float.parseFloat(decimalFormat.format(item.getPrice() * item.getQuantity())));
            sum += item.getTotalPrice();
        }
        model.addAttribute("items", items);
        model.addAttribute("sum", decimalFormat.format(sum)); // 所有物品的总价
        model.addAttribute("categories", bookService.allCategory());
        return "shoppingCar";
    }

    @RequestMapping("/deleteItem")
    public String deleteItem(Long id, Model model) {
        itemService.deleteItemById(new BigDecimal(id));

        return "redirect:shoppingCar";
    }

    @RequestMapping("/changeItemQuantity")
    public String changeItemQuantity(Long id, Integer amount, Model model) {

//        System.out.println(id);
//        System.out.println(amount);
        itemService.changeItemQuantity(new BigDecimal(id), amount);
        return "redirect:shoppingCar";
    }

    @RequestMapping("/clearShoppingCar")
    public String clearShoppingCar(HttpSession session) {
        User user = (User) session.getAttribute("user");
        itemService.clearShoppingCar(new BigDecimal(user.getUserId()));
        return "redirect:shoppingCar";
    }

    @RequestMapping("/joinShoppingCar")
    public String joinShoppingCar(Long id, HttpSession session) {

        User user = (User) session.getAttribute("user");
        BigDecimal itemId = itemService.findItemId(user.getUserId().longValue(), id);
        // 存在则数量+1，不存在则新增记录
        if (itemId == null) {
            Item item = new Item();
            item.setUserId(user.getUserId().longValue());
            item.setBookId(id);
            itemService.insertItem(item);
        } else {
            itemService.addQuantity(itemId);
        }

        return "redirect:shoppingCar";
    }
}
