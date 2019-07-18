package com.elfop.sulfur.proversion.service;

import com.elfop.sulfur.base.common.Page;
import com.elfop.sulfur.proversion.dao.bean.ProVersion;
import com.elfop.sulfur.proversion.web.request.VersionTypeReq;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:43
 */
public interface VersionService {

    /**
     * 根据type查询出分页数据
     *
     * @param req
     * @return
     */
    Page<ProVersion> getProVersionAll(VersionTypeReq req);
}
