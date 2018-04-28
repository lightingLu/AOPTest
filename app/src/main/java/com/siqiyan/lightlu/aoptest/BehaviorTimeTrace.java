package com.siqiyan.lightlu.aoptest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建日期：2018/4/28 on 23:38
 *
 * @author ludaguang
 * @version 1.0
 *          类说明：
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BehaviorTimeTrace {
    String value();
}
