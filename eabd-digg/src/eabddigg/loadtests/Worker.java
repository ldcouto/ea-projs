/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import java.sql.Connection;
import java.util.Random;

/**
 *
 * @author fork
 */
public class Worker extends Thread {

    private Connection con; // TODO: remover isto, apenas aqui para não aponder este tipo de erro;
    int counter = 100;

    @Override
    public void run() {
        Random r = new Random();
        while (counter >= 0){
            int action = r.nextInt(12);

        }
    }


}
