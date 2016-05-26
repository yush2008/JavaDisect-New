package patterns.Structural.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoteServer {
    public static void main(String[] args) {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");

            //Instantiate RmiServer
            RemoteService obj = new RemoteServiceImpl();

            // Bind this object instance to the name "RmiServer"
            Naming.rebind("//localhost/RemoteService", obj);
            System.out.println("PeerServer bound in registry");

        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
