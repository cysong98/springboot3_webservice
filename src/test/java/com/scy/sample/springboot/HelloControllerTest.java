package com.scy.sample.springboot;

import com.scy.sample.springboot.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) // Spring과 JUnit5를 통합하여 효율적인 테스트를 작성할 수 있게 함
@WebMvcTest(controllers = HelloController.class) // Spring MVC 관련 설정들이 자동으로 로드되어 테스트할 수 있게 함. 특정 컨트롤러를 제외하고 나머지 컨트롤러들을 로드하지 않음.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser // 특정된 사용자를 모의 인증하여 테스트를 수행할 때 사용
    public void helloTest() throws Exception{
        String message = "HELLO!!";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(message));
    }
}


