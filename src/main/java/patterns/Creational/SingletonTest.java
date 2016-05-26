package patterns.Creational;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingletonTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        MSingleton o1 = MSingleton.getMSingletonInst();
        o1.set_id("12123123");

        MSingleton o2 = MSingleton.getMSingletonInst();

        System.out.println(o2.get_id());
    }

}

interface SingletonInterface{

}
class MSingleton implements SingletonInterface,Serializable {
    private static final long serialVersionUID = 1L;
    //Lazzy initialization
    private static MSingleton _inst;
    private String _id;

    private MSingleton() {
    }

    public static MSingleton getMSingletonInst() {
        //Double check before and after synchronization
        if (_inst == null) {
            synchronized (MSingleton.class) {
                if (_inst == null)
                    _inst = (MSingleton) getInstance();
            }
        }

        return _inst;

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    //Used to replace the object read from OutputSteam
   //If an object is read twice using two different Output Streams. Than two different objects will be generated.
  // Two objects are read before and after reset() of output stream, than both outputs lead to different object.
    private Object readResolve() throws ObjectStreamException {
        return _inst;
    }

    private Object readObject() throws ObjectStreamException {
        return _inst;
    }

    //With multiple classloaders
    public synchronized static SingletonInterface getInstance() {
        ClassLoader myClassLoader = MSingleton.class.getClassLoader();
        if (_inst==null) {
            // The root classloader is sun.misc.Launcher package. If we are not in a sun package,
            // we need to get hold of the instance of ourself from the class in the root classloader.
            if (! myClassLoader.toString().startsWith("com.li.MyClassLoader")) {
                try {
                    // So we find our parent classloader
                    ClassLoader parentClassLoader = myClassLoader.getParent();
                    // And get the other version of our current class
                    Class otherClassInstance = parentClassLoader.loadClass(MSingleton.class.getName());
                    // And call its getInstance method - this gives the correct instance of ourself
                    Method getInstanceMethod = otherClassInstance.getDeclaredMethod("getInstance", new Class[] { });
                    Object otherAbsoluteSingleton = getInstanceMethod.invoke(null, new Object[] { } );
                    // But, we can't cast it to our own interface directly because classes loaded from
                    // different classloaders implement different versions of an interface.
                    // So instead, we use java.lang.reflect.Proxy to wrap it in an object that *does*
                    // support our interface, and the proxy will use reflection to pass through all calls
                    // to the object.

                    _inst = (MSingleton) Proxy.newProxyInstance(myClassLoader,
                            new Class[] { SingletonInterface.class },
                            new PassThroughProxyHandler(otherAbsoluteSingleton));
                    // And catch the usual tedious set of reflection exceptions
                    // We're cheating here and just catching everything - don't do this in real code
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // We're in the root classloader, so the instance we have here is the correct one
            } else {
                _inst = new MSingleton();
            }
        }

        return _inst;
    }



}

class PassThroughProxyHandler implements InvocationHandler{

    private Object delegate = null;
    PassThroughProxyHandler(Object obj){
        delegate = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method delegateMethod = delegate.getClass().getMethod(method.getName(), method.getParameterTypes());
        return delegateMethod.invoke(delegate, args);
    }
}