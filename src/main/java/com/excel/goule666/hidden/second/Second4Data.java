package com.excel.goule666.hidden.second;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.util.Date;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 12:01 下午
 * @description 报表数据_30天归因20220908151420-钻展
 **/
@Data
public class Second4Data {
    @ExcelProperty("日期")
    @DateTimeFormat
    private Date text0;

    @ExcelProperty("展现量")
    private Long text1 = 0L;

    @ExcelProperty("点击量")
    private Long text2 = 0L;

    @ExcelProperty("成交笔数")
    private Long text3 = 0L;

    @ExcelProperty("总成交金额")
    private Double text4 = 0D;

    @ExcelProperty("花费")
    private Double text5 = 0D;

}
