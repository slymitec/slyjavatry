package indi.sly.testtry.t20261026;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain implements InvocationHandler {
    static void main() {
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), new Class[]{ProxyInterface.class}, new ProxyMain());
        proxy.doo1();

        proxy.doo2(2);

        proxy.doo3();

        proxy.doo3(null);

        proxy.doo3(1, null);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (args != null) {
            System.out.println(args.length);
        } else {
            System.out.println("NULL");
        }

        return null;
    }
}
