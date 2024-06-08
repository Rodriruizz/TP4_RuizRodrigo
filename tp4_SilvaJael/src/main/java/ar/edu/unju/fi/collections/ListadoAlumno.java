package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {
	
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos() {
		return alumnos;
	}
	public static Alumno buscarAlumnoPorDni(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
		    }
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public static void modificarAlumno(Alumno alumnoModificado) {
		for (int i = 0; i < alumnos.size(); i++){
			Alumno alumno = alumnos.get(i);
			if (alumno.getDni().equals(alumnoModificado.getDni())) {
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}
	public static void eliminarAlumno(String dni) {
		alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
	}

}
