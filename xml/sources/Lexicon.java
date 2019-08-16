// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/xml/sources/Lexicon.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Fri Oct 19 22:55:13 2012

/**
 * This is a simple lexicon class defining lexical units for the
 * tokenizer in <a href="Tokenizer.html"><tt>Tokenizer.java</tt></a>,
 * for this Jacc application, which is meant to illustrate XML
 * generation for language of simple expressions.
 *
 * <p>
 *
 * @version     Last modified on Fri Oct 19 23:00:24 2012 by hak
 * @author      <a href="mahlto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

package hlt.xml;

import java.util.HashMap;
import java.util.HashSet;

class Lexicon
{
  /**
   * Returns <tt>true</tt> iff the specified string starts with a
   * question mark, and every other character is alphanumeric or
   * underscore.
   */
  public final static boolean isVariable (String s)
    {
      char c = s.charAt(0);

      if (c != '?')
        return false;

      for (int i=1; i<s.length(); i++)
          {
            c = s.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_')
              return false;
          }

      return true;
    }       

  /**
   * The following is a store for RCL reserved words.
   */
  public static final HashSet reserved = new HashSet();

  /**
   * Returns <tt>true</tt> iff the specified string is a reserved
   * RCL word.
   */
  public final static boolean isReserved (String word)
    {
      return reserved.contains(word);
    }

  /**
   * Declares the specified string as a reserved word.
   */
  static final void reserved (String word)
    {
      reserved.add(word);
    }

}
