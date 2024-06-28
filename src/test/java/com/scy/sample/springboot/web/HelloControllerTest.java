package com.scy.sample.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@WithMockUser // 특정된 사용자를 모의 인증하여 테스트를 수행할 때 사용
@ExtendWith(SpringExtension.class) // Spring과 JUnit5를 통합하여 효율적인 테스트를 작성할 수 있게 함
@WebMvcTest(controllers = HelloController.class) // Spring MVC 관련 설정들이 자동으로 로드되어 테스트할 수 있게 함. 특정 컨트롤러를 제외하고 나머지 컨트롤러들을 로드하지 않음.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloTest() throws Exception{
        String message = "HELLO!!";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(message));
    }


    @Test
    public void helloResponseDtoTest () throws Exception{
        String name = "hello";
        int  amount = 1000;

        /*
         param : API 테스트 시 사용될 요청 파라미터를 설정. 값은 String만 가능
         jsonPath : JSON 응답의 특정 필드를 쉽게 검증할 수 있게 하는 메소드. $를 기준으로 필드명을 명시
         is : 주어진 값과의 일치를 검증
        */

        mvc.perform(
                get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf((amount)))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}


