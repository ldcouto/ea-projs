/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eabddigg.loadtests;

import filehandler.MyFileHandler;
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
            
            String randomNick = Queries.selectRandomUser();
            String randomSlug = Queries.selectRandomUser();

            start = System.currentTimeMillis();

            switch (action) {
                case 0 : Queries.topTenNews();
                         query_type = "SELECT";
                         break;
                case 1 : Queries.topTenFollowers();
                         query_type = "SELECT";
                         break;
                case 2 : Queries.allFollowersFrom(randomNick);
                         query_type = "SELECT";
                         break;
                case 3 : Queries.allPostsLikedBy(randomNick);
                         query_type = "SELECT";
                         break;
                case 4 : Queries.allPostsMadeBy(randomNick);
                         query_type = "SELECT";
                         break;
                case 5 : Queries.insertVoto(randomSlug, randomNick);
                         query_type = "INSERT";
                         break;
                case 6 : Queries.loginUser(randomNick);
                         query_type = "SELECT";
                         break;
                case 7 : Queries.insertNews(randomNick);
                         query_type = "INSERT";
                         break;
                case 8 : Queries.recNews(randomNick);
                         query_type = "SELECT";
                         break;
                case 9 : Queries.recUsers(randomNick);
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
    }
}
