package com.elfop.sulfur.service;

import com.elfop.sulfur.dao.bean.ProVersion;
import com.elfop.sulfur.dao.bean.ProVersionExample;
import com.elfop.sulfur.dao.mapper.ProVersionMapper;
import com.elfop.sulfur.web.vo.ResultsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:43
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Resource
    private ProVersionMapper versionMapper;

    @Override
    public ResultsVo<ProVersion> getProVersionAll(String type, int page, int size) {
        PageHelper.startPage(page, size);
        ProVersionExample example = new ProVersionExample();
        example.or().andTypeEqualTo(type);
        example.setOrderByClause("utime DESC");
        List<ProVersion> list = versionMapper.selectByExample(example);
        PageInfo<ProVersion> pageInfo = new PageInfo<>(list);
        return new ResultsVo<>(list, pageInfo);
    }



}
