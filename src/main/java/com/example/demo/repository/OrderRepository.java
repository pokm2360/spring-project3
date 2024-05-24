package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

//	주소지가 인천인 주문 검색
	@Query("select o from Order o where LEFT(o.shipAddress, 2) = :oadd")
	List<Order> get1(@Param("oadd") String oadd);
//	
//	주문일이 7월3일 인 주문 검색
	@Query("select o from Order o where o.orderDate = :odate")
	List<Order> get2(@Param("odate") LocalDate odate);
	
}
