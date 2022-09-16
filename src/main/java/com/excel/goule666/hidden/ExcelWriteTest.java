package com.excel.goule666.hidden;

import com.alibaba.excel.EasyExcel;
import com.excel.goule666.ExcelReadTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.excel.goule666.ExcelReadTest.*;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 11:56 上午
 * @description
 **/
public class ExcelWriteTest {


    String sourceDetailList = "手淘搜索,手猫搜索,手淘淘宝直播,手淘有好货,进口优选,海淘笔记,手淘微淘,手淘问大家,手淘旺信,手淘消息中心,手淘我的评价,手淘卡券包,淘内免费其他,手淘首页,手猫首页,手淘天猫国际,手淘其他店铺,手淘其他店铺商品详情,手猫其他店铺,买遍全球,手淘试用,手淘拍立淘,手淘找相似,手淘扫一扫,天猫关注,WAP天猫,手淘品牌动态频道,WAP淘宝,品销宝- 明星店铺,智钻,聚划算,直通车,淘宝客,购物车,我的淘宝,直接访问";

    @Test
    public void simpleWrite(String excelFileName, String nameOfShop, String sheetName) {
        // 写法1
        String fileName = excelFileName;
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName).needHead(false).sheet(sheetName).doWrite(data(nameOfShop));
    }

    private List<List<String>> dynamicTitle() {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("日期");
        list.add("店铺");
        for (String s : sourceDetailList.split(",")) {
            if ("手淘卡券包".equals(s)) {
                list.add("淘内免费-手淘卡券包");
            } else if ("手猫搜索".equals(s)) {
                list.add("淘内免费-猫客搜索");
            } else if ("手猫首页".equals(s)) {
                list.add("淘内免费-猫客首页");
            } else {
                list.add(DataBase.PREFIX_MAP.get(s));
            }
        }
        result.add(list);
        return result;

    }

    private List<List<Object>> data(String nameOfShop) {
        List<List<Object>> stringList = new ArrayList<>();

        List<Object> list1 = new ArrayList<>();
        list1.add("日期");
        list1.add("店铺");
        for (String s : sourceDetailList.split(",")) {
            if ("手淘卡券包".equals(s)) {
                list1.add("淘内免费-手淘卡券包");
            } else if ("手猫搜索".equals(s)) {
                list1.add("淘内免费-猫客搜索");
            } else if ("手猫首页".equals(s)) {
                list1.add("淘内免费-猫客首页");
            } else {
                list1.add(DataBase.PREFIX_MAP.get(s));
            }
        }
        stringList.add(list1);


        //开始日期
        LocalDate dt1 = LocalDate.of(2022, month, day);
        for (int i = 0; i <= interval; i++) {
            List<Object> list = new ArrayList<>();
            list.add(dt1.plusDays(i).toString());
            list.add(nameOfShop);
            for (String s : sourceDetailList.split(",")) {
                Double d = DataBase.MAP.get(dt1.plusDays(i).toString() + ";" + s);
                list.add(d == null ? 0 : d);
            }
            stringList.add(list);
        }
        return stringList;
    }
}
