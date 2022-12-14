package tg.univ.kara.lpmmi.marches.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tg.univ.kara.lpmmi.marches.model.Marche;
import tg.univ.kara.lpmmi.marches.services.MarcheInterfaceImpl;

@Controller
public class MarcheController {

    private MarcheInterfaceImpl marcheInterface;

    public MarcheController() {
        marcheInterface = new MarcheInterfaceImpl();
    }

    @GetMapping("marches")
    public void getMarches(Model model) {
        var marches = marcheInterface.getMarches();
        model.addAttribute("marches", marches);
    }

    @GetMapping("marches/{id}")
    public String findById(@PathVariable(required=false,name="id") int id, Model model) {
        Marche marche = marcheInterface.findById(id);
        model.addAttribute("marche", marche);
        return "marche";
    }

}
