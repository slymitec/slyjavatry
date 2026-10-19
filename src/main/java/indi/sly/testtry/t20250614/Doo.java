package indi.sly.testtry.t20250614;

import indi.sly.testtry.t20250614.lang.LogicalUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Doo {
    public static void at(Class<?> clazz, String methodName) {
        if (clazz.getSuperclass() != null) {
            at(clazz.getSuperclass(), methodName);
        }

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            at(anInterface, methodName);
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
            }
        }

        if (method != null) {
            Annotation[] methodDeclaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation methodDeclaredAnnotation : methodDeclaredAnnotations) {
                if (methodDeclaredAnnotation.annotationType() == MethodScope.class && (LogicalUtil.isAnyExist(((MethodScope) methodDeclaredAnnotation).value(), MethodScopeType.ONLY_KERNEL))) {
                    throw new RuntimeException(clazz.getName() + " " + methodName + " " + "StatusNotSupportedException");
                }
            }
        }
    }

    public static void doo() throws Exception {
        TestObject testObject = new TestObject();

        String methodName = "IA2";

        Class<?> clazz = testObject.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            System.out.println("StatusNotExistedException");
        }


        try {
            at(clazz, methodName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Class<?>[] methodParameterTypes = method.getParameterTypes();
        Object[] methodParameterValues = new Object[methodParameterTypes.length];
        Class<?> methodReturnType = method.getReturnType();


        Object result = null;
        try {
            result = method.invoke(testObject, methodParameterValues);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("StatusUnexpectedException");
        }
        if (methodReturnType != void.class) {
            System.out.println(result);
        }

//        Thread vT = Thread.ofPlatform().start(()->{
//            System.out.println("VS...");
//        });
//        vT.join();
    }
}
