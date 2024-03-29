package com.edu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;
// 깃 잔디 2차 테스트
    @Test
    public void hello_반환() throws Exception {
        String hello = "Hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "test";
        int amount = 1000;
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount" , String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name" , is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
