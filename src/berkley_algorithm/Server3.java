
package berkley_algorithm;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;   
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 
public class Server3 {
            public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	   public static void main (String[] argv) {
           
		   try {
                           Registry reg =LocateRegistry.createRegistry(6779);
    
			   ServerImpl server3 = new ServerImpl(LocalTime.parse("07:20:00", formatter));			   		   
	                 reg.rebind("server3", server3);
 
			   System.out.println(" Server 3 is ready .....");
			   }catch (Exception e) {
				   System.out.println(" Server 3  failed to run : " + e);
				}
		   }
}