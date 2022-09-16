package com.excel.goule666.hidden.second;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.excel.goule666.hidden.second.SecondDataBase.DB;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 12:01 下午
 * @description
 **/
@Slf4j
public class Second1DataListener extends AnalysisEventListener<Second1Data> {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context context
     */
    @Override
    public void invoke(Second1Data data, AnalysisContext context) {
        if (DB.containsKey(data.getText0().getTime())) {
            Map<String, Object> value = DB.get(data.getText0().getTime());
            if (!value.containsKey("second1")) {
                value.put("second1", data);
            }
        } else {
            Map<String, Object> value = new HashMap<>(16);
            value.put("second1", data);
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

    }
}
