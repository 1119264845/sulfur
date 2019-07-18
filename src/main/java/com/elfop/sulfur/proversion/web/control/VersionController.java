package com.elfop.sulfur.proversion.web.control;

import com.elfop.sulfur.base.common.Page;
import com.elfop.sulfur.base.common.WebResult;
import com.elfop.sulfur.proversion.dao.bean.ProVersion;
import com.elfop.sulfur.proversion.service.VersionService;
import com.elfop.sulfur.proversion.web.request.VersionTypeReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(path = "version", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "当前项目版本号", tags = {"本项目信息"})
public class VersionController {

    @Resource
    private VersionService versionService;

    @PostMapping(value = "/type")
    @ApiOperation(value = "获取版本号", notes = "版本号操作")
    public WebResult<Page<ProVersion>> getVersion(@RequestBody VersionTypeReq req) {
        return WebResult.okResult(versionService.getProVersionAll(req));
    }

}
