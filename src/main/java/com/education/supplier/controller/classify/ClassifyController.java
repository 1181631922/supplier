package com.education.supplier.controller.classify;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.GradeDao;
import com.education.supplier.dao.SubjectDao;
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
    private GradeDao gradeDao;

    @Resource
    private SubjectDao subjectDao;

    @PostMapping("/listGrade")
    public List<JSONObject> listGrade(){
        return gradeDao.listGrade();
    }

    @PostMapping("/listSubject")
    public List<JSONObject> listSubject(){
        return subjectDao.listSubject();
    }

}
