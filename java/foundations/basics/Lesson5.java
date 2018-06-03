package org.intro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ubu on 3/2/14.
 */
public class Lesson5 {

   static  String data[] = new String[] {"first ", "second ", "third ", "fourth ", "fith " };

    static List <String> loopList  = Arrays.asList(data);

    public static void main(String[] args) {


        System.out.println("list  loop ");

        Iterator<String> iterator = loopList.iterator();

        while (iterator.hasNext()) {

          String temp = iterator.next();

          if (temp.equals("second ")) continue;

          System.out.println(temp);

        }



    }
}
