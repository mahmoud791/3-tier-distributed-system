import java.io.*;
import java.net.*;


public class Tier_1_2_3_manager extends Thread 
{


    private Socket Tier_1;   //socket to connect to Tier_1

    private Socket Tier_3;

    



    public Tier_1_2_3_manager(Socket Tier_1 ,Socket Tier_3)
    {
        this.Tier_1 = Tier_1;
        this.Tier_3 = Tier_3;

    }

    @Override
    public void run()
    {
        String Tier_3_message = null;
        String Tier_1_message = null;
        while (true) 
        {
            try
            {

                Tier_1_message = recieveFromTier_1();
                if (Tier_1_message != null)
                    sendToTier_3(Tier_1_message);
                Tier_3_message = recieveFromTier_3();
                if (Tier_3_message != null)
                    sendToTier_1(Tier_3_message);

            } 
            catch (IOException e)
            {
               e.printStackTrace();
            }
        } 

    }






    private String recieveFromTier_1() throws IOException
    {
        InputStreamReader in = new InputStreamReader(this.Tier_1.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        return bf.readLine();
    }

    private void sendToTier_1(String message) throws IOException
    {
        
        PrintWriter pr = new PrintWriter(this.Tier_1.getOutputStream(),true);
        pr.println(message);
    }

    private String recieveFromTier_3() throws IOException
    {
        InputStreamReader in = new InputStreamReader(this.Tier_3.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        return bf.readLine();
    }

    private void sendToTier_3(String message) throws IOException
    {
        PrintWriter pr = new PrintWriter(this.Tier_3.getOutputStream(),true);
        pr.println(message);
    }
}
