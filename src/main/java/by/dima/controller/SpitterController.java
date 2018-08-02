package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.dao.SpittleDAO;
import by.dima.model.entity.Spitter;
import by.dima.model.logic.FileHandler;
import by.dima.security.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterDAO spitterDAO;

    @Autowired
    private SpittleDAO spittleDAO;

    @Autowired
    private FileHandler fileHandler;

    @Autowired
    private UserLogin userLogin;

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
    public String editSpitter(HttpServletRequest request, @PathVariable String username, @RequestParam String password, @RequestParam String email, @RequestParam("file") MultipartFile file) {
        Spitter oldSpitter = spitterDAO.getSpitterByUsername(username);
        if (password != null && !(password == "") && !oldSpitter.getPassword().equals(password)) {
            oldSpitter.setPassword(password);
        }

        if (email != null && !(email == "") && !oldSpitter.getEmail().equals(email)) {
            oldSpitter.setEmail(email);
        }
        if (file != null) {
            String filename = oldSpitter.getId() + file.getOriginalFilename();
            fileHandler.loadFile(filename, file);
            oldSpitter.setImage(filename);
        }

        spitterDAO.updateSpitter(oldSpitter);
        userLogin.login(request, oldSpitter.getUsername(), oldSpitter.getPassword());

        return "redirect:/spitter/" + oldSpitter.getUsername();
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, @Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }

        spitterDAO.addSpitter(spitter);

        userLogin.login(request, spitter.getUsername(), spitter.getPassword());

        return "redirect:/spitter/edit/" + spitter.getUsername();
    }
}
