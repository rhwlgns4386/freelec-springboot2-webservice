package com.jojoldu.book.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloRequestDto {

    private final String name;
    private final int amount;
}
