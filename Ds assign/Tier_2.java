import java.io.*; 
import java.net.*;


public class Tier_2 {

    private static Socket Tier_2_1;
    //this is a socket from tier 2 to tier 1

    public static void main(String[] args) throws IOException
    {
        ServerSocket Tier_2_reciever = new ServerSocket(2000);  
        

        Socket Tier_2_3 = new Socket("localhost",3000);

        while(true)
        {

            Tier_2_1 = Tier_2_reciever.accept();

            Thread computer  = new Tier_1_2_3_manager(Tier_2_1, Tier_2_3);
            

            try
            {
                computer.run();
            }
            catch(Exception e)
            {
                Tier_2_1.close();
                e.printStackTrace();
            }



        }


    }

    




}
