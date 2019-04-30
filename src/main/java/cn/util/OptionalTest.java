package cn.util;

import lombok.Data;

import java.util.Optional;

/**
 * Created by nizy on 2019/4/1.
 */

public class OptionalTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        Optional<User> optional = Optional.ofNullable(user);
        optional.ifPresent((value) -> {
            value.getName();
        });

    }

    @Data
    static class User {
        String id;
        String name;


    }
}
