package com.jojoldu.book.web;

import static org.assertj.core.api.Assertions.assertThat;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        String body = this.restTemplate.getForObject("/", String.class);

        assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
    }
}
