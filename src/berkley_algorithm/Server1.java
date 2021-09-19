
package berkley_algorithm;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;   
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 
public class Server1 {
            public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	   public static void main (String[] argv) {
           
		   try {
                          Registry reg =LocateRegistry.createRegistry(6777);
    
			   ServerImpl server1 = new   ServerImpl(LocalTime.parse("07:05:00", formatter));			   		   
	                   reg.rebind("server1", server1);
 
			   System.out.println(" Server 1  is ready .....");
                           
			   }catch (Exception e) {
				   System.out.println("Addition Server failed: " + e);
				}
		   }
}