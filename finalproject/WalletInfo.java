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
    public static String dateCreation; //finish this string
    public static String publicKey; //finish this string
    public static String totalTransactions; //finish this string
    


    public static void WalletInformation() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the Bitcoin wallet address to get information on: ");   
        String walletAddress = scanner.next();
        
        String balanceData = DownStr.GetString("https://api.blockcypher.com/v1/btc/main/addrs/" + walletAddress + "/balance");
        balance = Sanatizer(balanceData, "balance");
        balance = balance.replace("\"final_balance\":", "").replace(",", "");
        System.out.println("Balance: 0.0" + balance + "\nPress any key to continue...");
        System.in.read();
        ToMenu.Clear();
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
