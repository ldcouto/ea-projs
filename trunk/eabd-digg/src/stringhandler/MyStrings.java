/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringhandler;

/**
 *
 * @author fork
 */
public class MyStrings
{

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
}
