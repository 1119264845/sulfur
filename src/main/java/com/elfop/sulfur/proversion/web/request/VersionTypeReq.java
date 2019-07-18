package com.elfop.sulfur.proversion.web.request;

import com.elfop.sulfur.base.common.SortVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/18  15:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "version 数据type查询")
public class VersionTypeReq {

    @ApiModelProperty(value = "version type", name = "type", dataType = "string", example = "test")
    private String type;

    @Builder.Default
    @ApiModelProperty(value = "分页排序字段", name = "sortVo")
    private SortVo sortVo = new SortVo();

}
