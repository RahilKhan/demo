package com.example.demo.template;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafTemplateProcessor implements TemplateProcessor {
    private final TemplateEngine templateEngine;

    public ThymeleafTemplateProcessor() {
        templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    public String process(Object input, String templateName) {
        Context context = new Context();
        context.setVariable("templateModel", input);
        return templateEngine.process(templateName, context);
    }
}
