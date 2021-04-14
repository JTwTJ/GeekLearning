package com.jwt.springboot.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/4/14
 * @description MongoDB demo
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> mongo() {
        return mongoTemplate.findAll(User.class);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestParam String name, @RequestParam String sex, @RequestParam String age) {
        User user = new User();
        user.setId(Long.toString(System.currentTimeMillis()));
        user.setName(name + System.currentTimeMillis() % 1000);
        user.setAge(age);
        user.setSex(sex);
        mongoTemplate.insert(user);
        return "insert success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestParam String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
        return "delete success";
    }
}
