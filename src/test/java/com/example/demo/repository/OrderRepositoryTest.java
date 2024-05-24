package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 데이터등록() {
		
		List<Order> list = new ArrayList<>();
		
		LocalDate localDate = LocalDate.of(2023,7,1);
		LocalDate localDate1 = LocalDate.of(2023,7,2);
		LocalDate localDate2 = LocalDate.of(2023,7,3);
		
		Order order1 = new Order(1, "둘리", localDate, "인천 구월동");
		Order order2 = new Order(2, "또치", localDate1, "인천 연수동");
		Order order3 = new Order(3, "도우너", localDate2, "부산 동래동");
		
		list.add(order1);
		list.add(order2);
		list.add(order3);
		
		orderRepository.saveAll(list);
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Order> list = orderRepository.findAll();
		
	for (Order order : list)
		System.out.println(order);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> result = orderRepository.findById(2);
		Order order = result.get();
		order.setCustomerName("김경환");
		order.setShipAddress("인천 간석동");
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1); // id는 pk
	}
	
	@Test
	public void 데이터전체삭제() {
		orderRepository.deleteAll();
	}
	
	@Test
	public void 주소지가인천검색() {
		List<Order> list = orderRepository.get1("인천");
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
	@Test
	public void 주문일이7월3일인거검색() {
		LocalDate localDate = LocalDate.parse( "2023-07-03" );
		List<Order> list = orderRepository.get2(localDate);
		
		for(Order order : list) {
			System.out.println(order);
		}
	}
}
