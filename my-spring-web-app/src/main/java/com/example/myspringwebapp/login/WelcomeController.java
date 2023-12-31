package com.example.myspringwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    //private AuthenticationService authenticationService = new AuthenticationService();
    //change the value from "login" to "/"
    @RequestMapping(value = "/", method= RequestMethod.GET)//login?name=xyz

    public String gotoWelcomePage(ModelMap model){
        model.put("name",getLoggedinUsername());

        return "welcome";//was 'login'
    }

    private String getLoggedinUsername(){
        Authentication authentication=
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
// no logger needed bc it goona handle with srping security
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name,
//                                  @RequestParam String password, ModelMap model){
//        if(authenticationService.authenticate(name, password)){
//        model.put("name",name);
//        //model.put("password", password);
//
//
//        //authentication
//        //name - cm
//        //password-dd666
//
//        return "welcome";
//    }

//        model.put("errorMessage", "Invalid Credentials, plz try again");
//        return "login";
//    }


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
