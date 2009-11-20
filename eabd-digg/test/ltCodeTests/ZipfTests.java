/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ltCodeTests;

import zipFGenerator.ZipfGenAdpted;

/**
 *
 * @author lc
 */
public class ZipfTests {


    public static void main(String[] args){
        ZipfGenAdpted z = new ZipfGenAdpted();
        for (int i=0; i<99; i++){
            System.out.println("Linha "+i+": "+ z.zipf(10));
        }

    }

}
