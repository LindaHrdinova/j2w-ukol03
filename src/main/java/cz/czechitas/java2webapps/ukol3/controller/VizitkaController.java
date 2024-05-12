package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Dita (Přikrylová) Formánková", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00", "dita@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Barbora Bühnová", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00", null, "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Monika Ptáčníková", "Czechitas z. s.", "Václavské náměstí 837/11", "110 00", "monika@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Linda Hrdinová", "Buchtičkovi s. r. o.", "Kočičí 611", "130 00", "hrdinova.linda@seznam.cz", "731 204 555", "www.buchtickovi.cz"),
            new Vizitka("Melichar von Buchtičkov", "Buchtičkovi s. r. o.", "Kočičí 611", "130 00", null, null, "www.buchtickovi.cz")
    );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("seznamVizitek", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("lekce", seznamVizitek);
        return modelAndView;
    }
}


/*
Uprav metodu seznam() tak, aby vracela ModelAndView. Zvol správné view a do modelu vlož seznam vizitek.
Uprav šablonu seznam.html tak, aby zobrazovala vizitky z modelu. Každá vizitka musí odkazovat na svou stránku s detailem.
Uprav metodu detail() tak, aby vracela ModelAndView. Uprav metodu tak, aby z požadavku prohlížeče načítala query parametr id. Zvol správné view a do modelu vlož vizitku získanou ze seznamu na základě id (indexu v seznamu).
Uprav šablonu detail.html tak, aby zobrazovala vizitku z modelu.
Pro zobrazení mapy použij připravený kód s tagem iframe, který vkládá vloženou mapu Mapy.cz. Jako parametr q se do URL předává adresa, která se má na mapě zobrazit. Tuto adresu je potřeba zakódovat pomocí built-in funkce Freemarkeru url. Místo statického stringu s adresou Czechitas na Václavském náměstí tedy předej property celaAdresa (pozor na to, že už nyní je statický string vložený v interpolaci ${…}, tu už tedy do šablony nepřidáváš).
 */