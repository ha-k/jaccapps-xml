// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/xml/sources/Main.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Fri Oct 19 23:01:24 2012

/**
 * This is a driver class implementing a java parser from the Jacc
 * grammar specified in <a href="XmlGenEx.html"><tt>XmlGenEx.grm</tt></a>.
 * It uses the tokenizer <a href="Tokenizer.html"><tt>Tokenizer.java</tt></a>.
 *
 * <p>
 *
 * @version     Last modified on Sat Oct 20 01:46:14 2012 by hak
 * @author      <a href="mahlto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

package hlt.xml;

import java.io.IOException;
import hlt.language.util.Error;

public class Main
{
  static Parser parser;
  static boolean trace = false;

  static void setTrace (boolean flag)
    {
      trace = flag;
    }

  final public static void main (String args[])
    {
      try
        {
	  if (args.length == 0)
	    {
	      System.err.println("*** No file specified - exiting...");
	      System.exit(1);
	    }

          parser = new Parser(new Tokenizer(args[0]));
        }
      catch (IOException e)
        {
          System.err.println("*** No such file: " + args[0]);
          System.exit(1);
        }

      try
        {
	  System.err.println("*** Parsing file: " + args[0]);
	  parser.setTreeType("XML");
          parser.setQuiet(false);
          parser.setStart();	 
          parser.parse();
        }
      catch (IOException e)
        {
          parser.errorManager().reportError(new Error().setLabel("IO Error: ")
                                            .setMsg(e.getMessage()+" - giving up!")
                                            .setSee("..."));
          parser.errorManager().tallyErrors();
        }
      catch (Throwable e)
        {
	  System.err.println("*** Sorry - something nasty happened! ...");
          parser.errorManager().tallyErrors();
          e.printStackTrace();
        }
    }
}

