package progetto_siw_EC.run.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the login page
@Controller
public class mainController {


	
  // Login form
  @RequestMapping("/loginAm")
  public String login() {
    return "loginAm";
  }
  

  // Login form with error
  @RequestMapping("/loginAm?error.html")
  public String aError(Model model) {
    model.addAttribute("error", true);
    return "loginAm";
  }
 }
