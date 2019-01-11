package cn.itcast.utils;

import java.lang.reflect.Method;

@AnnotionTest("类")
public class Test1 {

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotionTest annotation = Test1.class.getAnnotation(AnnotionTest.class);
        String value = annotation.value();
        System.out.println(value);
        Method method = Test2.class.getMethod("method");
        boolean annotationPresent = method.isAnnotationPresent(AnnotionTest.class);
        AnnotionTest annotation1 = method.getAnnotation(AnnotionTest.class);
        String value1 = annotation1.value();
        System.out.println(value1);
        System.out.println(annotationPresent);
    }
}
