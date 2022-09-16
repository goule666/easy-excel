package com.excel.goule666.hidden;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;


/**
 * @author gouleniewenlong
 * @date 2021/7/26 12:01 下午
 * @description
 **/
@Slf4j
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context context
     */
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        DataBase.MAP.put(context.readWorkbookHolder().getFile().getName().split("_")[1].replace(".xls", "") + ";" + data.getSourceDetail(), data.getUniqueVisitors());
        DataBase.PREFIX_MAP.put(data.getSourceDetail(), data.getFlowSource() + "-" + data.getSourceDetail());
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
