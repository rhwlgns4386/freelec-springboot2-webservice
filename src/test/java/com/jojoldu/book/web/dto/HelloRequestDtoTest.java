package com.jojoldu.book.web.dto;

import static org.assertj.core.api.Assertions.assertThat;

import junit.framework.TestCase;
import org.junit.Test;

public class HelloRequestDtoTest{

    @Test
    public void 롬복_기능_테스트(){
        String name="test";
        int amount=1000;

        HelloRequestDto dto = new HelloRequestDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
