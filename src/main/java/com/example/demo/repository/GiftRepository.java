package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer>{

//	가격이 50000원 이상인 선물 검색
	@Query("select g from Gift g where g.price >= :gprice")
	List<Gift> get1(@Param("gprice") int gprice);
	
//	이름이 세트로 끝나는 선물 검색
	@Query("select g from Gift g where RIGHT(g.name, 2) = :gname")
	List<Gift> get2(@Param("gname") String gname);
	
//	가격이 40000원 이하고 품목은 생활용품인 선물 검색
	@Query("select g from Gift g where g.price <= :gprice2 and g.type = :gtype")
	List<Gift> get3(@Param("gprice2") int gprice2, @Param("gtype") String gtype);
}
