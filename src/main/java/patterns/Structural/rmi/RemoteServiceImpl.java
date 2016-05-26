package patterns.Structural.rmi;

import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: pratyush
 * Date: 15/11/13
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoteServiceImpl implements RemoteService {
    @Override
    public void execute() throws RemoteException {
        System.out.println("Executing remote service");
    }
}
