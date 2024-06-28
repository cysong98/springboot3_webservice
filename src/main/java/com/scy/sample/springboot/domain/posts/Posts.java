package com.scy.sample.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

// Entity 클래스에서는 절대 setter를 만들지 않음. 변경이 필요하다면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 함
@Slf4j
@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙. 이 옵션은 auto increment
    private Long id;


    /*
        @Column : 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨.
        기본값 이외에 추가할 옵션이 있으면 사용.
        문자열은 VARCHAR(255)가 기본값.
        columnDefinition = "TEXT" : 대용량 문자열 데이터를 저장할 수 있는 SQL 데이터 타입
    */

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
