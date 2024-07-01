package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {

	
	public static List<Carrera> carreras = new ArrayList<Carrera>();
	
		  public static List<Carrera> listarCarreras() {
				
				  List<Carrera> carrerasFiltradas = new ArrayList<>(); for (Carrera carrera :
				  carreras) { if (carrera.isEstado()) { carrerasFiltradas.add(carrera); } }
				 
				  if (carreras.isEmpty()) {
					  carrerasFiltradas.add(new Carrera("1", "APU", 3, true));
				  }
				  
			    return carrerasFiltradas;
		  }

		  public static Carrera buscarCarreraPorCodigo(String codigo) {
		    for (Carrera c : carreras) {
		      if (c.getCodigo().equals(codigo)) {
		        return c;
		      }
		    }
		    return null;
		  }

		  public static void agregarCarrera(Carrera c) {
			c.setEstado(true);
		    carreras.add(c);
		  }

		  public static void modificarCarrera(Carrera carreraModificada) {
			  carreraModificada.setEstado(true);
			  for (int i = 0; i < carreras.size(); i++) {
		      Carrera carrera = carreras.get(i);
		      if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
		        carreras.set(i, carreraModificada);
		        break;
		      }
		    }
		  }

		  public static void eliminarCarrera(String codigo) {
			  
			  for (int i = 0; i < carreras.size(); i++) {
			      Carrera carrera = carreras.get(i);
			      if (carrera.getCodigo().equals(codigo)) {
			        carrera.setEstado(false);
			        break;
			      }
			    }
		  }
		 
		  
}
