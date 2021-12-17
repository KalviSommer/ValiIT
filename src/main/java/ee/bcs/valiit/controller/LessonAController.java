package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.LessonA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonAController {

    // http://localhost:8080/lessonA/e1?a=5
    @GetMapping("lessonA/e1")
    public int e1(@RequestParam("a") int a) {
        return LessonA.e1(a);
    }

    // http://localhost:8080/lessonA/e2?a=5&b=2
    @GetMapping("lessonA/e2")
    public int e2(@RequestParam("a") int a, @RequestParam("b") int b) {
        return LessonA.e2(a, b);
    }

    // http://localhost:8080/lessonA/e3?x=5
    @GetMapping("lessonA/e3")
    public int e3(@RequestParam("x") int x) {
        return LessonA.e3(x);
    }

    // http://localhost:8080/lessonA/e4?a1=5&b1=2&a2=6&b2=3&a3=7&b3=4
    @GetMapping("lessonA/e4")
    public int e4(@RequestParam("a1") int a1, @RequestParam("b1") int b1, @RequestParam("a2") int a2,
                  @RequestParam("b2") int b2, @RequestParam("a3") int a3, @RequestParam("b3") int b3) {
        return LessonA.e4(a1, b1, a2, b2, a3, b3);
    }

    // http://localhost:8080/lessonA/e5
    @GetMapping("lessonA/e5")
    public int e5() {
        return LessonA.e5();
    }

    // http://localhost:8080/lessonA/e6?x=4
    @GetMapping("lessonA/e6")
    public boolean e6 (@RequestParam("x") int x) {
        return LessonA.e6(x);
    }

    // http://localhost:8080/lessonA/e7?x=true
    @GetMapping("lessonA/e7")
    public boolean e7 (@RequestParam("x") boolean x) {
        return LessonA.e7(x);
    }

    // http://localhost:8080/lessonA/e8?x1=true&x2=false
    @GetMapping("lessonA/e8")
    public boolean e8 (@RequestParam("x1") boolean x1, @RequestParam("x2") boolean x2) {
        return LessonA.e8(x1, x2);
    }

    // http://localhost:8080/lessonA/e9?x1=true&x2=false&x3=true&x4=false
    @GetMapping("lessonA/e9")
    public boolean e9 (@RequestParam("x1") boolean x1, @RequestParam("x2") boolean x2,
                       @RequestParam("x3") boolean x3, @RequestParam("x4") boolean x4) {
        return LessonA.e9(x1, x2, x3, x4);
    }

    // http://localhost:8080/lessonA/e10?x=1,2,3,4,5
    @GetMapping("lessonA/e10")
    public int[] e10(@RequestParam("x") int[] array) {
        LessonA.e10(array);
        return array;
    }

    // http://localhost:8080/lessonA/e11?x=1,2,3,4,5
    @GetMapping("lessonA/e11")
    public int[] e11(@RequestParam("x") int[] array) {
        LessonA.e11(array);
        return array;
    }

    // http://localhost:8080/lessonA/e12?x=1,2,3,4,5
    @GetMapping("lessonA/e12")
    public int[] e12(@RequestParam("x") int[] array) {
        LessonA.e12(array);
        return array;
    }

    // http://localhost:8080/lessonA/e13?x=1,2,3,4,5
    @GetMapping("lessonA/e13")
    public int[] e13(@RequestParam("x") int[] array) {
        LessonA.e13(array);
        return array;
    }

    // http://localhost:8080/lessonA/e14?x=1,2,3,4,5,6,7,8
    @GetMapping("lessonA/e14")
    public int[] e14(@RequestParam("x") int[] array) {
        LessonA.e14(array);
        return array;
    }

    // http://localhost:8080/lessonA/e15?x=1,2,3,4,5
    @GetMapping("lessonA/e15")
    public int[] e15(@RequestParam("x") int[] array) {
        LessonA.e15(array);
        return array;
    }

    public static class Lesoon3HardController {
    }
}
