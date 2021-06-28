package com.asxb.bookstore.common;

/**
 * 工厂类接口
 * @author 刘斌
 * @date 2021/6/25 19:01
 */
public interface Factory<T> {

    ResultInfo<T> getObjectByEmpConstructor();

    ResultInfo<T> getSuccessTemplateObject();

}
