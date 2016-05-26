package patterns.Structural.proxy;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Collector dc = new FileCollectorImpl();
        //dc.collect();

        Collector proxyDc = (Collector) Proxy.newProxyInstance(FileCollectorImpl.class.getClassLoader(),
                new Class[]{Collector.class}, new CollectorInvocationHandler(dc));
        proxyDc.collect();

    }
}
