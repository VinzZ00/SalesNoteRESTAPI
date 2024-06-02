package com.elvin.salesBackEndApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elvin.salesBackEndApp.dto.WebResponse;
import com.elvin.salesBackEndApp.dto.itemordered.AddItemOrderedDto;
import com.elvin.salesBackEndApp.dto.itemordered.UpdateItemOrderedDto;
import com.elvin.salesBackEndApp.entity.ItemOrdered;
import com.elvin.salesBackEndApp.services.ItemOrderedService.AddItemOrderedService;
import com.elvin.salesBackEndApp.services.ItemOrderedService.DeleteItemOrderedService;
import com.elvin.salesBackEndApp.services.ItemOrderedService.GetItemOrderedService;
import com.elvin.salesBackEndApp.services.ItemOrderedService.UpdateItemOrderedService;
import com.elvin.salesBackEndApp.validationClass.UUIDValidation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;


@RequestMapping("/api/item-order")
@RestController
@Validated
public class ItemOrderedController {
    @Autowired private AddItemOrderedService itemOrderedService;
    @Autowired private DeleteItemOrderedService deleteItemOrderedService;
    @Autowired private UpdateItemOrderedService updateItemOrderedService;
    @Autowired private GetItemOrderedService getItemOrderedService;

    @Autowired private ModelMapper modelMapper;

    // MARK: CREATE DATA
    @PostMapping(
        path = "/addItem",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ItemOrdered> addItemOrder(@RequestBody AddItemOrderedDto additemDto) {
        System.out.println("Adding Item into Database");
        ItemOrdered addedItem= itemOrderedService.addOrder(additemDto);

        return WebResponse.<ItemOrdered>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(modelMapper.map(addedItem, ItemOrdered.class))
        .build();
    }

    // MARK: READ DATA
    @GetMapping(
        path = "/getItem",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = {"orderId"}
    ) // URL : /api/item-order/getItem?orderId=<OrderId>
    public WebResponse<List<ItemOrdered>> getItemByOrder(@RequestParam("orderId") String orderIdString) {
        System.out.println("Getting the order item from database");
        return WebResponse.<List<ItemOrdered>>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(modelMapper.map(getItemOrderedService.getItemOrderedByOrderId(orderIdString), new TypeToken<List<ItemOrdered>>() {}.getType()))
        .build();
    }

    // MARK: UPDATE DATA
    @PostMapping(
        path = "/updateItem",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ItemOrdered> updateItemOrder(@RequestBody UpdateItemOrderedDto updateItemDto) {
        System.out.println("Updating the order item in database");
        return WebResponse.<ItemOrdered>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(updateItemOrderedService.updateItemOrdered(updateItemDto))
        .build();
    }
    
    // MARK: DELETE DATA
    @PostMapping(
        path = "/deleteItem",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = {"id"}
    )
    public WebResponse<String> deleteItemOrdered(@RequestParam("id") @UUIDValidation String id) {
        System.out.println("Deleting the order item from database");
       
        return WebResponse.<String>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(deleteItemOrderedService.deleteItemOrdered(id))
        .build();
    }
    
}
