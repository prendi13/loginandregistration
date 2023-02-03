package com.betaplan.alberto.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.betaplan.alberto.loginandregistration.models.LoginUser;
import com.betaplan.alberto.loginandregistration.models.User;
import com.betaplan.alberto.loginandregistration.services.UserService;

////////////////////////////////////////////////////////////////////
//	HOME CONTROLLER
////////////////////////////////////////////////////////////////////

@Controller
public class HomeController {



    @Autowired
    private UserService userServ;



    //	**** Display the root with Registration and Log-in Forms ***
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {		// If user is in session
            return "redirect:/dashboard";					//		re-route to dashboard
        }

        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    //	**** Display DASHBOARD *************************************
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.isNew() || session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
        model.addAttribute("loggedInUser", loggedInUser);
        return "dashboard.jsp";
    }



    //	**** PUT: Register the New User ****************************

    @PutMapping("/")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }

    //	**** POST: Login the User ***********************************

    @PostMapping("/")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }

    //	//// DELETE //////////////////////////////////////////////////

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();					// 	Log the user out
        return "redirect:/";					//		then redirect to index
    }
}