package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		modelView.addObject("nuevaCarrera", nuevaCarrera);	
		modelView.addObject("band", false);
		
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraParaGuardar) {
					
		//guardar
		ListadoCarreras.agregarCarrera(carreraParaGuardar);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
		
		return modelView;		
	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoCarreras.eliminarCarrera(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras())
		
		;	
		
		return modelView;		
		}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editCarrera(@PathVariable(name = "codigo") String codigo) {
	    // Buscar la carrera por el código
	    Carrera carreraModificada = ListadoCarreras.buscarCarreraPorCodigo(codigo);

	    ModelAndView modelView = new ModelAndView("formCarrera");			
	    modelView.addObject("nuevaCarrera", carreraModificada);
	    modelView.addObject("band", true);
	    
	    return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
	    // Lógica para modificar la carrera
	    ListadoCarreras.modificarCarrera(carreraModificada);

	    ModelAndView modelView = new ModelAndView("listaCarreras");
	    modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());

	    return modelView;
	}

	@GetMapping("/carreras")
	public ModelAndView showCarreras() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());	
		return modelView;		
	}
}

