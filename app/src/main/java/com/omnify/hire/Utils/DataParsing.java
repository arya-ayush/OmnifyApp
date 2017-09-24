package com.omnify.hire.Utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by user on 23-Sep-17.
 */

public class DataParsing {

    private DataParsing() {
    }

    public static <T> String ToString(List<T> response) {
        Gson gson = new Gson();
        String jsonToString = gson.toJson(response);
        return jsonToString;
    }

    public static <T> List<T> ToList(String jsonString, Type type) {
        Gson gson=new Gson();
        return gson.fromJson(jsonString,type);
    }


}
