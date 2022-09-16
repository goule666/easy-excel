package com.excel.goule666.hidden;

import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 12:01 下午
 * @description
 **/
@Data
public class DemoData {
    /**
     * 流量来源
     */
    private String flowSource;

    /**
     * 来源明细
     */
    private String sourceDetail;

    /**
     * 访客数
     */
    @NumberFormat("#.#")
    private Double uniqueVisitors;
}
