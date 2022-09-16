package com.excel.goule666.hidden.second;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author niewenlong
 * @date 2021/11/15 14:17
 * @description
 **/
public class SecondDataBase {
    public static final Map<Long, Map<String, Object>> DB = new TreeMap<>();

    public static void clear() {
        DB.clear();
    }
}
