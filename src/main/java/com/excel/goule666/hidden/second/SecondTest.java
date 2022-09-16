package com.excel.goule666.hidden.second;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.excel.goule666.hidden.DemoData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.excel.goule666.hidden.second.SecondDataBase.DB;

/**
 * @author niewenlong
 * @date 2021/11/15 10:29
 * @description 推广
 **/
public class SecondTest {
    static String shopName = "";

    static String title = "日期\t店铺\t品销宝-展现量\t品销宝-点击量\t品销宝-点击率(%)\t品销宝-点击转化率(%)\t品销宝-平均点击花费\t品销宝-ROI\t品销宝-总花费\t品销宝-总成交额\t淘宝客-进店UV\t淘宝客-付款笔数\t淘宝客-付款金额\t淘宝客-确认收货笔数\t淘宝客-确认收货金额\t淘宝客-支出金额\t直通车-展现量\t直通车-点击量\t直通车-点击率(%)\t直通车-点击转化率(%)\t直通车-平均点击花费\t直通车-总花费\t直通车-总成交金额\t直通车-ROI\t钻展-展现量\t钻展-点击量\t钻展-点击率(%)\t钻展-点击转化率(%)\t钻展-平均点击花费\t钻展-总花费\t钻展-总成交金额\t钻展-ROI";

    boolean isFirst = true;

    @Test
    public void test() throws IOException {
        // String fileFolder = "D:\\妮素工作文档\\a-日常工作表\\easy-excel";
        String fileFolder = "/Users/niewenlong/文档/推广表需求";
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));


        Stream<Path> list = Files.list(Paths.get(fileFolder));
        try (ExcelWriter excelWriter = EasyExcel.write(fileFolder + "/推广数据-导入表-" + format + ".xlsx").needHead(false).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet").build();
            list.filter(x -> x.toFile().isDirectory()).forEach(x -> {
                        if ("可果美".equals(x.getFileName().toString())) {
                            shopName = "kagome可果美海外旗舰店";
                        }
                        if ("利尻".equals(x.getFileName().toString())) {
                            shopName = "利尻昆布海外旗舰店";
                        }
                        try {
                            Files.list(x.toAbsolutePath()).forEach(y -> {
                                if ("推广".equals(y.getFileName().toString())) {
                                    SecondDataBase.clear();
                                    try {
                                        Files.list(y.toAbsolutePath()).forEach(path -> {
                                            if (path.getFileName().toString().contains("明星店铺报表")) {
                                                EasyExcel.read(path.toFile(), Second1Data.class, new Second1DataListener()).sheet().doRead();
                                            }
                                            if (path.getFileName().toString().contains("分天数据-店铺整体-推广概览-数据汇总")) {
                                                EasyExcel.read(path.toFile(), Second2Data.class, new Second2DataListener()).sheet().doRead();
                                            }
                                            if (path.getFileName().toString().contains("账户")) {
                                                EasyExcel.read(path.toFile(), Second3Data.class, new Second3DataListener()).sheet().doRead();
                                            }
                                            if (path.getFileName().toString().contains("报表数据")) {
                                                EasyExcel.read(path.toFile(), Second4Data.class, new Second4DataListener()).sheet().doRead();
                                            }
                                        });
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            excelWriter.write(data(), writeSheet);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }

    }

    private List<List<Object>> data() {
        List<List<Object>> stringList = new ArrayList<>();

        List<Object> list1 = new ArrayList<>();
        if (isFirst) {
            list1.addAll(Arrays.asList(title.split("\t")));
            stringList.add(list1);
            isFirst = false;
        }


        DB.forEach((time, value) -> {
            List<Object> list = new ArrayList<>();
            list.add(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())));
            list.add(shopName);
            Second1Data data1 = (Second1Data) value.get("second1");
            Second2Data data2 = (Second2Data) value.get("second2");
            Second3Data data3 = (Second3Data) value.get("second3");
            Second4Data data4 = (Second4Data) value.get("second4");

            list.add(data1 == null ? 0 : data1.getText1());
            list.add(data1 == null ? 0 : data1.getText2());
            list.add(data1 == null ? 0 : data1.getText3());
            list.add(data1 == null ? 0 : data1.getText4());
            list.add(data1 == null ? 0 : data1.getText5());
            list.add(data1 == null ? 0 : data1.getText6());
            list.add(data1 == null ? 0 : data1.getText7());
            list.add(data1 == null ? 0 : data1.getText8());

            list.add(data2 == null ? 0 : data2.getText1());
            list.add(data2 == null ? 0 : data2.getText2());
            list.add(data2 == null ? 0 : data2.getText3());
            list.add(data2 == null ? 0 : data2.getText4());
            list.add(data2 == null ? 0 : data2.getText5());
            list.add(data2 == null ? 0 : data2.getText6() + data2.getText7());

            list.add(data3 == null ? 0 : data3.getText1());
            list.add(data3 == null ? 0 : data3.getText2());
            // 点击率
            list.add(data3 == null ? 0 : divide(data3.getText2(), data3.getText1()));
            // 点击转化率
            list.add(data3 == null ? 0 : divide(data3.getText3(), data3.getText2()));
            list.add(data3 == null ? 0 : data3.getText4());
            list.add(data3 == null ? 0 : data3.getText5());
            list.add(data3 == null ? 0 : data3.getText6());
            list.add(data3 == null ? 0 : data3.getText7());


            list.add(data4 == null ? 0 : data4.getText1());
            list.add(data4 == null ? 0 : data4.getText2());
            // 点击率
            list.add(data4 == null ? 0 : divide(data4.getText2(), data4.getText1()));
            // 点击转化率
            list.add(data4 == null ? 0 : divide(data4.getText3(), data4.getText2()));
            // 平均点击花费
            list.add(data4 == null ? 0 : divide(data4.getText5(), Double.parseDouble(data4.getText2().toString())));

            list.add(data4 == null ? 0 : data4.getText5());
            list.add(data4 == null ? 0 : data4.getText4());
            // ROI
            list.add(data4 == null ? 0 : divide(data4.getText4(), data4.getText5()));
            stringList.add(list);
        });
        return stringList;
    }

    private String divide(Double b1, Double b2) {
        if (b2 == 0) {
            return "0";
        }
        return BigDecimal.valueOf(b1).divide(BigDecimal.valueOf(b2), 10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }

    private String divide(long b1, long b2) {
        if (b2 == 0) {
            return "0";
        }
        return BigDecimal.valueOf(b1).divide(BigDecimal.valueOf(b2), 10, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }

}
