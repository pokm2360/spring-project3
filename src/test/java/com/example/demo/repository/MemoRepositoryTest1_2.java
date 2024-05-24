package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_2 {

	@Autowired
	MemoRepository repository;
	
	@Test
	void 메모데이터100개등록() {
		
//		IntStream: 스트림
//		rangeClosed: 특정 범위의 숫자들로 스트림을 생성하는 함수
//		forEach: 특정 작업을 수행하는 함수
//		IntStream.rangeClosed(1,100)
//		// forEach의 파라미터로 인터페이스형 함수가 들어가야함
//				.forEach(value -> System.out.println(value));
		
//		메모 100개를 생성해서 테이블에 추가
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder().text("Sample.." + i).build();
			repository.save(memo);
		});
	}
//	아래 코드를 람다식으로 바꿔서 위 코드에 대입
//	void accept(int i) {
//			Memo memo = Memo.builder().text("Sample.." + i).build();
//			repository.save(memo);
//	}
	
	@Test
	void 페이징처리() {
		
		Pageable pageable = PageRequest.of(0, 10); // 페이지는 0부터시작
//		페이지 생성
		Page<Memo> page = repository.findAll(pageable);
//		페이지 정보를 전달하여 목록 조회
		List<Memo> list = page.getContent();
//		페이지 객체에서 엔티티 리스트 꺼내기
		System.out.println(list);
		
//		페이지 부가 정보
		System.out.println("총 페이지:" + page.getTotalPages());
		System.out.println("현재 페이지 번호:" + page.getNumber());
		System.out.println("페이지 당 데이터 개수:" + page.getSize());
		System.out.println("다음 페이지 존재 여부:" + page.hasNext());
		System.out.println("시작 페이지 여부:" + page.isFirst());
	}
	
	@Test
	void 정렬조건추가하기() {
//		no필드를 기준으로 역정렬
		Sort sort = Sort.by("no").descending(); // 게시판은 보통 역정렬
		
//		Pageable pageable = PageRequest.of(0, 10); 둘중 아무거나 써도됨 밑은 정렬까지
		Pageable pageable = PageRequest.of(9, 5, sort);

		Page<Memo> page = repository.findAll(pageable);

		List<Memo> list = page.getContent();
		
		for (Memo memo : list) {
			System.out.println(memo);			
		}

	}
}
