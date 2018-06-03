package org.intro;

/**
 * Created by ubu on 2/28/14.
 */
public class Lesson2 {

    // these variable are static or class variables

    {
        int integerPrimitive=1;
        float floatPrimitive = 1.2f;// need the f
        double doublePrimitive = 3.0;//
        long longPrimitive = 346l;// long Integer
        byte bytePrimitive = -27; // a integer value between + or - 127

        char f = 'c'; // err here can you see why ?

        int foo;             // danger! uninitialized variable

        {
            int y=3;
        //    int integerPrimitive;         // Error, cannot shadow vars in enclosing blocks
           // more code here ...

        }    }

        // if an enum is a member of a class, it’s implicitly static
        public enum ResponseType {
            denied,
            notfound,
            ok
        }

           String[] responseTypeStrings = {"denied", "notfound","ok" };
           int[] myintArray = new int[3];


     public static void main(String argv[]) {


         Lesson2 lesson2 = new Lesson2();

         System.out.println(lesson2.responseTypeStrings[1]);

    }

    }

 //  Notes:
 //             - statements are terminated with ;
 //             - {} are used to delimit blocks (compound statements)
 //             - // used for end-of-line comments. C /* ... */ syntax also allowed
 //             - variables must be defined before use.
 //             - variables can be defined anywhere in block.
 //             - unlike C which required definitions at top.
 //             - variables can be initialized with '='
 //             - variables don't have to be initialized, but they should be.
 //             - variables are defined with 'types'


