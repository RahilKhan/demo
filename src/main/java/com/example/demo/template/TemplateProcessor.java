package com.example.demo.template;

public interface TemplateProcessor {
    <Input> String process(Input input, String templateName);
}
