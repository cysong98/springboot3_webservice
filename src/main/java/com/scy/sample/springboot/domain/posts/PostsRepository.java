package com.scy.sample.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Entity 클래스와 Entity Repositiry는 함께 위치해야함
// JpaRepository<Entity 클래스, PK타입> 을 상속한 인터페이스. 기본적인 CRUD 메소드가 자동으로 생성됨
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
