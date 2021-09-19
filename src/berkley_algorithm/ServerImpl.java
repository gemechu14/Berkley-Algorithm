
package berkley_algorithm;

import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class ServerImpl extends UnicastRemoteObject
         implements Remote_Interface {
     
    
      private LocalTime time;
    public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
      public ServerImpl (LocalTime time) throws RemoteException {
      
      this.time=time;
              }
      

    @Override
    public LocalTime getTime() throws RemoteException {
       return time;

    }

    @Override
    public void adjust_time(LocalTime client_time, long diff_nanos) throws RemoteException {
       
          try {
            long localnano= client_time.toNanoOfDay();
            long thisnanos = this.getTime().toNanoOfDay();
            long newNanos =thisnanos- localnano;
            
             newNanos=newNanos * -1 + diff_nanos + thisnanos;
            
            LocalTime newlocalTime =LocalTime.ofNanoOfDay(newNanos);
            System.out.println("Actual time is"+formatter.format(newlocalTime));
            
            this.time= newlocalTime;
            
        } catch (RemoteException ex) {
           System.out.print(ex);
        }

    }
        
    }
 