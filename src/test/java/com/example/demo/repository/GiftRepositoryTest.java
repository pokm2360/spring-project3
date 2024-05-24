package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println("giftRepository = " + giftRepository);
	}
	
	@Test
	public void 데이터일괄등록() {
		
		Gift gift1 = Gift.builder().name("참치세트").price(10000).type("식품")
							.build();
		Gift gift2 = Gift.builder().name("햄세트").price(20000).type("식품")
				.build();
		Gift gift3 = Gift.builder().name("샴푸세트").price(30000).type("생활용품")
				.build();
		Gift gift4 = Gift.builder().name("세차용품").price(40000).type("생활용품")
				.build();
		Gift gift5 = Gift.builder().name("주방용품").price(50000).type("생활용품")
				.build();
		Gift gift6 = Gift.builder().name("노트북").price(60000).type("가전제품")
				.build();
		Gift gift7 = Gift.builder().name("벽걸이TV").price(70000).type("가전제품")
				.build();
		giftRepository.save(gift1);
		giftRepository.save(gift2);
		giftRepository.save(gift3);
		giftRepository.save(gift4);
		giftRepository.save(gift5);
		giftRepository.save(gift6);
		giftRepository.save(gift7);
		
	}
	
	@Test
	public void 데이터조회() {
		Optional<Gift> result = giftRepository.findById(7);
		
		if(result.isPresent()) { // 확인
			
			Gift gift = result.get(); //꺼내기 
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftRepository.findById(2);
		Gift gift = result.get();
		gift.setName("비누세트");
		gift.setPrice(9999);
		gift.setType("위생용품");
		giftRepository.save(gift);
				
	}
	
	@Test
	public void 데이터일괄삭제() {
		giftRepository.deleteAll();
	}
	
	@Test
	public void 가격이50000원이상인선물검색() {
		List<Gift> list = giftRepository.get1(50000);
		
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 이름이세트로끝나는선물검색() {
		List<Gift> list = giftRepository.get2("세트");
		
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 가격이40000원이하고품목은생활용품인선물검색() {
		List<Gift> list = giftRepository.get3(40000, "생활용품");
		
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
}
