package com.goeuro.interview.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class HttpUtilTest {
    @Test
    public void testEncodeUrl() throws Exception {
        String url = "this is part+of&param";
        Assert.assertEquals(HttpUtil.urlEncode(url), "this+is+part%2Bof%26param");

    }
}
