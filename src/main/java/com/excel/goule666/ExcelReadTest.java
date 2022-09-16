package com.excel.goule666;

import com.alibaba.excel.EasyExcel;
import com.excel.goule666.hidden.DemoData;
import com.excel.goule666.hidden.DemoDataListener;
import com.excel.goule666.hidden.ExcelWriteTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

/**
 * @author gouleniewenlong
 * @date 2021/7/26 11:56 上午
 * @description 流量
 **/
public class ExcelReadTest {
    /**
     * 月份
     */
    public static int month = 8;

    /**
     * 天
     */
    public static int day = 3;

    /**
     * 间隔多少天
     */
    public static int interval = 36;

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void simpleRead() {
        /**
         * 店铺源数据全路径地址
         */
        String pathName = "D:\\妮素工作文档\\A-日常工作表\\easy-excel\\利尻\\流量";

        /**
         * 生成的表全路径地址
         */
        String excelFileName = "D:\\妮素工作文档\\A-日常工作表\\easy-excel\\利尻\\流量数据-利尻.xls";

        /**
         * 店铺名称
         */
        String nameOfShop = "利尻昆布海外旗舰店";

        /**
         * sheet名称
         */
        String sheetName = "流量数据-利尻";

        // 有个很重要的点 com.excel.goule666.hidden.DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        File file = new File(pathName);
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if(!f.isDirectory()){
                // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
                EasyExcel.read(f, DemoData.class, new DemoDataListener()).sheet().headRowNumber(6).doRead();
            }

        }
        ExcelWriteTest excelWriteTest = new ExcelWriteTest();
        excelWriteTest.simpleWrite(excelFileName, nameOfShop, sheetName);

        /**
         * 店铺源数据全路径地址
         */
        String pathName1 = "D:\\妮素工作文档\\A-日常工作表\\easy-excel\\可果美\\流量";

        /**
         * 生成的表全路径地址
         */
        String excelFileName1 = "D:\\妮素工作文档\\A-日常工作表\\easy-excel\\可果美\\流量数据-可果美.xls";

        /**
         * 店铺名称
         */
        String nameOfShop1 = "kagome可果美海外旗舰店";

        /**
         * sheet名称
         */
        String sheetName1 = "流量数据-可果美";

        // 有个很重要的点 com.excel.goule666.hidden.DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        File file1 = new File(pathName1);
        for (File f : Objects.requireNonNull(file1.listFiles())) {
            if(!f.isDirectory()) {
                // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
                EasyExcel.read(f, DemoData.class, new DemoDataListener()).sheet().headRowNumber(6).doRead();
            }
        }
        ExcelWriteTest excelWriteTest1 = new ExcelWriteTest();
        excelWriteTest1.simpleWrite(excelFileName1, nameOfShop1, sheetName1);
    }
}
