/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import connectionhandler.MyConnectionHandler;
import filehandler.MyFileHandler;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fork
 */

public class Worker extends Thread {

    int counter = 1000;

    @Override
    public void run() {

        Connection con = MyConnectionHandler.connect();
        Queries queries = new Queries(con);

        Random r = new Random();
        ArrayList<String> lines = new ArrayList<String>(counter);

        long start, end, latency;
        long totaltime = 0;
        double mean_time_per_query = 0.0;
        double mean_query_per_minute = 0.0;

        String query_type = new String();

        String filname = this.getClass().getName().toString();
        MyFileHandler.createFile(filname);

        while (counter >= 0){
            int action = r.nextInt(12);
            
            String randomNick = queries.selectRandomUser();
            String randomSlug = queries.selectRandomUser();

            start = System.currentTimeMillis();

            switch (action) {
                case 0 : queries.topTenNews();
                         query_type = "SELECT";
                         break;
                case 1 : queries.topTenFollowers();
                         query_type = "SELECT";
                         break;
                case 2 : queries.allFollowersOf(randomNick);
                         query_type = "SELECT";
                         break;
                case 3 : queries.allPostsLikedBy(randomNick);
                         query_type = "SELECT";
                         break;
                case 4 : queries.allPostsMadeBy(randomNick);
                         query_type = "SELECT";
                         break;
                case 5 : queries.insertVoto(randomSlug, randomNick);
                         query_type = "INSERT";
                         break;
                case 6 : queries.loginUser(randomNick);
                         query_type = "SELECT";
                         break;
                case 7 : queries.insertNews(randomNick);
                         query_type = "INSERT";
                         break;
                case 8 : queries.recNews(randomNick);
                         query_type = "SELECT";
                         break;
                case 9 : queries.recUsers(randomNick);
                         query_type = "SELECT";
                         break;
            }

            end = System.currentTimeMillis();
            latency = end - start;

            totaltime += latency;

            lines.add(query_type + '\t' + start + '\t' + end + '\t' + latency);
        }

        mean_time_per_query = (double) totaltime / counter;
        mean_query_per_minute = (double) counter / ((double) totaltime / 60000);

        lines.add("Mean time per query: "+ mean_time_per_query);
        lines.add("Mean queries per minute: "+ mean_query_per_minute);

        MyFileHandler.writeManyLines(filname, lines);
        MyConnectionHandler.disconnect(con);
    }
}
