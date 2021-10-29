import java.io.*;
import java.net.*;

/**
 * this class handles the messages sending  from Tier 1 
 * to Tier 2 and message  recieving from Tier 2 to Tier 1 
 * as it represents each differnt sensor,traffic sign 
 * or camera with a differnt  client thread 
 */

class Tier_1_2_manager extends Thread
{

    private Socket tier_1_2_Socket;
    private static int threadcount = 0;
    private int ID;
    private String status;

    public Tier_1_2_manager(Socket tier_1_2_Socket,String status)
    {
        this.tier_1_2_Socket = tier_1_2_Socket;
        this.status = status;
        this.ID = threadcount;
        threadcount++;

    }
    @Override
    public void run()
    {
        try
        {
          interactwith_Tier_2(status);  
        }
        catch(IOException e)
        {
            e.printStackTrace();;
        }
    }


    public void interactwith_Tier_2(String status) throws IOException
    {
        System.out.println("client no: " + (ID+1) + " sends " + status);
        
        sendToTier_2(status);
        String responce = recieveFromTier_2();
        System.out.println(responce);

    }

    

    private void sendToTier_2(String status) throws IOException
    {
        PrintWriter pr = new PrintWriter(this.tier_1_2_Socket.getOutputStream(),true);
        pr.println(status);
    }

    private String recieveFromTier_2() throws IOException 
    {
        
        InputStreamReader in = new InputStreamReader(this.tier_1_2_Socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        return bf.readLine();
    }


}