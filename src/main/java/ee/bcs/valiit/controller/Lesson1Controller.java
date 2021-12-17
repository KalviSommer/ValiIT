package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson1Controller {

    // http://localhost:8080/lesson1/min/15/23
    @GetMapping("lesson1/min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b){
        return Lesson1.min(a, b);
    }

    // http://localhost:8080/lesson1/max/15/23
    @GetMapping("lesson1/max/{a}/{b}")
    public int max(@PathVariable("a") int a, @PathVariable("b") int b){
        return Lesson1.max(a, b);
    }

    // http://localhost:8080/lesson1/abs/-15
    @GetMapping("lesson1/abs/{a}")
    public int abs(@PathVariable("a") int a) {
        return Lesson1.abs(a);
    }

    // http://localhost:8080/lesson1/isEven/15
    @GetMapping("lesson1/isEven/{a}")
    public boolean isEven(@PathVariable("a") int a) {
        return Lesson1.isEven(a);
    }

    // http://localhost:8080/lesson1/min3/15/23/34
    @GetMapping("lesson1/min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.min3(a, b, c);
    }

    // http://localhost:8080/lesson1/max3/15/23/34
    @GetMapping("lesson1/max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.max3(a, b, c);
    }

    // http://localhost:8080/lesson1/someString
    @GetMapping("lesson1./someString")
    public String someString(){
        return Lesson1.someString();
    }
}
