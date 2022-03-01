package hello.studySpring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
*
* 2022-01-09 김형대 최초작성자
* 스터디 페이지
* */
@Controller
public class HelloController {


    //깃테스트
    @GetMapping("hello")
    public String hello(Model model){
        Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
        logger.info("hello Page");
        model.addAttribute("data","hello!!");

        // return "이름" << templates 에 있는 html 찾아서 값을 넣어줌 ex) return "hi" => hi.html
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name , Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //"helloString"
    }


    //json 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static  class  Hello {
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
