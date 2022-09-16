package com.excel.goule666.hidden.second;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author niewenlong
 * @date 2021/11/15 11:23
 * @description 20211008110357_账户-直通车
 **/
@Data
public class Second3Data {

    @ExcelProperty("日期")
    @DateTimeFormat
    private Date text0;

    @ExcelProperty("展现量")
    private Long text1 = 0L;

    @ExcelProperty("点击量")
    private Long text2 = 0L;

    @ExcelProperty("总成交笔数")
    private Long text3 = 0L;

    @ExcelProperty("平均点击花费")
    private Double text4 = 0D;

    @ExcelProperty("花费")
    private Double text5 = 0D;

    @ExcelProperty("总成交金额")
    private Double text6 = 0D;

    @ExcelProperty("投入产出比")
    private Double text7 = 0D;

}
