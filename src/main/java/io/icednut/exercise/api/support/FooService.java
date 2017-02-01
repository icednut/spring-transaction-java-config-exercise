package io.icednut.exercise.api.support;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-25
 */
public interface FooService {
    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
