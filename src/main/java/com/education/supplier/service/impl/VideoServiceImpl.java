package com.education.supplier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.education.supplier.dao.VideoMapper;
import com.education.supplier.model.Video;
import com.education.supplier.service.VideoService;
import com.education.supplier.util.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Author： fanyafeng
 * Data： 2019-07-08 19:40
 * Email: fanyafeng@live.cn
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    /**
     * 添加视频
     */
    @Override
    public JSONObject addVideo(JSONObject jsonObject) {
        Video video = new Video();
        String videoPath = jsonObject.getString("videoPath");
        video.setVideoPath(videoPath);
        String videoName = jsonObject.getString("videoName");
        video.setVideoName(videoName);
        video.setFilePath(videoPath + videoName);
        video.setCreateTime(new Date());
        videoMapper.insertSelective(video);
        return CommonUtil.successJson(video.getId());
    }
}
