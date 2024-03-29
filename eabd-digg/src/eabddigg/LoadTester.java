/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import connectionhandler.MyConnectionHandler;
import eabddigg.loadtests.Worker;
import java.util.ArrayList;

/**
 *
 * @author fork
 */
public class LoadTester {

    public static void go(){
        int numThreads = 50;

        ArrayList<Thread> threads = new ArrayList<Thread>(numThreads);

        int i = 0;

        while(i < numThreads){
            Worker w = new Worker(i);
            w.start();
            threads.add(w);
            i++;
        }

        System.out.println("Done starting "+numThreads+" workers");

        i = 0;
        while (i < numThreads){
            try {
                threads.get(i).join();
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
                ex.printStackTrace();
            }
            i++;
        }
        System.out.println("Done running "+numThreads+ " workers.");
    }
}
