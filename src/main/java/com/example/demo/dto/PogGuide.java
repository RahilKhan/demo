package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayOutputStream;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PogGuide {
    private final String fileName;
    private final ByteArrayOutputStream byteArrayOutputStream;

    public byte[] toByteArray() {
        return byteArrayOutputStream.toByteArray();
    }
}
