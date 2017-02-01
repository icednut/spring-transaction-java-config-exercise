package io.icednut.exercise.api.support;

import java.util.List;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-01-24
 */
public class UserResponse <T> {
    private T users;

    public T getUsers() {
        return users;
    }

    public void setUsers(T users) {
        this.users = users;
    }
}
