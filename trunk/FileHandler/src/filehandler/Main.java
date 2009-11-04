/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filehandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lc
 */
public class Main {

     public static void main(String[] args) {

         // Let's Create the new File
      //   String nome = "testes.txt";
       //  MyFileHandler.createFile(nome);
         ArrayList<String> aux = (ArrayList<String>) makeInfo();
         MyFileHandler.writeManyLines("mats/test1.txt", aux);
         System.out.println("All done!");

    }
     
     public static List<String> makeInfo() {
         List<String> r = new ArrayList<String>();
         StringBuilder sb = new StringBuilder();
         sb.append(3);
         sb.append('\t');
         sb.append(4);
         sb.append('\t');
         sb.append(5);
         r.add(sb.toString());
         sb = new StringBuilder();
         sb.append(3);
         sb.append('\t');
         sb.append(4);
         sb.append('\t');
         sb.append(5);
         r.add(sb.toString());
         return r;
    }


}
