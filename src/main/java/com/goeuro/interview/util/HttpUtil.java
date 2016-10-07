package com.goeuro.interview.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

/**
 * Created by pratyushverma on 10/6/16.
 */
public class HttpUtil {
    private static Logger LOGGER = Logger.getLogger(HttpUtil.class.getName());

    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }
}
