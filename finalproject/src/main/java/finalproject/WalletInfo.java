/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author knife
 */
public class WalletInfo {
    public static String balance;
    public static String totalSent; 
    public static String totalRecieved; //finish this string
    public static String totalTransactions; 
    
    public static void WalletInformation() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the Bitcoin wallet address to get information on: ");   
        try
        {
            String walletAddress = scanner.next();
        
            String balanceData = DownStr.GetString("https://api.blockcypher.com/v1/btc/main/addrs/" + walletAddress + "/balance"); //downloads wallet data from blockcyphr api
        
            balance = Sanatizer(balanceData, "balance"); //Removes junk from String so it will print clean on the console
            balance = balance.replace("  \"final_balance\":", "").replace(",", "").replace(" ", "");
        
            totalSent = Sanatizer(balanceData, "total_sent");
            totalSent = totalSent.replace("  \"total_sent\":", "");
            
            totalRecieved = Sanatizer(balanceData, "total_received");
            totalRecieved = totalRecieved.replace("  \"total_received\":", "");
            
            totalTransactions = Sanatizer(balanceData, "final_n_tx");
            totalTransactions = totalTransactions.replace("  \"final_n_tx\":", "");
       
        
        
            System.out.println("Wallet Address: " + walletAddress + "\nTotal BTC Sent: " + totalSent + "\nTotal BTC Recieved: " + totalRecieved + "\nTotal BTC Transactions:" + totalTransactions + "\nBTC Balance: 0.0" + balance + "\nPress any key to continue...");
            System.in.read();
            ToMenu.Clear();
        }catch(IOException e)
        {
            System.out.println("Invalid Bitcoin Address or some error occured!\nPress any key to return to Menu...");
            System.in.read();
            ToMenu.Clear();
        }
        
        
    }   
    
    public static String Sanatizer(String data, String lineData ) //this String method scans given data to look for in a string. if found it will return the line that contains the data that is wanted to be looked for.
    {
        String lineReturn = null;
         Scanner scanner = new Scanner(data);
         while (scanner.hasNextLine())
         {
             String line = scanner.nextLine();
             if(line.contains(lineData))
             {
                lineReturn = line;
             }
         }
         return lineReturn;
    }
}
