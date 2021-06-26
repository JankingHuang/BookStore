package com.asxb.bookstore.common.impl;

import com.asxb.bookstore.common.Factory;
import com.asxb.bookstore.common.ResultInfo;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 结果集的简单工场模式
 * @param <T> ResultInfo 中承载的数据类型，可以是自定义的bean
 * @author 刘斌
 * @date 2021/6/25
 */
@Component
public class ResultInfoFactory<T> implements Factory<T> {

    private ResultInfo<T> resultInfo;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ResultInfo<T> getObjectByEmpConstructor() {
        resultInfo = new ResultInfo<>();
        resultInfo.setNow(SIMPLE_DATE_FORMAT.format(new Date()));
        return resultInfo;
    }

    @Override
    public ResultInfo<T> getSuccessTemplateObject() {
        resultInfo = getObjectByEmpConstructor();
        resultInfo.setMsg("success");
        resultInfo.setCode(200);
        return resultInfo;
    }
}
