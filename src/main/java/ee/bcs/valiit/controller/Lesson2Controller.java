package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.LessonA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    // http://localhost:8080/lesson2/sampleArray
    @GetMapping("lesson2/sampleArray")
    public int[] sampleArray() {
        return Lesson2.sampleArray();
    }

    // http://localhost:8080/lesson2/generateArray?n=8
    @GetMapping("lesson2/generateArray")
    public int[] generateArray(@RequestParam("n") int n) {
        return Lesson2.generateArray(n);
    }

    // http://localhost:8080/lesson2/decreasingArray?n=8
    @GetMapping("lesson2/decreasingArray")
    public int[] decreasingArray(@RequestParam("n") int n) {
        return Lesson2.decreasingArray(n);
    }

    // http://localhost:8080/lesson2/yl3?n=8
    @GetMapping("lesson2/yl3")
    public int[] yl3(@RequestParam("n") int n) {
        return Lesson2.yl3(n);
    }

}
