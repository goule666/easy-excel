package com.excel.goule666.hidden.second;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static com.excel.goule666.hidden.second.SecondDataBase.DB;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 12:01 下午
 * @description
 **/
@Slf4j
public class Second3DataListener extends AnalysisEventListener<Second3Data> {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context context
     */
    @Override
    public void invoke(Second3Data data, AnalysisContext context) {
        if (DB.containsKey(data.getText0().getTime())) {
            Map<String, Object> value = DB.get(data.getText0().getTime());
            if (!value.containsKey("second3")) {
                value.put("second3", data);
            }
        } else {
            Map<String, Object> value = new HashMap<>(16);
            value.put("second3", data);
            DB.put(data.getText0().getTime(), value);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    }
}
