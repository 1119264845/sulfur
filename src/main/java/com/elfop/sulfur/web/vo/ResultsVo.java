package com.elfop.sulfur.web.vo;

import com.elfop.sulfur.domain.PageVo;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description:
 * @version: V1.0
 * @author: liu zhenming
 * @Email: 1119264845@qq.com
 * @Date: 2019/3/8 13:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ResultsVo <T> extends PageVo {

    private List<T> values;

    public ResultsVo() {
    }

    /**
     *
     * @param values
     * @param page
     * @param size
     * @param total
     */
    public ResultsVo(List<T> values, int page, int size, long total) {
        this.values = values;
        this.setPage(page);
        this.setSize(size);
        this.setTotal(total);
    }

    /**
     *
     * @param values
     * @param pageinfo
     */
    public ResultsVo(List<T> values, PageInfo pageinfo) {
        this.values = values;
        this.setPage(pageinfo.getPageNum());
        this.setSize(pageinfo.getPageSize());
        this.setTotal(pageinfo.getTotal());
    }

}
