package co.edu.upb.ejerciciointerfaces2;


public class Principal {

	public static void main(String[] args) {
		
		Derecho derecho= new Derecho();
		IngenieriaMecanica mecanica= new IngenieriaMecanica();
		
		derecho.setNombre();
		mecanica.setNombre();
		
		 System.out.println(derecho.getNombre());
		 System.out.println(mecanica.getNombre());

	}

}
