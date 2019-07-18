package com.elfop.sulfur.proversion.service;


import com.elfop.sulfur.base.common.Page;
import com.elfop.sulfur.proversion.dao.bean.ProVersion;
import com.elfop.sulfur.proversion.dao.bean.ProVersionExample;
import com.elfop.sulfur.proversion.dao.mapper.ProVersionMapper;
import com.elfop.sulfur.proversion.web.request.VersionTypeReq;
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

    /**
     * 根据type查询出分页数据
     *
     * @param req
     * @return
     */
    @Override
    public Page<ProVersion> getProVersionAll(VersionTypeReq req) {

        PageHelper.startPage(req.getSortVo().getPage(), req.getSortVo().getSize());

        ProVersionExample example = new ProVersionExample();
        example.or().andTypeEqualTo(req.getType());
        example.setOrderByClause(req.getSortVo().getSorting());

        List<ProVersion> list = versionMapper.selectByExample(example);

        PageInfo<ProVersion> pageInfo = new PageInfo<>(list);

        return Page.<ProVersion>builder()
                .page(req.getSortVo().getPage())
                .size(req.getSortVo().getSize())
                .values(list)
                .total(pageInfo.getTotal())
                .build();
    }


}
