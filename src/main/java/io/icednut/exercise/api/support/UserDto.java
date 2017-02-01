package io.icednut.exercise.api.support;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
public class UserDto {

    private final String username;
    private final Integer age;

    public UserDto() {
        this.username = "";
        this.age = 0;
    }

    public UserDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }
}
