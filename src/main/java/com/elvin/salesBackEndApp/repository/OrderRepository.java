package com.elvin.salesBackEndApp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elvin.salesBackEndApp.entity.Order;
import com.elvin.salesBackEndApp.entity.Shop;

import java.util.List;
import java.util.Date;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

    @Query("SELECT o FROM orders o JOIN o.shop s WHERE s.id = ?1 AND o.dateOrdered = ?2")
    List<Order> getOrderByShopAndDateOrders(String shopIdString, Date
     date);
}

