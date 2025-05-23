package com.compiladores.compiladores.controllers;

import java.io.StringReader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compiladores.models.code;
import com.compiladores.models.response;
import com.translate.lexer.AnalizadorLexico;
import com.translate.lexer.parser;

import java_cup.runtime.Symbol;

@RestController
@RequestMapping("/api")
public class compiladorController {
    @PostMapping("/compile")
    public ResponseEntity<response<String>> compile(
            @RequestBody code codeRequest) {
        response<String> response = new response<>();

        try {
            AnalizadorLexico lexer = new AnalizadorLexico(
                    new StringReader(codeRequest.getCode()));

            parser parser = new parser(lexer);
            StringBuilder output = new StringBuilder();

            Symbol result = parser.parse();

            String parsedResult = output.toString();

            response.setSuccess(true);
            response.setMessage("Text loaded successfully!");
            response.setData(parsedResult);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Failed to load text: " + e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

}
