package io.icednut.exercise;

import io.icednut.exercise.api.support.Foo;
import io.icednut.exercise.api.support.FooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-25
 */
public class XmlConfigMainApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/context.xml", XmlConfigMainApplication.class);
        FooService fooService = (FooService) ctx.getBean("fooService");
//        fooService.insertFoo (new Foo());
        fooService.getFoo("hoi");
    }
}
