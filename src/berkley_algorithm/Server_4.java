
package berkley_algorithm;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;   
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 
public class Server_4 {
            public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	   public static void main (String[] argv) {
           
		   try {
                       Registry reg =LocateRegistry.createRegistry(6780);
    
			  ServerImpl server4 = new ServerImpl(LocalTime.parse("07:40:00", formatter));			   		   
	                   reg.rebind("server4", server4);
 
			   System.out.println(" Server 4 is ready .....");
			   }catch (Exception e) {
				   System.out.println(" Server 4 is  failed: " + e);
				}
		   }
}