package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocente {
	
public static List<Docente> docentes = new ArrayList<Docente>();
	
	  public static List<Docente> listarDocentes() {
		  
		  if (docentes.isEmpty()) {
			  docentes.add(new Docente("123", "Ruby", "Belrose", "r@k","234"));
		  }
	    return docentes;
	  }

	  public static Docente buscarDocentePorLegajo(String leg) {
	    for (Docente d : docentes) {
	      if (d.getLegajo().equals(leg)) {
	        return d;
	      }
	    }
	    return null;
	  }

	  public static void agregarDocentes(Docente d) {
	    docentes.add(d);
	  }

	  public static void modificarDocentes(Docente docenteModificado) {
		    for (int i = 0; i < docentes.size(); i++) {
		      Docente docente = docentes.get(i);
		      if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
		        docentes.set(i, docenteModificado);
		        break;
		      }
		    }
		  }

	  public static void eliminarDocentes(String leg) {
		  docentes.removeIf(docente -> docente.getLegajo().equals(leg));
	  }

}
