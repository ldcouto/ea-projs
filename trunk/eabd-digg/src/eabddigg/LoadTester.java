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
        int numThreads = 10;

        ArrayList<Thread> threads = new ArrayList<Thread>(numThreads);

        int i = 0;

        while(i < numThreads){
            Worker w = new Worker();
            w.start();
            threads.add(w);
            i++;
        }

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