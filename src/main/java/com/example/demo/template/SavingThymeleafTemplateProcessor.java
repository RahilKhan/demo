package com.example.demo.template;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//@Component
public class SavingThymeleafTemplateProcessor implements TemplateProcessor {
    private final TemplateEngine templateEngine;

    public SavingThymeleafTemplateProcessor() {
        templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
    }

    private int i = 0;

    @Override
    public String process(Object input, String templateName) {
        Context context = new Context();
        context.setVariable("templateModel", input);
        String process = templateEngine.process(templateName, context);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("target/result_" + i++ + ".html"))) {
            writer.write(process);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return process;
    }
}
