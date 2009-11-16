/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import connectionhandler.MyConnectionHandler;

/**
 *
 * @author lc
 */
public class Main {


    public static void main(String[] args){
        String[] argzinhos = {"localhost","5432","digg","tester","tester"};
        MyConnectionHandler.start(argzinhos[0], argzinhos[1], argzinhos[2], argzinhos[3], argzinhos[4]);
        System.out.println("Filling DB...");
        Filler.fillBD();
        System.out.println("DB filled. Starting tests...");
        LoadTester.go();
    }
}
