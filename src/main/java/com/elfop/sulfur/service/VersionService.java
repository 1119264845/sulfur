package com.elfop.sulfur.service;

import com.elfop.sulfur.dao.bean.ProVersion;
import com.elfop.sulfur.web.vo.ResultsVo;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:43
 */
public interface VersionService {

    ResultsVo<ProVersion> getProVersionAll(String type, int page, int size);
}
