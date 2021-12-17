package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {

    // http://localhost:8080/lesson3/factorial?x=5
    @GetMapping("lesson3/factorial")
    public int factorial (@RequestParam ("x") int x){
        return Lesson3.factorial(x);
    }

    // http://localhost:8080/lesson3/reverseString?a=ivlak
    @GetMapping("lesson3/reverseString")
    public String reverseString (@RequestParam ("a") String a){
        return Lesson3.reverseString(a);
    }

    // http://localhost:8080/lesson3/isPrime?x=3
    @GetMapping("lesson3/isPrime")
    public boolean isPrime (@RequestParam ("x") int x){
        return Lesson3.isPrime(x);
    }

    //http://localhost:8080/lesson3/sort?a=1,10,75,3,15,0
    @GetMapping("lesson3/sort")
    public int[] sort (@RequestParam ("a") int[] a){
        return Lesson3.sort(a);
    }

    // http://localhost:8080/lesson3/evenFibonacci?x=7
    @GetMapping("lesson3/evenFibonacci")
    public int evenFibonacci (@RequestParam ("x") int x){
        return Lesson3.evenFibonacci(x);
    }

    //http://localhost:8080/lesson3/morseCode?text=kalvi
    @GetMapping("lesson3/morseCode")
    public String morseCode(@RequestParam ("text") String text){
        return Lesson3.morseCode(text);
    }

}
