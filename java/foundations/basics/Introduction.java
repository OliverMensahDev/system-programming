package org.intro;

/**
 * Created by ubu on 2/24/14.
 */
public class Introduction {


    // Strong typing

    String constantString = "config value";

    long  filterValue =  1642816l;


    // in a high level language variables are loosely typed

    /*
    var  constantString = " s config value";

    var  filterValue =  1642816l;

    */

   // this is a scope block

    {

        long  filterValue =  2642816l;


    }


    // Support for and bias toward explicit iteration rather than recursion.


    public void iterativeFunction () {

        for(int i = 0; i < 10; i++) {

            System.out.println(i*i);
        }


    }

// a recursive function calls itself
    public int recursiveFunction (int k) {

        System.out.println(recursiveFunction (k*k--));
        return k;

    }



// java does not have functions, the above code are called methods
    // below is an example of a functional in a high level functional language

    /*
        var functionalVar = function(identifier, optional callback() {

        });

     */

    // Heap storage more visible and varied: objects (in contrast to lists)

    Object obj = new Object();

    // in java arrays are objects
    String[] arrayOfStrings = new String[10];


    // In other languages such as lisp and programming shells such as Data Structures can be types

    // Graph graphType;

    // in lower level languages such as C++  the language used to create Java
    // arrays can be pointers to a block of memory

    //  java does not allow pointers the following code is illegal in java
    /*
    int g[] = {9,8};
    int (*j) = g;
   */



    public static void main(String[] args) {





    }


}
