
package berkley_algorithm;


import java.rmi.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
 
public class Master_Clock {
        public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static void main (String[] args) {
		Remote_Interface s1;
		try {
                    
                    ArrayList<LocalTime> times = new ArrayList<LocalTime>();
                   LocalTime Localtime = LocalTime.parse("07:00:00", formatter);
                   times.add(Localtime);
  
                   
                   
                   System.out.println(" Local Time : " + formatter.format(Localtime));
                   System.out.println();
                   //Server 1
	           s1 = (Remote_Interface)Naming.lookup("rmi://localhost:6777/server1");
	           LocalTime server1=s1.getTime();
		   times.add(server1);
                   System.out.println("Server 1 Time :"+formatter.format(server1)); 
             
                     //Server 2
      
       
              //Server2 
                  Remote_Interface   s2 = (Remote_Interface)Naming.lookup("rmi://localhost:6555/server2");
                    LocalTime server2=s2.getTime();
                    times.add(server2);
                    System.out.println("Server 2 Time :"+formatter.format(server2)); 
   
              //Server3
                    Remote_Interface   s3 = (Remote_Interface)Naming.lookup("rmi://localhost:6779/server3");
                    LocalTime server3=s3.getTime();
                    times.add(server3);
                    System.out.println("Server 3 Time :"+formatter.format(server3)); 
                     
                    
//Server4
                    Remote_Interface   s4 = (Remote_Interface)Naming.lookup("rmi://localhost:6780/server4");
                    LocalTime server4=s4.getTime();
                    times.add(server4);
                    System.out.println("Server 4 Time :"+formatter.format(server4)); 
                                         
              // Calculate clock difference
                      
                         long Local_time = Localtime.toNanoOfDay();

			long server1_difference = server1.toNanoOfDay() - Local_time;
			long server2_difference = server2.toNanoOfDay() - Local_time;
			long server3_difference = server3.toNanoOfDay() - Local_time;
			long server4_difference = server4.toNanoOfDay() - Local_time;
			long average_Difference = (  server1_difference  +server2_difference +server3_difference +server4_difference ) / 5; 
                   
                      
                        
                        //Adjust The time
                        s1.adjust_time(Localtime, average_Difference);
                        s2.adjust_time(Localtime, average_Difference);
                        s3.adjust_time(Localtime, average_Difference);
                        s4.adjust_time(Localtime, average_Difference);
                        Localtime = Localtime.plusNanos(average_Difference);
                        
                        
                       //Sent clock to all other 
			System.out.println("Time is Adjusted");
                        System.out.println();
                        
                        System.out.println(" Local Time: " + formatter.format(Localtime));
                        System.out.println();
			System.out.println(" Server  1: " + formatter.format(s1.getTime()));
                        System.out.println();
			System.out.println(" Server  2: " + formatter.format(s2.getTime()));
                        System.out.println();
	        	System.out.println( " Server  3: " + formatter.format(s3.getTime()));
                        System.out.println();
	        	System.out.println( " Server  4: " + formatter.format(s4.getTime()));
                       
                    
            
			}catch (Exception e) {
				System.out.println("Error " + e);
				}
		}
}