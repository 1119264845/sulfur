package com.elfop.sulfur.service;

import com.elfop.sulfur.dao.bean.ProVersion;
import com.elfop.sulfur.dao.bean.ProVersionExample;
import com.elfop.sulfur.dao.mapper.ProVersionMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:43
 */
@Service
public class VersionServiceImpl implements VersionService{

    @Autowired
    ProVersionMapper versionMapper;

    @Override
    public List<ProVersion> getProVersionAll(String type,int page,int size){
        PageHelper.startPage(page, size);
        ProVersionExample example = new ProVersionExample();
        example.or().andTypeEqualTo(type);
        return versionMapper.selectByExample(example);
    }



}
