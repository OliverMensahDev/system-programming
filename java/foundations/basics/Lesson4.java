package org.intro;

/**
 * Created by ubu on 3/2/14.
 */
public class Lesson4 {

        static boolean y1;

        public static int fact(int a){
            if(a <= 1) return(1);
            return(a * fact( --a));
        }

        public static void main(String[] args) {
            int x = 7;
            //x -= 2;// x = x-2
             // x +=2;

            boolean y =false;
            y = !y;
            System.out.println("value of y is " + y );
         //   System.out.println("value of x is " + x );



        }
    }

