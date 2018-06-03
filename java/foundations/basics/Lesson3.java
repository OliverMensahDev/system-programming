package org.intro;

/**
 * Created by ubu on 3/2/14.
 */
public class Lesson3 {

// Type conversion: Automatically converts integers -> float -> double
    public static void main(String[] args) {

        doSwitch(1);

    }

  private static  void doSwitch(int choiceValue) {


    switch (choiceValue)
    {
        case 1:
            System.out.println("switch evaluates to case 1");
            break;
        case 2:
            System.out.println("switch evaluates to case 2");
            break;
        case 3:
            System.out.println("switch evaluates to case 3");
            break;
        default:
            System.out.println("switch evaluates to default");
            break;
    }

}

    }


