package patterns.Structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectorInvocationHandler implements InvocationHandler {

    private Collector collector;
    CollectorInvocationHandler(Collector collector){
        this.collector = collector;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invocation through a proxy object");

        return method.invoke(collector,args);
    }


}
