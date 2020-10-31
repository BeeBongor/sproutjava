package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dengmingliang
 * @Description
 * @ClassName DynamicProxy
 * @Date 2019/12/1 1:55 下午
 */
public class DynamicProxy {


    static class MyHandler implements InvocationHandler{

        Object proxy;

        public MyHandler(Object proxy){
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before invoke");
            Object ret = method.invoke(this.proxy,args);
            System.out.println("after invoke");
            return ret;
        }
    }

    public static Object agent(Class interfaceName,Object proxy){
        return Proxy.newProxyInstance(proxy.getClass().getClassLoader(),new Class[]{interfaceName},new MyHandler(proxy));
    }



}
