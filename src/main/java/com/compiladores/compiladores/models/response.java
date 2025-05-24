package com.compiladores.compiladores.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class response<TEntity> {
    boolean success;
    String message;
    TEntity data;
}
