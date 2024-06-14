package com.elvin.salesBackEndApp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elvin.salesBackEndApp.dto.WebResponse;
import com.elvin.salesBackEndApp.dto.order.AddOrderDto;
import com.elvin.salesBackEndApp.dto.order.UpdateOrderDto;
import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.services.OrderService.AddOrderService;
import com.elvin.salesBackEndApp.services.OrderService.DeleteOrderService;
import com.elvin.salesBackEndApp.services.OrderService.GetOrderService;
import com.elvin.salesBackEndApp.services.OrderService.UpdateOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired private AddOrderService addOrderService;
    @Autowired private DeleteOrderService deleteOrderService;
    @Autowired private UpdateOrderService updateOrderService;
    @Autowired private GetOrderService getOrderService;

    // MARK: CREATE DATA
    @PostMapping(
        path = "/addorder",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Order> AddOrder(@RequestBody AddOrderDto order) {
        System.out.println("Adding Order Into Database");

        return WebResponse.<Order>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(addOrderService.addOrder(order))
        .build();
        
    }

    
    
    // MARK: READ DATA 
    // Using ShopID
    @GetMapping(
        path = "/getorders",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = "shopId"
    )
    public WebResponse<List<Order>> getOrderByShopID(@RequestParam("shopId") String shopId) {
        System.out.println("Getting Orders from Database with ShopId");

        return WebResponse.<List<Order>>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(getOrderService.getOrders(shopId))
        .build();
    }
    
    // Using ShopID and Date
    @GetMapping(
        path =  "/getorders",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params =  {"shopId", "date"}
    )
    public WebResponse<List<Order>> getOrderByShopIdAndDate(@RequestParam("shopId") String shopId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOrdered) {
        System.out.println("Getting Orders from database with shopId and erderedDate");

        return WebResponse.<List<Order>>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(getOrderService.getOrdersByDate(shopId, dateOrdered))
        .build();
    }

    //MARK; UPDATE DATA
    @PostMapping(
        path = "/updateorder",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Order> updateOrder(@RequestBody UpdateOrderDto updateOrderDto) {
        System.out.println("Updating Order in Database");

        return WebResponse.<Order>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(updateOrderService.updateOrderService(updateOrderDto))
        .build();
    }
    
    // MARK: DELETE DATA
    @PostMapping(
        path = "/deleteorder",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = {"id"}
    )
    public WebResponse<String> deleteOrder(@RequestParam("id") String id) {
        System.out.println("Deleting Order from Database");

        return WebResponse.<String>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(deleteOrderService.deleteOrder(id))
        .build();
    }
}
