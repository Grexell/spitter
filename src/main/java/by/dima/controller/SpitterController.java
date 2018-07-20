package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.dao.SpittleDAO;
import by.dima.model.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterDAO spitterDAO;

    @Autowired
    private SpittleDAO spittleDAO;

    public void setSpitterDAO(SpitterDAO spitterDAO) {
        this.spitterDAO = spitterDAO;
    }

    @RequestMapping("/{username}")
    public String getSpittleByUserName(@PathVariable String username, Model model) {
        Spitter spitter = spitterDAO.getSpitterByUsername(username);

        model.addAttribute("spittles", spittleDAO.getAllBySpitter(spitter));
        model.addAttribute("spitter", spitter);

        return "spitter/spittles";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(path = "/login/", method = RequestMethod.POST)
    @PreAuthorize("@username == principal.username")
    public String login(@P("username") @RequestParam("username") String username) {
        return "redirect:/spitter/" + username;
    }


    @RequestMapping(path = "/register", method = RequestMethod.GET, params = {"new"})
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "spitter", new Spitter());
    }

    @RequestMapping(path = "/edit/{username}", method = RequestMethod.GET)
    @PreAuthorize("#username == principal.username")
    public String showEditPage(Model model, @PathVariable String username) {
        model.addAttribute(spitterDAO.getSpitterByUsername(username));

        return "spitter/edit";
    }

    @RequestMapping(path = "/edit/{username}", method = RequestMethod.POST)
    @PreAuthorize("#username == principal.username")
    public String editSpitter(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "spitter/edit";
        }

        spitterDAO.updateSpitter(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }

        spitterDAO.addSpitter(spitter);
        return "redirect:/spitter/edit/" + spitter.getUsername();
    }
}
