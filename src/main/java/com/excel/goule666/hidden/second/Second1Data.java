package com.excel.goule666.hidden.second;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author niewenlong
 * @date 2021/11/15 11:23
 * @description 明星店铺报表-品销宝
 **/
@Data
public class Second1Data {
    @ExcelProperty("日期")
    @DateTimeFormat
    private Date text0;

    @ExcelProperty("展现量")
    private Long text1 = 0L;

    @ExcelProperty("点击量")
    private Long text2 = 0L;

    @ExcelProperty("点击率")
    private Double text3 = 0D;

    @ExcelProperty("转化率")
    private Double text4 = 0D;

    @ExcelProperty("点击单价")
    private Double text5 = 0D;

    @ExcelProperty("回报率")
    private Double text6 = 0D;

    @ExcelProperty("消耗")
    private Double text7 = 0D;

    @ExcelProperty("成交金额")
    private Double text8 = 0D;

}
