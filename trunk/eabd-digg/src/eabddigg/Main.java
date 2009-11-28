/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import connectionhandler.MyConnectionHandler;
import gui.GUI;

/**
 *
 * @author lc
 */
public class Main {


    public static void main(String[] args){
        if (args[0].compareTo("GUI") == 0)
                GUI.main(args);
        else {
            try {
                    if (args[0].compareTo("ALL") == 0){
                    MyConnectionHandler.start(args[1], args[2], args[3], args[4], args[5]);
                    System.out.println("Filling DB and testing...");
                    Filler.fillBD();
                    System.out.println("DB filled. Starting tests...");
                    LoadTester.go();
                    System.out.println("Tests completed.");
                }
                    else if (args[0].compareTo("FL") == 0){
                    MyConnectionHandler.start(args[1], args[2], args[3], args[4], args[5]);
                    System.out.println("Filling DB...");
                    Filler.fillBD();
                    System.out.println("DB filled");
                    }
                        else if (args[0].compareTo("LT") == 0){
                        MyConnectionHandler.start(args[1], args[2], args[3], args[4], args[5]);
                        System.out.println("Testing DB...");
                        LoadTester.go();
                        System.out.println("Tests completed.");
                        }
                            else {
                            System.out.println("Error. You gave a bad option.");
                            System.out.println("Options are: ALL, LT, FL and GUI.");
                            System.out.println("Check the Readme for more info.");
                            }
            }
            catch (Exception e) {System.err.println("An error occurred. Did you specify all the parameters? Check the Readme or try using Graphic Mode.");}
        }
    }
}
