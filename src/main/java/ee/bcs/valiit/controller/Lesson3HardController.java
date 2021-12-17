package ee.bcs.valiit.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {

//    Random random = new Random();
//    int randomNumber = random.nextInt(100);
//    int count = 0;
//
//    //    http://localhost:8080/lesson3hard/guess/guess=5
//    @GetMapping("lesson3hard/guess/{guess}")
//    public String guess(@PathVariable("guess") int guess) {
//        count++;
//        if (guess > randomNumber) {
//            return "Arv on väiksem";
//        } else if (guess < randomNumber) {
//            return "Arv on suurem";
//        } else {
//            randomNumber = random.nextInt(100);
//            int oldCount = count;
//            count = 0;
//            return "Tubli arvasid ära. Sul läks " + oldCount + " korda";
//        }
//    }

}
