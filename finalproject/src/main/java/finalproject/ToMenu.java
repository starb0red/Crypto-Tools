/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.io.IOException;


/**
 *
 * @author knife
 */
public class ToMenu {
    public static void Clear() throws IOException //quick way of returning to the main menu instead of an alternative.
    {
        System.out.flush();
        Finalproject.Menu();
    }
}
