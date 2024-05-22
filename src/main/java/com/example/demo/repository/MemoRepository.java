package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

//메모 엔티티를 처리하기 위한 리파지토리 만들기

//엔티티와 pk 타입 입력
public interface MemoRepository extends JpaRepository<Memo, Integer>{

}
