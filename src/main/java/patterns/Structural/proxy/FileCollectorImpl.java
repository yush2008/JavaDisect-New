package patterns.Structural.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileCollectorImpl implements Collector {
    private static final String type = "FILE";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void collect() {
        System.out.println("Started collecting");
        System.out.println("Doing some business");
        System.out.println("Done with collection");
    }
}
