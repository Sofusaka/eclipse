package co.edu.upb.ejerciciointerfaces2;

public class Derecho implements ProgramaAcademico {

	public String name;
	public String director;
	public String[] materias;
	public int creditos;
	public String[] profesores;
	public int librosLeidos;
	
	@Override
	public String getNombre() {
		
		return name;
	}

	@Override
	public void setNombre() {
		
		this.name="Derechos";

	}

	@Override
	public String getDirector() {
		
		return director;
	}

	@Override
	public void setDirector() {
		
		this.director="Aristoteles";

	}

	@Override
	public String[] getMaterias() {
		
		return materias;
	}

	@Override
	public void setMaterias() {
		this.materias= new String[] {"Etica I","Debate I","Constitucion I"};

	}

	@Override
	public int getCreditos() {
		
		return creditos;
	}

	@Override
	public void setCreditos(int id) {
		
		this.creditos=130;

	}

	@Override
	public String[] getNombreProfesores() {
		
		return profesores;
	}

	@Override
	public void setNombreProfesores() {
		
		this.profesores= new String[] {"Andres Bello","Simon Bolivar","Will Graham"};

	}
	
	public int getCantidadLibrosLeidos() {
		
		return librosLeidos;
	}
	
	public void setCantidadLibrosLeidoss() {
		
		this.librosLeidos=1000000;
	

}
	
}
