
package berkley_algorithm;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;   
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 
public class Server2 {
            public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	   public static void main (String[] argv) {
           
		   try {
                       Registry reg =LocateRegistry.createRegistry(6555);
    
			  ServerImpl server2 = new ServerImpl(LocalTime.parse("07:25:00", formatter));			   		   
	                   reg.rebind("server2", server2);
 
			   System.out.println(" Server 2 is ready .....");
			   }catch (Exception e) {
				   System.out.println(" Server 2 is  failed: " + e);
				}
		   }
}