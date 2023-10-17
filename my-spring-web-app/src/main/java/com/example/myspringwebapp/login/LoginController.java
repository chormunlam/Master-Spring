package com.example.myspringwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login")//login?name=xyz

    public String gotoLoginPage(){

        return "login";
    }
}

//public class LoginController {
//    //private Logger logger = LoggerFactory.getLogger(getClass());
//    @RequestMapping("login")//login?name=xyz
////    @ResponseBody
//    //Model
//    public String gotoLoginPage(@RequestParam String name, ModelMap model){
//        //System.out.println(name);//not recommed , for testing only
//
//        model.put("name", name);
//        //logger.info("request parma is {}",name);
//        return "login";
//    }
//}
