package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2bController {

    // http://localhost:8080/lesson2b/reverseArray?newArray=1,2,3,4
    @GetMapping("lesson2b/reverseArray")
    public int[] reverseArray(@RequestParam("newArray") int[] newArray) {
        return Lesson2b.reverseArray(newArray);
    }

    // http://localhost:8080/lesson2b/evenNumbers?n=4
    @GetMapping("lesson2b/evenNumbers")
    public int[] evenNumbers(@RequestParam("n") int n) {
        return Lesson2b.evenNumbers(n);
    }

    // http://localhost:8080/lesson2b/min?x=1,2,3,4
    @GetMapping("lesson2b/min")
    public int min(@RequestParam("x") int [] x) {
        return Lesson2b.min(x);
    }

    // http://localhost:8080/lesson2b/max?x=1,2,3,4
    @GetMapping("lesson2b/max")
    public int max(@RequestParam("x") int [] x) {
        return Lesson2b.max(x);
    }

    // http://localhost:8080/lesson2b/sum?x=1,2,3,4
    @GetMapping("lesson2b/sum")
    public int sum(@RequestParam("x") int [] x) {
        return Lesson2b.sum(x);
    }

    // http://localhost:8080/lesson2b/fibonacci?n=7
    @GetMapping("lesson2b/fibonacci")
    public int fibonacci(@RequestParam("n") int n) {
        return Lesson2b.fibonacci(n);
    }

    // http://localhost:8080/lesson2b/sequence3n?x=1&y=10
    @GetMapping("lesson2b/sequence3n")
    public int sequence3n(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson2b.sequence3n(x , y);
    }

}
