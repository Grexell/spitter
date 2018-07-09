package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.dao.SpittleDAO;
import by.dima.model.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final int DEFAULT_COUNT = 25;

    @Autowired
    private SpitterDAO spitterDAO;

    @Autowired
    private SpittleDAO spittleDAO;

    public void setSpitterDAO(SpitterDAO spitterDAO) {
        this.spitterDAO = spitterDAO;
    }

    public void setSpittleDAO(SpittleDAO spittleDAO) {
        this.spittleDAO = spittleDAO;
    }

    @RequestMapping(value = {"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute(new Spitter());
        model.addAttribute("spittles", spittleDAO.getLast(DEFAULT_COUNT));

        return "home";
    }
}