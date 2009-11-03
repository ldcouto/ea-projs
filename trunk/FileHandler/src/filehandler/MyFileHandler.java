/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author fork
 */
public abstract class MyFileHandler {

    /**
     *
     * @param filename name of the file, or path to file, to create
     * @return true if file was created, false if file already exists
     */
    public boolean createFile(String filename) {

        boolean res = false;

        try {
            File file = new File(filename);
            res = file.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    /**
     * 
     * @param filename name of the file to edit
     * @param line line to add to the file
     */
    public void writeLine(String filename, String line) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
            out.write(line);
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
