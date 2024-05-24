package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

public interface MemoRepository3 extends JpaRepository<Memo, Integer> {

//	단건조회, 목록조회, 수정, 삭제, 추가, 페이징
//	조건 검색 기능 추가하고 싶을때 - 쿼리메소드나 어노테이션 사용할 것
	
//	메모의 번호가 3보다 작은 데이터 검색
//	select * from tbl_memo where no < ?
//	jpql 문법으로 변경->
	@Query("select m from Memo m where m.no < :mno")
	List<Memo> get1(@Param("mno") int mno);
	
//	메모의 번호가 2에서 3 사이인 데이터 검색
//	select * from tbl_memo where no between ? and ?
	@Query("select m from Memo m where m.no between :from and :to")
	List<Memo> get3(@Param("from") int from, @Param("to") int to);
	
//  메모의 번호를 기준으로 역정렬
//  select * from tbl_memo order by no desc
	
	@Query(value = "select * from tbl_memo order by no desc", nativeQuery = true)
	List<Memo> get4();
	
}

