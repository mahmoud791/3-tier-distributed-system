import java.io.*;
import java.net.*;
import java.util.Random;
/**
 * this class represents the first Tier which consists of sensors, cameras, and traffic signs
 * from  where the value of each of cameras and sensors values are
 * either 'Crowded' to inducate that this part is crowded 
 * or 'Empty' to indicate that this part is empty
 * then the system should send to traffic signs the appropriate signals 
 * to recommend a road to the drivers
 */
public class Tier_1
{
    private static Socket Tier_1_2;
      


    public static void main(String[] args) throws IOException
    {
        Tier_1_2 = new Socket("localhost",2000);    //socket connecting Tier 1 & 2


        Thread sensor_1 = new Tier_1_2_manager(Tier_1_2, generate_status());
        Thread sensor_2 = new Tier_1_2_manager(Tier_1_2, generate_status());
        Thread camera_1 = new Tier_1_2_manager(Tier_1_2, generate_status());
        Thread camera_2 = new Tier_1_2_manager(Tier_1_2, generate_status());

        while (true)
        {

            sensor_1.run();
            sensor_2.run();
            camera_1.run();
            camera_2.run();
        }



    }

    private  static String generate_status()
    {   
        Random rand = new Random();
        if ( rand.nextDouble() >= 0.5 )
        {
            return "Crowded";
        }

        else return "Empty"; 

    }
}