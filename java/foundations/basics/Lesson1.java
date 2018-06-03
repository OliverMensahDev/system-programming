package org.intro;

/**
 * Created by ubu on 2/28/14.
 */
public class Lesson1 {

    // static variables

    static final String staticString ="a interned string when declared final"; // has package scope
    private static int staticInt =1;

    // instance variables

    public String instanceString; // generally defined at runtime.< public scope
    int instanceint; // compiler will give default values
    boolean isAboolean; // compiler will give default values


    public static void main(String[] args) {

        // use class variables

        System.out.println(Lesson1.staticString);

    }



}
