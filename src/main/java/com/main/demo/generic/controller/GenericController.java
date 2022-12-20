package com.main.demo.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.demo.model.tool.ErrorG;

import lombok.Data;

@Data
public class GenericController {
    @Autowired
    ObjectMapper objectMapper;

    public String onError(Exception e) {
        String message = "";
        try {
            ErrorG err = new ErrorG(404, e.getMessage());
            message = this.getObjectMapper().writeValueAsString(err);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        }
        return message;
    }

    public String getMessage(Object data) {
        String message = "";
        try {
            message = this.getObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            message = this.onError(e);
        }
        return message;
    }
}
