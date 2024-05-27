package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

//	제목이 자바프로그래밍입문 인 책 검색
//	@Query(value = "select * from tbl_book where title = :title", nativeQuery = true)
	@Query("select b from Book b where b.title = :btitle")
	List<Book> get1(@Param("btitle") String btitle);
	
//	가격이 3만원 이상이고 출판사가 남가람북스 인 책 검색
//	@Query(value = "SELECT * FROM tbl_book WHERE price > :price AND publisher = :publisher", nativeQuery = true)
	@Query("select b from Book b where b.price > :bprice and b.publisher = :bpub")
	List<Book> get2(@Param("bprice") int bprice, @Param("bpub") String bpub);
	
//	출판사가 한빛출판사 또는 이지스퍼블리싱 인 책 검색
//	@Query(value = "SELECT * FROM tbl_book WHERE publisher IN (:publisher1,:publisher2)", nativeQuery = true)
//	@Query("select b from Book b where b.publisher = :bpub or b.publisher = :bpub2")
	@Query("select b from Book b where b.publisher in(:bpub, :bpub2)")
	List<Book> get3(@Param("bpub") String bpub, @Param("bpub2") String bpub2);
}
