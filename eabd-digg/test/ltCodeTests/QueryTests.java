/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ltCodeTests;

import connectionhandler.MyConnectionHandler;
import eabddigg.loadtests.Queries;

/**
 *
 * @author lc
 */
/*
public class QueryTests
{
    public static void main(String[] args)
    {
        long ti, tf;
        System.out.println("Testing TopTenNews...");
        ti = System.currentTimeMillis();
        testTopTenNews();
        tf = System.currentTimeMillis();
        System.out.println("TopTenNews completed in " + (tf - ti) + " ms.");
        System.out.println("Testing TopTenFollowers...");
        ti = System.currentTimeMillis();
        testTopTenFollowers();
        tf = System.currentTimeMillis();
        System.out.println("TopTenFollowers completed in " + (tf-ti) + " ms.");
        System.out.println("Testing RecNews...");
        ti = System.currentTimeMillis();
        testRecNews();
        tf = System.currentTimeMillis();
        System.out.println("Recnews completed in " + (tf-ti) + " ms.");
        System.out.println("Testing RecUsers...");
        ti = System.currentTimeMillis();
        testRecUsers();
        tf = System.currentTimeMillis();
        System.out.println("RecUsers completed in " + (tf-ti) + " ms.");
        System.out.println("Testing InsertVote...");
        ti = System.currentTimeMillis();
        testInsVote();
        tf = System.currentTimeMillis();
        System.out.println("InsertVote completed in " + (tf-ti) + " ms.");
        System.out.println("Testing InsertNews...");
        ti = System.currentTimeMillis();
        testInsNews();
        tf = System.currentTimeMillis();
        System.out.println("InsertNews completed in " + (tf - ti) + " ms.");
    }

    // Aux Functions
    static public String removeSpecialCharacters(String orig)
    {
        String rv;

        // replacing with space allows the camelcase to work a little better in most cases.
        rv = orig.replace("\\", " ");
        rv = rv.replace("(", " ");
        rv = rv.replace(")", " ");
        rv = rv.replace("/", " ");
        rv = rv.replace("-", " ");
        rv = rv.replace(",", " ");
        rv = rv.replace(">", " ");
        rv = rv.replace("<", " ");
        rv = rv.replace("-", " ");
        rv = rv.replace("&", " ");

        // single quotes shouldn't result in CamelCase variables like Patient's -> PatientS
        // "smart" forward quote
        rv = rv.replace("'", "");

        // if you have to find any more weird unicode chars, look here:
        // http://seth.positivism.org/man.cgi/7/groff_char
        rv = rv.replace("\u2019", ""); // smart forward (possessive) quote.

        // make sure to get rid of double spaces.
        rv = rv.replace("   ", " ");
        rv = rv.replace("  ", " ");

        rv = rv.trim();// Remove leading and trailing spaces.

        return (rv);
    }

    // Invoker Methods
    private static void testRecNews()
    {
        Queries myQ = new Queries("jdbclocalhost", "5432", "");
        String dude = removeSpecialCharacters(myQ.selectRandomUser());
        myQ.recNews(dude);
    }

    private static void testRecUsers()
    {
        Queries myQ = new Queries();
        String dude = removeSpecialCharacters(myQ.selectRandomUser());
        myQ.recUsers(dude);
    }

    private static void testInsVote()
    {
        Queries myQ = new Queries();
        myQ.insertVoto(myQ.selectRandomNews(), myQ.selectRandomUser());
    }

    private static void testInsNews()
    {
        Queries myQ = new Queries();
        myQ.insertNews("banglast");
    }

    private static void testTopTenFollowers()
    {
        Queries myQ = new Queries();
        myQ.topTenFollowers();
    }

    private static void testTopTenNews()
    {
        Queries myQ = new Queries();
        myQ.topTenNews();
    }
}
*/