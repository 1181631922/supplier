package com.education.supplier.controller.classify;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.GradeDao;
import com.education.supplier.dao.SubjectDao;
import com.education.supplier.service.ClassifyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 19:59
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;

    @PostMapping("/listGrade")
    public JSONObject listGrade() {
        return classifyService.listGrade();
    }

    @PostMapping("/listSubject")
    public JSONObject listSubject() {
        return classifyService.listSubject();
    }

}
