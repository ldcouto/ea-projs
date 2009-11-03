/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg;

import eabddigg.dados.*;
import java.util.ArrayList;

/**
 *
 * @author lc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema();
        Filler f = new Filler();
        long now = System.currentTimeMillis();
        System.out.println(now + ") Here we go...");
        f.fillBD(s);
        long newnow = System.currentTimeMillis();
        System.out.println(now + ") All done!");
        System.out.println("Total time in milis... "+ (newnow-now));
    }

}
