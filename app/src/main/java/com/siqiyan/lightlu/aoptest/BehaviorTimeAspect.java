package com.siqiyan.lightlu.aoptest;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建日期：2018/4/28 on 23:40
 *
 * @author ludaguang
 * @version 1.0
 *          类说明：
 */
@Aspect
public class BehaviorTimeAspect {
    SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static  final String TAG="AOPDemo";
    //比作切蛋糕，如何切蛋糕
    //第一步获切点，即获得想要处理方法：* *代表所有方法，（..）代表所有参数，这里可以根据具体的方法类型来做处理
//    @Pointcut("execution(@com.siqiyan.lightlu.aoptest.BehaviorTimeTrace  * *(..))")
    @Pointcut("execution(@com.siqiyan.lightlu.aoptest.BehaviorTimeTrace  * *(..))")
    public void insertBehavior(){

    }

     //对于想好切的蛋糕，如何吃
    //第二步处理获取的切点
    @Around("insertBehavior()")
    public Object dealPoint(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获取标记的方法
        BehaviorTimeTrace annotation = signature.getMethod().getAnnotation(BehaviorTimeTrace.class);
        //获取标记方法名
        String value = annotation.value();

        Log.i(TAG,value+"开始使用的时间：   "+format.format(new Date()));
        long beagin=System.currentTimeMillis();
        Object proceed=null;

        try {
            //执行方法
            proceed = proceedingJoinPoint.proceed();
        }catch (Exception e){

        }
        Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis()-beagin)+"ms");

        return proceed;

    }


}
