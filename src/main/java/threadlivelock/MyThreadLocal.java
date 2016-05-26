package threadlivelock;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 23/1/14
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyThreadLocal {

    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static void set(String user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Object get() {
        return userThreadLocal.get();
    }
}
