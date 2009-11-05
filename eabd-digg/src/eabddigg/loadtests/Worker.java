/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import filehandler.MyFileHandler;
import java.sql.Connection;
import java.util.ArrayList;
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
        ArrayList<String> lines = new ArrayList<String>(counter);

        String filname = this.getClass().getName().toString();


        MyFileHandler.createFile(filname);
        while (counter >= 0){
            int action = r.nextInt(12);
            
            String randomNick = Queries.selectRandomUser();
            String randomSlug = Queries.selectRandomUser();

            long start = System.currentTimeMillis();

            switch (action) {
                case 0 : Queries.topTenNews();
                         break;
                case 1 : Queries.topTenFollowers();
                         break;
                case 2 : Queries.allFollowersFrom(randomNick);
                         break;
                case 3 : Queries.allPostsLikedBy(randomNick);
                         break;
                case 4 : Queries.allPostsMadeBy(randomNick);
                         break;
                case 5 : Queries.insertVoto(randomSlug, randomNick);
                         break;
                case 6 : Queries.loginUser(randomNick);
                         break;
                case 7 : Queries.insertNews();

            }

            long end = System.currentTimeMillis();
        }
    }


}
