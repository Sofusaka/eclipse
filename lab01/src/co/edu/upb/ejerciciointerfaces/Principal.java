package co.edu.upb.ejerciciointerfaces;

public class Principal {

	public static void main(String[] args) {
		
		Estudiante estudiante= new Estudiante();
		Docente docente= new Docente();
		
		estudiante.setNombres(null);
		docente.setNombres(null);
		
		 System.out.println(estudiante.getNombres());
		 System.out.println(docente.getNombres());

	}

}
