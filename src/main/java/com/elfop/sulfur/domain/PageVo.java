package com.elfop.sulfur.domain;

import lombok.Data;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2019/3/8 13:41
 */
@Data
public class PageVo {
    /**
     * 分页 第几页
     */
    private int page;
    /**
     * 分页值 每页多少条
     */
    private int size;
    /**
     * 一共查询了多少条数据 一共查询了多少条数据(不需要传输 仅返回时展示使用)
     */
    private long total;
}
