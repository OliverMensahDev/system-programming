package org.intro;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ubu on 3/2/14.
 */
public class Lesson6 {

   // Constant algorithm does not depend on the input size.
   // Execute one instruction a fixed number of times 	Arithmetic operations (+, -, *, /, %)
   // Comparison operators (<, >, ==, !=)
   // Variable declaration
   // Assignment statement
   // Invoking a method or function

    static  String data[] = new String[] {"first ", "second ", "third ", "fourth ", "fith " };

    static List<String> loopList  = Arrays.asList(data);

    public static void main(String[] args) {

        for (int k = 0; k <loopList.size(); k++) {
            if(loopList.get(k).length() < 6)
            System.out.println(loopList.get(k));

        }


    }
}
