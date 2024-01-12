package com.crud.citiesandclients.infra.exceptions;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class FieldsWithError {
    private List<String> errors;

    public FieldsWithError(List<String> errors) {
        this.errors = errors;
    }
}
