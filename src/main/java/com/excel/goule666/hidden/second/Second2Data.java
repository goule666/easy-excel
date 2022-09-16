package com.excel.goule666.hidden.second;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author niewenlong
 * @date 2021/11/15 11:23
 * @description 2022-08-03 00_00_00_2022-08-31 23_59_59-分天数据-店铺整体-推广概览-数据汇总-淘宝客
 **/
@Data
public class Second2Data {
    @ExcelProperty("日期")
    @DateTimeFormat
    private Date text0;

    @ExcelProperty("点击人数(即进店人数)")
    private Long text1 = 0L;

    @ExcelProperty("付款笔数")
    private Long text2 = 0L;

    @ExcelProperty("付款金额(元)")
    private Double text3 = 0D;

    @ExcelProperty("确认收货笔数")
    private Long text4 = 0L;

    @ExcelProperty("确认收货金额")
    private Double text5 = 0D;

    //付款支出费用(元) = 付款佣金支出(元) + 付款服务费支出(元)
    @ExcelProperty("付款佣金支出(元)")
    private Double text6 = 0D;

    @ExcelProperty("付款服务费支出(元)")
    private Double text7 = 0D;
}
