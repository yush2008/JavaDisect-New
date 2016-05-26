package patterns.Structural.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoteClient {
    public static void main(String[] args) {
        RemoteService obj = null;
        try {



            obj = (RemoteService) Naming.lookup("//localhost/RemoteService");
            obj.execute();

        } catch (NotBoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
