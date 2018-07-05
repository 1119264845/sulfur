package com.elfop.sulfur.service;

import com.elfop.sulfur.dao.bean.ProVersion;

import java.util.List;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2018-07-05 11:43
 */
public interface VersionService {
    List<ProVersion> getProVersionAll(String type, int page, int size);
}
