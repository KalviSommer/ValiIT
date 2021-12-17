package ee.bcs.valiit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        boolean a = true;
//        boolean b = false;
//        Boolean c = true;
//        Boolean d = false;
//        Boolean e = null;

        String a = "Hello World";
        System.out.println(a.length());
        System.out.println(a.charAt(6));
        System.out.println(a.substring(0,5));
        String b = "Hello World";
        if(a.equals(b)){
            System.out.println("Õige");
        }
        if(a == b){
            System.out.println("Vale");
        }

        List <Integer> numbersList = new ArrayList<>();
        numbersList.add(7);
        numbersList.add(4);
        numbersList.set(1,7);
        numbersList.remove(1);
        System.out.println(numbersList);
    }


}
