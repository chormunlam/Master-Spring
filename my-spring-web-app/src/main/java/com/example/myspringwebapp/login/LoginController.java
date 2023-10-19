package com.example.myspringwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService = new AuthenticationService();

    @RequestMapping(value = "login", method= RequestMethod.GET)//login?name=xyz

    public String gotoLoginPage(){

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap model){
        if(authenticationService.authenticate(name, password)){
        model.put("name",name);
        //model.put("password", password);


        //authentication
        //name - cm
        //password-dd666

        return "welcome";
    }

        model.put("errorMessage", "Invalid Credentials, plz try again");
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
