// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/xml/sources/Tokenizer.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Sat Oct 20 00:12:54 2012

/**
 * This is a skeleton tokenizer for building a java parser for the
 * grammar in <a href="XmlGenEx.html"><tt>XmlGenEx.grm</tt></a>. It is
 * minimal in that it relies on just enough information to make a toy
 * parser. The code is rather self-explanatory.
 *
 * <p>
 *
 * @version     Last modified on Sat Oct 20 00:19:45 2012 by hak
 * @author      <a href="mahlto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

package hlt.xml;

import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import hlt.language.io.StreamTokenizer;
import hlt.language.syntax.*;

public class Tokenizer implements FileTokenizer
{
  int lineno;
  String file;
  Reader reader;
  StreamTokenizer st;
  boolean prompt;

  public Tokenizer ()
    {
    }

  public Tokenizer (String file) throws IOException
    {
      setFile(file);
    }

  public void setFile (String file) throws IOException
    {
      setFileName(file);
      setReader(new BufferedReader(new FileReader(file)));
    }

  public final int lineNumber()
    {
      return lineno;
    }

  public final void setReader (Reader rd)
    {
      reader = rd;
      st = new StreamTokenizer(reader);
      st.ordinaryChars("+-.(){}[]<>;,:=!&|*/%");
      st.setType('.',st.NUMERIC);
      st.quoteChar('\'');
      st.quoteChar('"');
      st.wordChars("_@?$");
    }

  public final Reader getReader ()
    {
      return reader;
    }

  public final String fileName ()
    {
      return file;
    }

  public final void setFileName (String file)
    {
      this.file = file;
    }

  final ParseNode locate (ParseNode node)
    {
      return ((ParseNode)node.setStart(st.tokenStart()).setEnd(st.tokenEnd())).setFile(file);
    }

  final ParseNode integer ()
    {
      return locate(Parser.numberToken("NUMBER",(int)st.nval));
    }

  final ParseNode floatingPoint ()
    {
      return locate(Parser.numberToken("NUMBER",st.nval));
    }

  final ParseNode string ()
    {
      return locate(Parser.symbolToken("STRING","\""+st.sval+"\""));
    }

  final ParseNode identifier (String symbol)
    {
      return locate(Parser.symbolToken("IDENT",symbol));
    }

  final ParseNode variable (String symbol)
    {
      return locate(Parser.symbolToken("VAR",symbol.substring(1)));
    }

  final ParseNode literal (String s)
    {
      return locate(Parser.literalToken(s));
    }

  final ParseNode literal (int c)
    {
      return locate(Parser.literalToken(String.valueOf((char)c)));
    }

  public final ParseNode nextToken () throws IOException
    {
      ParseNode t = null;
      int tk = st.nextToken();
      int nextChar = st.peek();
      lineno = st.lineno();

      switch (tk)
        {
        case StreamTokenizer.TT_SPECIAL:
          return nextToken();
        case StreamTokenizer.TT_EOF:
          t = locate(Parser.eoi());
          break;
        case StreamTokenizer.TT_NUMBER:
          if (st.isInteger)
            t = integer();
          else
            t = floatingPoint();
          break;
        case '"':
        case '\'':
          t = string();
          break;
	case '+':
	  t = literal("PLUS");
	  break;
	case '*':
	  t = literal("TIMES");
	  break;
	case '<':
	  t = literal("SMALLER");
	  break;
	case '=':
	  t = literal("EQUAL");
	  break;
	case '>':
	  t = literal("GREATER");
	  break;
	case '&':
	  t = literal("AND");
	  break;
	case '|':
	  t = literal("OR");
	  break;
        case StreamTokenizer.TT_WORD:
	  if (Lexicon.isVariable(st.sval))
            {
	      t = variable(st.sval);
              break;
            }
          if (Lexicon.isReserved(st.sval))
            {
	      t = literal(st.sval);
              break;
            }
	  t = identifier(st.sval);
          break;
        default:
	  t = literal(tk);
        }
      //    System.out.println("Reading token: "+t);
      return t;
    }
}

