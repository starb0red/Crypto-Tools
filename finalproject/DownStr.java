/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.net.*;
import java.io.*; 

public class DownStr {
  public static String GetString(String theUrl)  
  {  
    StringBuilder content = new StringBuilder();  
  // Use try and catch to avoid the exceptions  
    try  
    {  
      URL url = new URL(theUrl); // creating a url object  
      URLConnection urlConnection = url.openConnection(); // creating a urlconnection object  
        try ( // wrapping the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            } }  
    }  
    catch(IOException e)  
    {  
      e.printStackTrace();  
    }  
    return content.toString();  
  }
}
