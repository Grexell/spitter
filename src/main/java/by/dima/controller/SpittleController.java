package by.dima.controller;

import by.dima.dao.SpitterDAO;
import by.dima.dao.SpittleDAO;
import by.dima.model.entity.Spitter;
import by.dima.model.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/spitter/{username}/spittle")
public class SpittleController {

    @Autowired
    private SpitterDAO spitterDAO;

    @Autowired
    private SpittleDAO spittleDAO;

    @RequestMapping("/")
    public String getSpittleWriteView(Model model, @PathVariable String username){
        model.addAttribute("spitter", username);
        model.addAttribute(new Spittle());
        return "send";
    }

    @RequestMapping("/send")
    public String sendSpitter(@Valid @ModelAttribute Spittle spittle, @PathVariable String username, Model model, BindingResult bindingResult){
        Spitter spitter = spitterDAO.getSpitterByUsername(username);

        spittle.setLatitude(0.0);
        spittle.setLatitude(0.0);
        spittle.setTime(new Date());
        spittle.setSpitter(spitter);

        spittleDAO.addSpittle(spittle);

        return "redirect:/spitter/" + username;
    }
}