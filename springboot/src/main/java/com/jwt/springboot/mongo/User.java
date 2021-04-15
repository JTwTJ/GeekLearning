package com.jwt.springboot.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author jiangwentao
 * @date 2021/4/14
 * @description
 */
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Field("username")
    private String username;
    private String password;
    private String registerTime;
    private String phone;
    private String name;
    private String sex;
    private String age;
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
