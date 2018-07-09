package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.model.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterDAO spitterDAO;

    public void setSpitterDAO(SpitterDAO spitterDAO) {
        this.spitterDAO = spitterDAO;
    }

    @RequestMapping("/{username}")
    public String getSpittleByUserName(@PathVariable String username, Model model) {
        model.addAttribute("spitter", spitterDAO.getSpitterByUsername(username));

        return "spitter/spittles";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET, params = {"new"})
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "spitter", new Spitter());
    }

    @RequestMapping(path = "/edit/{username}", method = RequestMethod.GET)
    public String showEditPage(Model model, @PathVariable String username) {
        model.addAttribute(spitterDAO.getSpitterByUsername(username));
        return "spitter/edit";
    }

    @RequestMapping(path = "/edit/{username}", method = RequestMethod.POST)
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
