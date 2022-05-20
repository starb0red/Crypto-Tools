package finalproject;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalproject {

    public static void main(String[] args) throws IOException{
        Menu();
    }
    public static void Menu() throws IOException
    {
        Logo(); //Prints the logo UI to the console
        
        Scanner s = new Scanner(System.in);
        System.out.print("Select an option: ");

        String option = s.next();
        if(option.length() == 1)
        {
            if("1".equals(option)) price.getCurrentPrice();
            if("2".equals(option)) WalletInfo.WalletInformation();
            if("3".equals(option)) NewWallet.CreateWallet();
            if("e".equals(option)) System.exit(0);
        }
        else
        {
            System.out.flush();
            System.out.println("Error!\nYou selected an option that doesn't exist.\n(Taking you back in two seconds)");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) { //catches any errors that this project gives off :P
                Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.flush();
            Menu();
        }
    }
    static void Logo()
    {
        System.out.println("  _                      ___            ");
        System.out.println(" / ` _       _  _)_ _     ) _   _   ) _ ");
        System.out.println("(_. ) (_(   )_) (_ (_)   ( (_) (_) ( (  ");
        System.out.println("        _) (                         _)    -Final Project\n \n1.)Get cryto coin current prices. \n2.)Bitcoin wallet information. \n3.)Create new Bitcoin wallet.   \n\ne.) Exit");
    }
}
