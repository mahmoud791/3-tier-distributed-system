import java.io.*; 
import java.net.*;


public class Tier_3_2_manager extends Thread
{
    private  Socket Tier_3_2;  //this socket to recive from tier 2 to tier 3


    public Tier_3_2_manager(Socket Tier_3_2)
    {
        this.Tier_3_2 = Tier_3_2;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
            String message_from_tier_2 = recieveFromTier_2();
            String responce = process(message_from_tier_2);
            sendToTier_2(responce);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();

        }

    }

    private  String recieveFromTier_2() throws IOException
    {
        InputStreamReader in= new InputStreamReader(this.Tier_3_2.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        return bf.readLine();
    }
    private  void sendToTier_2(String message) throws IOException
    {
        PrintWriter pr = new PrintWriter(this.Tier_3_2.getOutputStream(),true);
        pr.println(message);
        
    }

    private String process(String message_from_Tier_2)
    {
        if(message_from_Tier_2 == "Crowded")
        {
            return "open traffic sign";
        }
        else
        {
            return "close traffic sign";
        }

    }



    
}
