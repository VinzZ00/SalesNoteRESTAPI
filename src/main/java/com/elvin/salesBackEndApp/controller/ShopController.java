package com.elvin.salesBackEndApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elvin.salesBackEndApp.dto.WebResponse;
import com.elvin.salesBackEndApp.dto.shop.AddAndUpdateShopDTO;
import com.elvin.salesBackEndApp.entity.Shop;
import com.elvin.salesBackEndApp.services.ShopService.AddShopService;
import com.elvin.salesBackEndApp.services.ShopService.DeleteShopService;
import com.elvin.salesBackEndApp.services.ShopService.GetShopService;
import com.elvin.salesBackEndApp.services.ShopService.UpdateShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    @Autowired private AddShopService addShopService;
    @Autowired private GetShopService getShopService;
    @Autowired private UpdateShopService updateShopService;
    @Autowired private DeleteShopService  deleteShopService;

    // MARK: CREATE DATA
    @PostMapping(
        path = "/addshop",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Shop> addShop(@RequestBody AddAndUpdateShopDTO shopDto) {
        System.out.println("Adding Shop into Database");
        
        return WebResponse.<Shop>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(addShopService.addingShop(shopDto))
        .build();
    }

    // MARK: READ DATA
    /// get all Shop
    @GetMapping(
        path = "/getshop",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<Shop>> getAllShop() {
        System.out.println("Getting All Shop");
        return WebResponse.<List<Shop>>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(getShopService.getAllShop())
        .build();
    }

    /// get Shop by Phone Number
    @GetMapping(
        path = "/getshop",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = "phoneNumber"
    )
    public WebResponse<Shop> getShopByPhoneNumber(@RequestParam String phoneNumber) {
        System.out.println("Getting Shop by Phone Number");
        return WebResponse.<Shop>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(getShopService.getShopByPhoneNumber(phoneNumber))
        .build();
    }
    
    /// get Shop by Id
    @GetMapping(
        path = "/getshop",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = "id"
    )
    public WebResponse<Shop> getShopResponse(@RequestParam String id) {
        System.out.println("Getting Shop by Id");
        return WebResponse.<Shop>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(getShopService.getShopById(id))
        .build();
    }

    // MARK: UPDATE DATA
    @PostMapping(
        path = "/updateshop",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Shop> postMethodName(@RequestBody AddAndUpdateShopDTO shopDTO) {
        System.out.println("Updating Shop in Database");

        return WebResponse.<Shop>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(updateShopService.updateShop(shopDTO))
        .build();
    }
    
    // MARK: DELETE DATA
    @PostMapping(
        path = "/deleteshop",
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = {"id"}
    )   
    public WebResponse<String> deleteShopDto(@RequestParam("id") String id) {
        //TODO: process POST request
        System.out.println("Deleting Shop from Database");

        return WebResponse.<String>builder()
        .StatusCode(HttpStatusCode.valueOf(200))
        .data(deleteShopService.deleteShop(id))
        .build();
    }
}
