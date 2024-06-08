package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {

	@GetMapping("/formularioDocente")
    public ModelAndView getformDocente() {
        //codigo
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject(new Docente());
		
		ListadoDocente.agregarDocente(new Docente());
		
        return modelView;
    }
}
