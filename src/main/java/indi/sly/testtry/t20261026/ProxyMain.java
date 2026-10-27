package indi.sly.testtry.t20261026;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ProxyMain implements InvocationHandler {
    static void main() {
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), new Class[]{ProxyInterface.class}, new ProxyMain());

        List<TestP> list = new ArrayList<>();
        list.add(new TestP());

        //proxy.d2(list);

        proxy.d3(null);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (args != null) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type returnType = method.getGenericReturnType();

            for (Type genericParameterType : genericParameterTypes) {
                if (genericParameterType instanceof ParameterizedType parameterizedType) {
                    System.out.println("parameterizedType");

                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

                    if (actualTypeArguments[0] instanceof WildcardType wildcardType) {
                        Type[] upperBounds = wildcardType.getUpperBounds();

                        System.out.println("upperBounds");

                    } else if (actualTypeArguments[0] instanceof TypeVariable<?> typeVariable) {
                        Type[] bounds = typeVariable.getBounds();

                        System.out.println("bounds");
                    }

                    System.out.println(actualTypeArguments.length);
                }
                if (genericParameterType instanceof WildcardType wildcardType) {
                    System.out.println("wildcardType");
                }
                if (genericParameterType instanceof TypeVariable<?> typeVariable) {
                    System.out.println("typeVariable");
                }

            }


        } else {
            System.out.println("NULL");
        }

        return null;
    }
}
