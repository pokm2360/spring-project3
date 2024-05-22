package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 엔티티 클래스
@Table(name = "tbl_memo") // 테이블 이름
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 키 생성방식
	int no;
	
	@Column(length = 200, nullable = true) // 컬럼의 속성
	String text; // 컬럼의 이름과 자료형
}
