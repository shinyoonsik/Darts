package com.example.darts.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonResponseBody {
    private String code;
    private String message;
    private Object data;
    private String description;

    @Builder
    public CommonResponseBody(String code, String message, Object data, String description) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.description = description;
    }
}
