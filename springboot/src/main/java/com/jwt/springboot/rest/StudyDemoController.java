package com.jwt.springboot.rest;

import com.jwt.springboot.service.StudyDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail
 */
@RestController
@Slf4j
@RequestMapping("/study/demo")
public class StudyDemoController {

    @Autowired
    private StudyDemoService studyDemoService;

    @GetMapping("/check/dynamic/data/source")
    public Integer dynamicTest() {
        return studyDemoService.checkDynamicDataSource();
    }
}
