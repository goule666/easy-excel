package com.excel.goule666.hidden.second;



import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
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
public class Second4DataListener extends AnalysisEventListener<Second4Data> {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context context
     */
    @Override
    public void invoke(Second4Data data, AnalysisContext context) {
        if (DB.containsKey(data.getText0().getTime())) {
            if (!DB.get(data.getText0().getTime()).containsKey("second4")) {
                Map<String, Object> value = DB.get(data.getText0().getTime());
                value.put("second4", data);
            } else {
                Second4Data data1 = (Second4Data) DB.get(data.getText0().getTime()).get("second4");
                data1.setText1(data1.getText1() + data.getText1());
                data1.setText2(data1.getText2() + data.getText2());
                data1.setText3(data1.getText3() + data.getText3());
                data1.setText4(data1.getText4() + data.getText4());
                data1.setText5(data1.getText5() + data.getText5());
            }
        } else {
            Map<String, Object> value = new HashMap<>(16);
            value.put("second4", data);
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
