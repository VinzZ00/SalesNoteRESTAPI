package com.elvin.salesBackEndApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.entity.Shop;

import java.util.List;
import java.util.Date;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{
    List<Order> findByShop(String shopIdString);
    List<Order> findByShopAndDateOrders(String shopIdString, Date date);
}

