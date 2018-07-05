package com.elfop.sulfur.web.control;

import com.alibaba.fastjson.JSON;
import com.elfop.sulfur.dao.mapper.ProVersionMapper;
import com.elfop.sulfur.service.VersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:40
 */
@Slf4j
@RestController
@RequestMapping(path = "/version", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class VersionController {

    @Resource
    private VersionService versionService;

    @PostMapping(value = "/type")
    public String getVersion(@RequestParam String type,@RequestParam int page,@RequestParam int size){
        return JSON.toJSONString(versionService.getProVersionAll(type,page,size));
    }

}
