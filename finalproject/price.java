/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.*;
/**
 *
 * @author knife
 */
public class price {
    public static void getCurrentPrice(){
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the cryptocurrency symbol (Ex: btc.) (Leave blank for Bitcoin): ");
        
        String sym = s.next();
        if(sym == null) sym = "btc";
        String data = DownStr.GetString("https://api.binance.com/api/v3/ticker/price?symbol=" + sym.toUpperCase() + "USDT"); //Uses the binance API as it is very useful
        data = data.replace("{\"symbol\":\"" + sym.toUpperCase() + "USDT\",\"price\":\"", "").replace("000000\"}", "");
        System.out.println(sym.toUpperCase() + "'s Current Price: $" + data);
    }

}
