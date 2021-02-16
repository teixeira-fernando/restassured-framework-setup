package org.fernando.setup.commons.request;

import java.util.HashMap;
import java.util.Map;

public class HeadersDefinition {

    public static Map<String, String> getHeaders(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type","application/json");

        return headers;
    }
}
