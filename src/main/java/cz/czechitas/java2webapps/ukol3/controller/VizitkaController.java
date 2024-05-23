package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Dita (Přikrylová) Formánková", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00 Praha 1", "dita@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Barbora Bühnová", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00 Praha 1", null, "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Monika Ptáčníková", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00 Praha 1", "monika@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Linda Hrdinová", "Buchtičkovi s. r. o.", "Na Kocourkách 6", "169 00 Praha", "hrdinova.linda@seznam.cz", "+420 789 123 456", "www.buchtickovi.cz"),
            new Vizitka("Melichar von Buchtičkov", "Buchtičkovi s. r. o.", "Na Kocourkách 16/6", "169 00 Praha", null, null, "www.buchtickovi.cz"),
            new Vizitka("Princezna Polly", "Buchtičkovi s. r. o.", "Na Kocourkách 16/6", "169 00 Praha", null, null, "www.buchtickovi.cz")
    );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("seznamVizitek", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("seznamVizitek", seznamVizitek.get(id));
        return modelAndView;
    }
}