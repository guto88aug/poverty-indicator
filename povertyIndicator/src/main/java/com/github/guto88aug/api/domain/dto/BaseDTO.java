package com.github.guto88aug.api.domain.dto;

import com.google.common.collect.Iterables;
import lombok.*;

import java.util.LinkedHashMap;

@Getter
@Setter
@NoArgsConstructor
public class BaseDTO {

    private String id;
    private String value;

    public BaseDTO(LinkedHashMap data) {
        this.id = String.valueOf(data.get("id"));
        this.value = String.valueOf(data.get("value"));
    }
}
