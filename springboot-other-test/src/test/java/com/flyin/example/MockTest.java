package com.flyin.example;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.script.JavaScriptEngine;
import cn.hutool.script.ScriptUtil;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

/**
 * @author 王军
 * @description
 * @date 2021/12/14 14:44
 */
public class MockTest {
    @Test
    public void eval() throws ScriptException {
        JavaScriptEngine scriptEngine = ScriptUtil.getJavaScriptEngine();
        String url = "https://cdn.bootcss.com/Mock.js/1.0.1-beta3/mock-min.js";
        String scriptString = HttpUtil.downloadString(url, CharsetUtil.UTF_8);
        scriptEngine.eval(scriptString);
        Object eval = scriptEngine.eval("Mock.Random.boolean()");
        System.out.println(eval);
    }
}