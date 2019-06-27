package com.education.supplier.controller.subject;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： fanyafeng
 * Data： 2019-06-26 20:00
 * Email: fanyafeng@live.cn
 */
@CrossOrigin
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @PostMapping
    public JSONObject listSubject(){
        return null;
    }
}
