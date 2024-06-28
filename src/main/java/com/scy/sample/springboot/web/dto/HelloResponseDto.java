package com.scy.sample.springboot.web.dto;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 한 번에 적용
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 생성
@AllArgsConstructor // 모든 필드를 매개변수로 가지는 생성자를 생성
public class HelloResponseDto {

    private String name;
    private int amount;

}
