package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest3 {
	
	@Autowired
	MemoRepository3 memoRepository3;
	
	@Test
	public void 번호가10보다작은_메모검색() {
		
		List<Memo> list = memoRepository3.get1(10);
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가10과20사이인_메모검색() {
		
		List<Memo> list = memoRepository3.get3(10, 20);
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		
		List<Memo> list = memoRepository3.get4();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
}
