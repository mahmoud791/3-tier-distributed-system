import java.io.*; 
import java.net.*;


public class Tier_3
{
    private static Socket Tier_3_2;

    public static void main(String[] args) throws IOException
    {
        ServerSocket Tier_3_reciever = new ServerSocket(3000);

        while(true)
        {
            Tier_3_2 = Tier_3_reciever.accept();
            
            Thread server = new  Tier_3_2_manager(Tier_3_2);
            
            try
            {
                server.start();
            }
            catch(Exception e)
            {
                Tier_3_2.close();
                e.printStackTrace();
            }
        }
        
    } 


    
}
