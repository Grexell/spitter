package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.dao.SpittleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

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
    public String homePage(Map<String, Object> model) {
        //model.put("spittles", spittleDAO.getLast(DEFAULT_COUNT));

        return "home";
    }
}