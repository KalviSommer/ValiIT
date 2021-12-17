package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson2b;
import ee.bcs.valiit.tasks.Lesson2c;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2cController {

    // http://localhost:8080/lesson2c/nextElement?x=3
    @GetMapping("lesson2c/nextElement")
    public int nextElement(@RequestParam("x") int x) {
        return Lesson2c.nextElement(x);
    }

    // http://localhost:8080/lesson2c/getSeqLength?x=3
    @GetMapping("lesson2c/getSeqLength")
    public int getSeqLength(@RequestParam("x") int x) {
        return Lesson2c.getSeqLength(x);
    }

    // http://localhost:8080/lesson2c/sequence3n?x=1&y=10
    @GetMapping("lesson2c/sequence3n")
    public int sequence3n(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson2c.sequence3n(x, y);

    }
}
