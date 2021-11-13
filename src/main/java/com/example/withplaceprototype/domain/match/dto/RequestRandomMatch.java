package com.example.withplaceprototype.domain.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestRandomMatch {

    private Long userId;

    private Condition condition;
}
