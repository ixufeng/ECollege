package com.xf.college.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by xufeng on 2017/3/6.
 */
public class JSONUtils {

    public static String toJsonString(Object o, String defaultValue) {
        try {
            return toJsonString(o);
        } catch (JsonProcessingException e) {
            return defaultValue;
        }
    }

    public static String toJsonString(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}
