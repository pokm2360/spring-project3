package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 데이터등록() {
		
		Member member1 = Member.builder().userId("admin").grade("관리자").password("1234")
							.build();
		memberRepository.save(member1);
		
		Member member2 = Member.builder().userId("user").grade("사용자").password("1234")
							.build();
		memberRepository.save(member2);
		
	}
	
	@Test
	public void 데이터조회() {
		
		Optional<Member> result = memberRepository.findById("user");
		
		if (result.isPresent()) {
			
			Member member2 = result.get();
			System.out.println(member2);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Member> list = memberRepository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void 데이터수정() {
		Optional<Member> result = memberRepository.findById("user");
		Member member = result.get();
		member.setPassword("5678");
		memberRepository.save(member);
	}

	@Test
	public void 데이터삭제() {
		memberRepository.deleteById("user");
	}
}
