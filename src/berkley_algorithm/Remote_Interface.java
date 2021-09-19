
package berkley_algorithm;

 import java.rmi.*;
import java.time.LocalTime;
 
   public interface Remote_Interface extends Remote {
           void adjust_time(LocalTime client_time, long nanos) throws RemoteException;
           public LocalTime getTime() throws RemoteException;
   }