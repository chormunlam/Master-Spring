package com.example.myspringwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//telling it ask ing web request
@Controller
public class SayHelloController {

    //http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "hello, what are you learning todayhhhh?";
    }

    //http://localhost:8080/say-hello-html
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){

        StringBuffer sb =new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first html page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("my ddd");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    //http://localhost:8080/say-hello-jsp
    @RequestMapping("say-hello-jsp")
//    @ResponseBody
    public String sayHelloJsp(){
        return "sayHello";
    }

// src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
}
