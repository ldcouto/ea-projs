/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import eabddigg.loadtests.Worker;
import java.util.ArrayList;

/**
 *
 * @author fork
 */
public class LoadTester {

    public static void main(String[] args){
        int numThreads = 50;

        ArrayList<Thread> threads = new ArrayList<Thread>(numThreads);

        int i = 0;

        while(i < numThreads){
            Worker w = new Worker(i,args[0],args[1],args[2]);
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
