package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//엔티티에 변화를 감지하는 리스너 지정
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_member") // 테이블 이름
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

	@Id
	String userId;
	
	@Column(length = 255)
	String grade;
	
	@Column(nullable = true)
	String password;
	
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate registerDate;
}
