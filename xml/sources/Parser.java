// *******************************************************************
// This file has been automatically generated from the grammar in file
// XmlGenEx.grm by hlt.language.syntax.ParserGenerator on
// Fri Mar 30 06:03:03 CEST 2018 --- !!! PLEASE DO NO EDIT !!!
// *******************************************************************

package hlt.xml;

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import hlt.language.syntax.*;
import java.io.PrintStream;
import hlt.language.tools.Misc;


/* ************ */
/* PARSER CLASS */
/* ************ */

class Parser extends StaticParser
{
  /* ************************ */
  /* PARSER CLASS CONSTRUCTOR */
  /* ************************ */

  public Parser (Tokenizer t)
    {
      input = t;
      xmlroot = "expressions";
      xmlRootNSPrefix = "hex";
      String[] ns = {"hex","http://www.hassan-ait-kaci.net/hex"};
      namespaces = ns;
    }

  /* ************************* */
  /* PARSER CLASS DECLARATIONS */
  /* ************************* */

  long start;
  boolean quiet = true;
  PrintStream out = System.out;

  void setStart ()
    {
      start = System.currentTimeMillis();
    }

  void setQuiet (boolean flag)
    {
      quiet = flag;
    }

  void setOutputStream (PrintStream stream)
    {
      out = stream;
    }

  /*
   * A function to show what happened.
   */
  void showXml ()
    {
      out.println("*** Total parsing time = "
                 +(System.currentTimeMillis()-start)
                 +" ms");

      if (!quiet)
        {
          errorManager().tallyErrors();
          if (Misc.askYesNo("*** Do you want to see the XML serialization"))
            {
              out.println();
	      try
		{
		  writeXml(currentNode(),System.out);
		}
	      catch (Exception e)
		{
		  e.printStackTrace();
		}	      
//               currentNode().display();
              out.println();
            }
        }
    }


  /* ********************** */
  /* STATIC INITIALIZATIONS */
  /* ********************** */

  static
    {
      initializeTerminals();
      initializeNonTerminals();
      initializeRules();
      initializeParserActions();
      initializeParserStates();
      initializeActionTables();
      initializeGotoTables();
      initializeStateTables();
    }

  /* ********************* */
  /* PARTIAL PARSE METHODS */
  /* ********************* */

  final static ParseNode $EXP_SWITCH$ = new ParseNode(terminals[3]);

  public final void parseEXP (String s) throws IOException
    {
      parseEXP(new StringReader(s));
    }

  public final void parseEXP (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($EXP_SWITCH$);
      parse();
    }

  /* **************** */
  /* SEMANTIC ACTIONS */
  /* **************** */

  protected ParseNode semanticAction(ParserRule $rule$) throws IOException
    {
      ParseNode $head$ = new ParseNode($rule$.head);

      switch($rule$.index())
        {
          case 2:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 3:
            {
            // show the XML tree
      showXml();
      // show the CST:
  //     System.out.println("Concrete syntax tree:\n");
  //     currentNode().show(2,System.out);
            break;
            }
          case 0: case 1: case 4: 
            break;
          default:
            $head$ = $head$.copy(node($rule$,1));
            break;
        }
      return $head$;
    }

  /* **************** */
  /* TERMINAL SYMBOLS */
  /* **************** */

  static void initializeTerminals ()
    {
      terminals = new ParserTerminal[16];

      newTerminal(0,"$EMPTY$",1,2);
      newTerminal(1,"$E_O_I$",1,2);
      newTerminal(2,"error",1,2);
      newTerminal(3,"$EXP_switch$",1,2);
      newTerminal(4,"NUMBER",1,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "number" attributes = { value = $VALUE } ]
        terminals[4].setXmlInfo(new XmlInfo("number","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = new XmlAttributeInfo("value");
        terminals[4].addXmlInfo(xmlAttributes);
      }
      newTerminal(5,"IDENT",1,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "identifier" attributes = { name = $VALUE } ]
        terminals[5].setXmlInfo(new XmlInfo("identifier","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = new XmlAttributeInfo("name");
        terminals[5].addXmlInfo(xmlAttributes);
      }
      newTerminal(6,"STRING",1,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "string" attributes = { value = $VALUE } ]
        terminals[6].setXmlInfo(new XmlInfo("string","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = new XmlAttributeInfo("value");
        terminals[6].addXmlInfo(xmlAttributes);
      }
      newTerminal(7,"VAR",1,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "variable" attributes = { name = $VALUE } ]
        terminals[7].setXmlInfo(new XmlInfo("variable","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = new XmlAttributeInfo("name");
        terminals[7].addXmlInfo(xmlAttributes);
      }
      newTerminal(8,"OR",11,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BooleanOperator" attributes = { symbol = "|" } ]
        terminals[8].setXmlInfo(new XmlInfo("BooleanOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","|");
        terminals[8].addXmlInfo(xmlAttributes);
      }
      newTerminal(9,"AND",21,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BooleanOperator" attributes = { symbol = "&" } ]
        terminals[9].setXmlInfo(new XmlInfo("BooleanOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","&");
        terminals[9].addXmlInfo(xmlAttributes);
      }
      newTerminal(10,"SMALLER",31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "RelationalOperator" attributes = { symbol = "<" } ]
        terminals[10].setXmlInfo(new XmlInfo("RelationalOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","<");
        terminals[10].addXmlInfo(xmlAttributes);
      }
      newTerminal(11,"EQUAL",31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "RelationalOperator" attributes = { symbol = "=" } ]
        terminals[11].setXmlInfo(new XmlInfo("RelationalOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","=");
        terminals[11].addXmlInfo(xmlAttributes);
      }
      newTerminal(12,"GREATER",31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "RelationalOperator" attributes = { symbol = ">" } ]
        terminals[12].setXmlInfo(new XmlInfo("RelationalOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol",">");
        terminals[12].addXmlInfo(xmlAttributes);
      }
      newTerminal(13,"PLUS",41,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "ArithmeticOperator" attributes = { symbol = "+" } ]
        terminals[13].setXmlInfo(new XmlInfo("ArithmeticOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","+");
        terminals[13].addXmlInfo(xmlAttributes);
      }
      newTerminal(14,"TIMES",51,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "ArithmeticOperator" attributes = { symbol = "*" } ]
        terminals[14].setXmlInfo(new XmlInfo("ArithmeticOperator","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.literalXmlAttributeInfo("symbol","*");
        terminals[14].addXmlInfo(xmlAttributes);
      }
      newTerminal(15,";",1,2);
    }

  /* ******************** */
  /* NON-TERMINAL SYMBOLS */
  /* ******************** */

  static void initializeNonTerminals ()
    {
      nonterminals = new ParserNonTerminal[8];

      newNonTerminal(0,"$START$");
      newNonTerminal(1,"$ROOTS$");
      newNonTerminal(2,"EXP");
      newNonTerminal(3,"Exprs");
      newNonTerminal(4,"Expr");
      newNonTerminal(5,"Atom");
      newNonTerminal(6,"BinExpr");
      newNonTerminal(7,"PartialRelationalExpr");
    }

  /* **************** */
  /* PRODUCTION RULES */
  /* **************** */

  static void initializeRules ()
    {
      rules = new ParserRule[20];

      rules[0] = new ParserRule(0,1,0,1,2);
      rules[1] = new ParserRule(1,1,1,1,2);
      rules[2] = new ParserRule(1,2,2,1,2);
      rules[3] = new ParserRule(2,1,3,1,2);
      rules[4] = new ParserRule(3,0,4,1,2);
      rules[5] = new ParserRule(3,3,5,1,2);
      rules[6] = new ParserRule(4,1,6,1,2);
      rules[7] = new ParserRule(4,1,7,1,2);
      rules[8] = new ParserRule(5,1,8,1,2);
      rules[9] = new ParserRule(5,1,9,1,2);
      rules[10] = new ParserRule(5,1,10,1,2);
      rules[11] = new ParserRule(5,1,11,1,2);
      rules[12] = new ParserRule(6,3,12,41,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BinaryArithmeticExpression" attributes = { op = 2/symbol } children = ( 1 3 ) ]
        rules[12].setXmlInfo(new XmlInfo("BinaryArithmeticExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(2);
        rules[12].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {1,3};
        rules[12].addXmlInfo(xmlChildren);
      }
      rules[13] = new ParserRule(6,3,13,51,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BinaryArithmeticExpression" attributes = { op = 2/symbol } children = ( 1 3 ) ]
        rules[13].setXmlInfo(new XmlInfo("BinaryArithmeticExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(2);
        rules[13].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {1,3};
        rules[13].addXmlInfo(xmlChildren);
      }
      rules[14] = new ParserRule(6,3,14,21,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BinaryBooleanExpression" attributes = { op = 2/symbol } children = ( 1 3 ) ]
        rules[14].setXmlInfo(new XmlInfo("BinaryBooleanExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(2);
        rules[14].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {1,3};
        rules[14].addXmlInfo(xmlChildren);
      }
      rules[15] = new ParserRule(6,3,15,11,0);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BinaryBooleanExpression" attributes = { op = 2/symbol } children = ( 1 3 ) ]
        rules[15].setXmlInfo(new XmlInfo("BinaryBooleanExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(2);
        rules[15].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {1,3};
        rules[15].addXmlInfo(xmlChildren);
      }
      rules[16] = new ParserRule(6,2,16,1,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "BinaryRelationalExpression" attributes = { op = 2/op } children = ( 1 2[1] ) ]
        rules[16].setXmlInfo(new XmlInfo("BinaryRelationalExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","op");
        xmlAttributes[0].setChild(2);
        rules[16].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {1,2};
        rules[16].addXmlInfo(xmlChildren);
          {
             int[][] paths = new int[2][];
             int[] path;
             path = new int[1];
             path[0] = 1;
             paths[1] = path;
             rules[16].addXmlInfo(paths);
          }
      }
      rules[17] = new ParserRule(7,2,17,31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "PartialRelationalExpression" attributes = { op = 1/symbol } children = ( 2 ) ]
        rules[17].setXmlInfo(new XmlInfo("PartialRelationalExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(1);
        rules[17].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {2};
        rules[17].addXmlInfo(xmlChildren);
      }
      rules[18] = new ParserRule(7,2,18,31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "PartialRelationalExpression" attributes = { op = 1/symbol } children = ( 2 ) ]
        rules[18].setXmlInfo(new XmlInfo("PartialRelationalExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(1);
        rules[18].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {2};
        rules[18].addXmlInfo(xmlChildren);
      }
      rules[19] = new ParserRule(7,2,19,31,2);
      { // Code for XML serialization annotation:
        // [ nsprefix = "hex" localname = "PartialRelationalExpression" attributes = { op = 1/symbol } children = ( 2 ) ]
        rules[19].setXmlInfo(new XmlInfo("PartialRelationalExpression","hex"));
        XmlAttributeInfo[] xmlAttributes = new XmlAttributeInfo[1];
        xmlAttributes[0] = XmlAttributeInfo.refXmlAttributeInfo("op","symbol");
        xmlAttributes[0].setChild(1);
        rules[19].addXmlInfo(xmlAttributes);
        int[] xmlChildren = {2};
        rules[19].addXmlInfo(xmlChildren);
      }
    }

  /* ************** */
  /* PARSER ACTIONS */
  /* ************** */

  static void initializeParserActions ()
    {
      actions = new ParserAction[197];

      newAction(0,5,0);
      newAction(1,2,0);
      newAction(2,0,3);
      newAction(3,1,4);
      newAction(4,1,4);
      newAction(5,1,4);
      newAction(6,1,4);
      newAction(7,1,4);
      newAction(8,1,1);
      newAction(9,1,4);
      newAction(10,1,4);
      newAction(11,1,4);
      newAction(12,1,4);
      newAction(13,1,4);
      newAction(14,1,3);
      newAction(15,0,8);
      newAction(16,0,9);
      newAction(17,0,10);
      newAction(18,0,11);
      newAction(19,0,12);
      newAction(20,0,13);
      newAction(21,0,14);
      newAction(22,0,15);
      newAction(23,0,16);
      newAction(24,0,18);
      newAction(25,0,19);
      newAction(26,0,20);
      newAction(27,1,6);
      newAction(28,1,6);
      newAction(29,1,6);
      newAction(30,1,6);
      newAction(31,1,6);
      newAction(32,1,6);
      newAction(33,1,6);
      newAction(34,1,6);
      newAction(35,1,7);
      newAction(36,1,7);
      newAction(37,1,7);
      newAction(38,1,7);
      newAction(39,1,7);
      newAction(40,1,7);
      newAction(41,1,7);
      newAction(42,1,7);
      newAction(43,1,8);
      newAction(44,1,8);
      newAction(45,1,8);
      newAction(46,1,8);
      newAction(47,1,8);
      newAction(48,1,8);
      newAction(49,1,8);
      newAction(50,1,8);
      newAction(51,1,9);
      newAction(52,1,9);
      newAction(53,1,9);
      newAction(54,1,9);
      newAction(55,1,9);
      newAction(56,1,9);
      newAction(57,1,9);
      newAction(58,1,9);
      newAction(59,1,10);
      newAction(60,1,10);
      newAction(61,1,10);
      newAction(62,1,10);
      newAction(63,1,10);
      newAction(64,1,10);
      newAction(65,1,10);
      newAction(66,1,10);
      newAction(67,1,11);
      newAction(68,1,11);
      newAction(69,1,11);
      newAction(70,1,11);
      newAction(71,1,11);
      newAction(72,1,11);
      newAction(73,1,11);
      newAction(74,1,11);
      newAction(75,1,5);
      newAction(76,1,5);
      newAction(77,1,5);
      newAction(78,1,5);
      newAction(79,1,5);
      newAction(80,0,8);
      newAction(81,0,9);
      newAction(82,0,10);
      newAction(83,0,11);
      newAction(84,0,8);
      newAction(85,0,9);
      newAction(86,0,10);
      newAction(87,0,11);
      newAction(88,0,8);
      newAction(89,0,9);
      newAction(90,0,10);
      newAction(91,0,11);
      newAction(92,0,8);
      newAction(93,0,9);
      newAction(94,0,10);
      newAction(95,0,11);
      newAction(96,1,16);
      newAction(97,1,16);
      newAction(98,1,16);
      newAction(99,1,16);
      newAction(100,1,16);
      newAction(101,1,16);
      newAction(102,1,16);
      newAction(103,1,16);
      newAction(104,0,8);
      newAction(105,0,9);
      newAction(106,0,10);
      newAction(107,0,11);
      newAction(108,0,8);
      newAction(109,0,9);
      newAction(110,0,10);
      newAction(111,0,11);
      newAction(112,0,8);
      newAction(113,0,9);
      newAction(114,0,10);
      newAction(115,0,11);
      newAction(116,0,13);
      newAction(117,0,14);
      newAction(118,0,15);
      newAction(119,0,16);
      newAction(120,1,19);
      newAction(121,1,19);
      newAction(122,1,19);
      newAction(123,1,19);
      newAction(124,1,19);
      newAction(125,1,19);
      newAction(126,0,18);
      newAction(127,0,19);
      newAction(128,0,13);
      newAction(129,0,14);
      newAction(130,0,15);
      newAction(131,0,16);
      newAction(132,1,18);
      newAction(133,1,18);
      newAction(134,1,18);
      newAction(135,1,18);
      newAction(136,1,18);
      newAction(137,1,18);
      newAction(138,0,18);
      newAction(139,0,20);
      newAction(140,0,13);
      newAction(141,0,14);
      newAction(142,0,15);
      newAction(143,0,16);
      newAction(144,1,17);
      newAction(145,1,17);
      newAction(146,1,17);
      newAction(147,1,17);
      newAction(148,1,17);
      newAction(149,1,17);
      newAction(150,0,19);
      newAction(151,0,20);
      newAction(152,0,13);
      newAction(153,0,14);
      newAction(154,0,15);
      newAction(155,0,16);
      newAction(156,1,15);
      newAction(157,1,15);
      newAction(158,1,15);
      newAction(159,1,15);
      newAction(160,1,15);
      newAction(161,0,18);
      newAction(162,0,19);
      newAction(163,0,20);
      newAction(164,0,13);
      newAction(165,0,14);
      newAction(166,0,15);
      newAction(167,1,14);
      newAction(168,1,14);
      newAction(169,1,14);
      newAction(170,1,14);
      newAction(171,1,14);
      newAction(172,1,14);
      newAction(173,0,18);
      newAction(174,0,19);
      newAction(175,0,20);
      newAction(176,0,13);
      newAction(177,0,14);
      newAction(178,1,13);
      newAction(179,1,13);
      newAction(180,1,13);
      newAction(181,1,13);
      newAction(182,1,13);
      newAction(183,1,13);
      newAction(184,1,13);
      newAction(185,1,13);
      newAction(186,0,13);
      newAction(187,1,12);
      newAction(188,1,12);
      newAction(189,1,12);
      newAction(190,1,12);
      newAction(191,1,12);
      newAction(192,1,12);
      newAction(193,1,12);
      newAction(194,1,12);
      newAction(195,0,14);
      newAction(196,1,2);
    }

  /* ************* */
  /* PARSER STATES */
  /* ************* */

  static void initializeParserStates ()
    {
      states = new ParserState[29];

      for (int i=0; i<29; i++) newState(i);
    }

  /* ************* */
  /* ACTION TABLES */
  /* ************* */

  static void initializeActionTables ()
    {
      newActionTables(23);

      newActionTable(0,6);
	setAction(0,1,3);
	setAction(0,3,2);
	setAction(0,4,4);
	setAction(0,5,5);
	setAction(0,6,6);
	setAction(0,7,7);

      newActionTable(1,1);
	setAction(1,1,1);

      newActionTable(2,1);
	setAction(2,1,8);

      newActionTable(3,5);
	setAction(3,1,9);
	setAction(3,4,10);
	setAction(3,5,11);
	setAction(3,6,12);
	setAction(3,7,13);

      newActionTable(4,5);
	setAction(4,1,14);
	setAction(4,4,15);
	setAction(4,5,16);
	setAction(4,6,17);
	setAction(4,7,18);

      newActionTable(5,8);
	setAction(5,8,23);
	setAction(5,9,22);
	setAction(5,10,24);
	setAction(5,11,25);
	setAction(5,12,26);
	setAction(5,13,20);
	setAction(5,14,21);
	setAction(5,15,19);

      newActionTable(6,8);
	setAction(6,8,27);
	setAction(6,9,28);
	setAction(6,10,29);
	setAction(6,11,30);
	setAction(6,12,31);
	setAction(6,13,32);
	setAction(6,14,33);
	setAction(6,15,34);

      newActionTable(7,8);
	setAction(7,8,35);
	setAction(7,9,36);
	setAction(7,10,37);
	setAction(7,11,38);
	setAction(7,12,39);
	setAction(7,13,40);
	setAction(7,14,41);
	setAction(7,15,42);

      newActionTable(8,8);
	setAction(8,8,43);
	setAction(8,9,44);
	setAction(8,10,45);
	setAction(8,11,46);
	setAction(8,12,47);
	setAction(8,13,48);
	setAction(8,14,49);
	setAction(8,15,50);

      newActionTable(9,8);
	setAction(9,8,51);
	setAction(9,9,52);
	setAction(9,10,53);
	setAction(9,11,54);
	setAction(9,12,55);
	setAction(9,13,56);
	setAction(9,14,57);
	setAction(9,15,58);

      newActionTable(10,8);
	setAction(10,8,59);
	setAction(10,9,60);
	setAction(10,10,61);
	setAction(10,11,62);
	setAction(10,12,63);
	setAction(10,13,64);
	setAction(10,14,65);
	setAction(10,15,66);

      newActionTable(11,8);
	setAction(11,8,67);
	setAction(11,9,68);
	setAction(11,10,69);
	setAction(11,11,70);
	setAction(11,12,71);
	setAction(11,13,72);
	setAction(11,14,73);
	setAction(11,15,74);

      newActionTable(12,5);
	setAction(12,1,75);
	setAction(12,4,76);
	setAction(12,5,77);
	setAction(12,6,78);
	setAction(12,7,79);

      newActionTable(13,4);
	setAction(13,4,80);
	setAction(13,5,81);
	setAction(13,6,82);
	setAction(13,7,83);

      newActionTable(14,8);
	setAction(14,8,96);
	setAction(14,9,97);
	setAction(14,10,98);
	setAction(14,11,99);
	setAction(14,12,100);
	setAction(14,13,101);
	setAction(14,14,102);
	setAction(14,15,103);

      newActionTable(15,8);
	setAction(15,8,120);
	setAction(15,9,121);
	setAction(15,10,126);
	setAction(15,11,127);
	setAction(15,12,124);
	setAction(15,13,116);
	setAction(15,14,117);
	setAction(15,15,125);

      newActionTable(16,8);
	setAction(16,8,132);
	setAction(16,9,133);
	setAction(16,10,138);
	setAction(16,11,135);
	setAction(16,12,139);
	setAction(16,13,128);
	setAction(16,14,129);
	setAction(16,15,137);

      newActionTable(17,8);
	setAction(17,8,144);
	setAction(17,9,145);
	setAction(17,10,146);
	setAction(17,11,150);
	setAction(17,12,151);
	setAction(17,13,140);
	setAction(17,14,141);
	setAction(17,15,149);

      newActionTable(18,8);
	setAction(18,8,156);
	setAction(18,9,154);
	setAction(18,10,161);
	setAction(18,11,162);
	setAction(18,12,163);
	setAction(18,13,152);
	setAction(18,14,153);
	setAction(18,15,160);

      newActionTable(19,8);
	setAction(19,8,167);
	setAction(19,9,168);
	setAction(19,10,173);
	setAction(19,11,174);
	setAction(19,12,175);
	setAction(19,13,164);
	setAction(19,14,165);
	setAction(19,15,172);

      newActionTable(20,8);
	setAction(20,8,178);
	setAction(20,9,179);
	setAction(20,10,180);
	setAction(20,11,181);
	setAction(20,12,182);
	setAction(20,13,183);
	setAction(20,14,184);
	setAction(20,15,185);

      newActionTable(21,8);
	setAction(21,8,187);
	setAction(21,9,188);
	setAction(21,10,189);
	setAction(21,11,190);
	setAction(21,12,191);
	setAction(21,13,192);
	setAction(21,14,195);
	setAction(21,15,194);

      newActionTable(22,1);
	setAction(22,1,196);

    }

  /* *********** */
  /* GOTO TABLES */
  /* *********** */

  static void initializeGotoTables ()
    {
      newGotoTables(12);

      newGotoTable(0,3);
	setGoto(0,1,1);
	setGoto(0,2,2);
	setGoto(0,3,4);

      newGotoTable(1,0);

      newGotoTable(2,2);
	setGoto(2,2,28);
	setGoto(2,3,4);

      newGotoTable(3,3);
	setGoto(3,4,5);
	setGoto(3,5,6);
	setGoto(3,6,7);

      newGotoTable(4,1);
	setGoto(4,7,17);

      newGotoTable(5,3);
	setGoto(5,4,27);
	setGoto(5,5,6);
	setGoto(5,6,7);

      newGotoTable(6,3);
	setGoto(6,4,26);
	setGoto(6,5,6);
	setGoto(6,6,7);

      newGotoTable(7,3);
	setGoto(7,4,25);
	setGoto(7,5,6);
	setGoto(7,6,7);

      newGotoTable(8,3);
	setGoto(8,4,24);
	setGoto(8,5,6);
	setGoto(8,6,7);

      newGotoTable(9,3);
	setGoto(9,4,23);
	setGoto(9,5,6);
	setGoto(9,6,7);

      newGotoTable(10,3);
	setGoto(10,4,22);
	setGoto(10,5,6);
	setGoto(10,6,7);

      newGotoTable(11,3);
	setGoto(11,4,21);
	setGoto(11,5,6);
	setGoto(11,6,7);

    }

  /* ************ */
  /* STATE TABLES */
  /* ************ */

  static void initializeStateTables ()
    {
      setTables(0,0,0);
      setTables(1,1,1);
      setTables(2,2,1);
      setTables(3,3,2);
      setTables(4,4,3);
      setTables(5,5,4);
      setTables(6,6,1);
      setTables(7,7,1);
      setTables(8,8,1);
      setTables(9,9,1);
      setTables(10,10,1);
      setTables(11,11,1);
      setTables(12,12,1);
      setTables(13,13,5);
      setTables(14,13,6);
      setTables(15,13,7);
      setTables(16,13,8);
      setTables(17,14,1);
      setTables(18,13,9);
      setTables(19,13,10);
      setTables(20,13,11);
      setTables(21,15,4);
      setTables(22,16,4);
      setTables(23,17,4);
      setTables(24,18,4);
      setTables(25,19,4);
      setTables(26,20,4);
      setTables(27,21,4);
      setTables(28,22,1);
    }
}

/* ***************** */
/* ANCILLARY CLASSES */
/* ***************** */



/* ************************************************************************ */
/* ********************* END OF GRAMMAR XmlGenEx.grm ********************** */
/* ************************************************************************ */



