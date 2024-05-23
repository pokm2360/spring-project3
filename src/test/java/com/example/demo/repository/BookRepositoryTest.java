package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

// 엔티티-리파지토리-test 순으로 만들기

@SpringBootTest // 스프링부트 적용
public class BookRepositoryTest {
	
	@Autowired // 객체 가져오기
	BookRepository bookRepository;
	
	@Test
	public void 리파지토리객체를가져왔는지확인() {
		System.out.println();
		System.out.println("bookRepository = " + bookRepository);
		System.out.println();
	}
//	추가 - 단일등록은 save, 일괄등록은 List로 만들어서 추가 saveAll
	@Test
	public void 데이터일괄등록() {
		
		List<Book> list = new ArrayList<>();
		
		Book book1 = new Book(1, 20000, "한빛출판사", "자바프로그래밍입문");
		Book book2 = new Book(2, 25000, "남가람북스", "스프링부트프로젝트");
		Book book3 = new Book(3, 40000, "남가람북스", "실무로 끝내는 PHP");
		Book book4 = new Book(4, 35000, "이지스퍼블리싱", "알고리즘코딩테스트");
		
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		
		bookRepository.saveAll(list);
	}
//	조회 - find로 조히해서 Optional로 뽑아오기
	@Test
	public void 데이터단건조회() {
//		findById 함수는 조회결과를 optional로 변환
		Optional<Book> result = bookRepository.findById(5);
		
//		결과값이 있는지 확인하고 값을 꺼내기
		if(result.isPresent()) { // 확인
			
			Book book = result.get(); //꺼내기 
			System.out.println(book);
		}
	}
//	수정 - save()
	@Test
	public void 데이터수정() {
		Book book = new Book(5, 9999, "대한출판사", "원피스");
		
//		1번이 있으면 update, 없으면 insert
		bookRepository.save(book);
	}
//	삭제 - deleteAll(), deleteById()
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll(); // 테이블의 모든 데이터 일괄 삭제
	}
}
