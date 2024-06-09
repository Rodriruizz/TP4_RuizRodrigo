package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formMateria")
    public ModelAndView getFormMateria() {
		//vista de formDocente
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("band",false);
        return modelView;
    }
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia materiaAGuardar) {
		materiaAGuardar.setDocente(ListadoDocente.buscarDocentePorLegajo(materiaAGuardar.getDocente().getLegajo()));
		materiaAGuardar.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaAGuardar.getCarrera().getCodigo()));
		ListadoMateria.agregarMateria(materiaAGuardar);
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaMaterias");
		modelView.addObject("listadoMateria", ListadoMateria.listarMaterias());	
		return modelView;	
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMateria.eliminarMateria(codigo);
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaMaterias");
		modelView.addObject("listadoMateria", ListadoMateria.listarMaterias());	
		return modelView;		
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editmateria(@PathVariable(name="codigo") String codigo) {
		//seleccionar el docente para modificar
		Materia materiaAModificar = ListadoMateria.buscarMateriaPorCodigo(codigo);
		
		//mostrar el formulario de modificacion
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materiaAModificar);	
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("band", true);
		return modelView;		
		}
	
	
	@PostMapping("/modificarMateria")
	public ModelAndView updatemateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
		
		materiaModificada.setDocente(ListadoDocente.buscarDocentePorLegajo(materiaModificada.getDocente().getLegajo()));
		materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materiaModificada.getCarrera().getCodigo()));
		//modificar el docente
		ListadoMateria.modificarMateria(materiaModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaMaterias");
		modelView.addObject("listadoMateria", ListadoMateria.listarMaterias());	
		return modelView;	
	}
	
	
	@GetMapping("/materias")
	public ModelAndView showMaterias() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaMaterias");
		modelView.addObject("listadoMateria", ListadoMateria.listarMaterias());
		return modelView;		
	}
}
