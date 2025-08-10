package com.spring.boot.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;
import com.spring.boot.service.mysql.OrderService;

@Controller
@RequestMapping("/mysql")
public class MvcController {

	@Autowired
	private OrderService orderService;

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/orders")
    public String getOrdersPage(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

//    @GetMapping("/addOrder")
//    public String addOrderPage(Model model) {
//        model.addAttribute("order", new com.spring.boot.pojo.Order());
//        return "add-order";
//    }
//    
//    @PostMapping("/addOrder")
//    public String saveOrder(@ModelAttribute com.spring.boot.pojo.Order order) throws BusinessException {
//    	orderService.saveOrder(order);
//        return "redirect:/mysql/orders";
//    }
    
    @GetMapping("/add-order")
    public String addOrderForm() {
        return "add-order";
    }

    @PostMapping("/add-order")
    public String saveOrder(@RequestBody Order order) throws BusinessException {
    	orderService.saveOrder(order);
        return "redirect:/mysql/orders";
    }
}