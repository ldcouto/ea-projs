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

    int counter;
    int index;

    public Worker(int i){
        this.index=i;
        this.counter=100;
    }

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

        String filname ="mats/worker_output_"+index+".txt";
        MyFileHandler.createFile(filname);

        int i = 0;
        while (i < counter){
            int action = r.nextInt(10);
            
            String randomNick = queries.selectRandomUser();
            String randomSlug = queries.selectRandomUser();

            start = System.currentTimeMillis();

            switch (action) {
                case 0 : queries.topTenNews();
                         query_type = "TOP10NEWS";
                         break;
                case 1 : queries.topTenFollowers();
                         query_type = "TOP10FOLL";
                         break;
                case 2 : queries.allFollowersOf(randomNick);
                         query_type = "FOLlFROM";
                         break;
                case 3 : queries.allPostsLikedBy(randomNick);
                         query_type = "VOTESFROM";
                         break;
                case 4 : queries.allPostsMadeBy(randomNick);
                         query_type = "NEWSFROM";
                         break;
                case 5 : queries.insertVoto(randomSlug, randomNick);
                         query_type = "NEWVOTE";
                         break;
                case 6 : queries.loginUser(randomNick);
                         query_type = "LOGIN";
                         break;
                case 7 : queries.insertNews(randomNick);
                         query_type = "NEWPOST";
                         break;
                case 8 : queries.recNews(randomNick);
                         query_type = "RECNEWS";
                         break;
                case 9 : queries.recUsers(randomNick);
                         query_type = "RECUSERS";
                         break;
            }

            end = System.currentTimeMillis();
            latency = end - start;

            totaltime += latency;

            lines.add(query_type + '\t' + start + '\t' + end + '\t' + latency);

            System.out.println("Done executing "+ (i+1) +" queries");
            i++;
        }

        mean_time_per_query = (double) totaltime / counter;
        mean_query_per_minute = (double) counter / ((double) totaltime / 60000);

        lines.add("Mean time per query: "+ mean_time_per_query);
        lines.add("Mean queries per minute: "+ mean_query_per_minute);

        MyFileHandler.writeManyLines(filname, lines);
        MyConnectionHandler.disconnect(con);
    }
}
