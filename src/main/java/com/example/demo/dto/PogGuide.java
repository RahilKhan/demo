package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayOutputStream;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Getter
@Setter
@ToString
@AllArgsConstructor
//@JsonSerialize
public class PogGuide {
    private final String fileName;
    private final ByteArrayOutputStream byteArrayOutputStream;

    public byte[] toByteArray() {
        return byteArrayOutputStream.toByteArray();
    }
}
