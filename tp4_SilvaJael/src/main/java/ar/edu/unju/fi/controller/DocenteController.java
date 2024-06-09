package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {

/*	@GetMapping("/formularioDocente")
    public ModelAndView getformDocente() {
        //legajo
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject(new Docente());
		
		ListadoDocente.agregarDocente(new Docente());
		
        return modelView;*/
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente.html
		ModelAndView modelView = new ModelAndView("formDocente");
		//agrega el objeto
		modelView.addObject("nuevoDocente", nuevoDocente);	
		
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente DocenteParaGuardar) {
					
		//guardar
		ListadoDocente.agregarDocentes(DocenteParaGuardar);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());	
		
		return modelView;		
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDocente.eliminarDocentes(legajo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editdocente(@PathVariable(name = "legajo") String legajo) {
	    // Buscar la docente por el código
	    Docente docenteModificada = ListadoDocente.buscarDocentePorLegajo(legajo);

	    ModelAndView modelView = new ModelAndView("formDocente");			
	    modelView.addObject("nuevoDocente", docenteModificada);
	    modelView.addObject("band", true);
	    
	    return modelView;
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificardocente(@ModelAttribute("nuevoDocente") Docente docenteModificada) {
	    // Lógica para modificar la docente
	    ListadoDocente.modificarDocentes(docenteModificada);

	    ModelAndView modelView = new ModelAndView("listaDocentes");
	    modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());

	    return modelView;
	}
	
	@GetMapping("/docentes")
	public ModelAndView mostrarDocentes() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());	
		return modelView;		
	}
		 
}
