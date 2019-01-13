package cn.itcast.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class TestLogAop {

    @Before("execution(* cn.itcast.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //获取访问的类
        Class clazz = jp.getTarget().getClass();
        //获取访问的方法
        String methodName = jp.getSignature().getName();
        //获取方法的参数
        Object[] args = jp.getArgs();
        if(args==null||args.length==0){
            Method method = clazz.getMethod(methodName);
        }else{
            Class[] c = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                c[i] = args[i].getClass();
            }
            Method method = clazz.getMethod(methodName, c);
        }


    }

}
