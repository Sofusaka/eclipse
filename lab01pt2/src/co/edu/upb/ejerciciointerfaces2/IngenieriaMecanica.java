package co.edu.upb.ejerciciointerfaces2;

public class IngenieriaMecanica implements ProgramaAcademico {
	
	public String name;
	public String director;
	public String[] materias;
	public int creditos;
	public String[] profesores;
	public int carrosFabricados;
	
	@Override
	public String getNombre() {
		
		return name;
	}

	@Override
	public void setNombre() {
		
		this.name="Ingeniería Mecánica";

	}

	@Override
	public String getDirector() {
		
		return director;
	}

	@Override
	public void setDirector() {
		
		this.director="Pepe Rodriguez";

	}

	@Override
	public String[] getMaterias() {
		
		return materias;
	}

	@Override
	public void setMaterias() {
		this.materias= new String[] {"motor I","fisica I","armar motores I"};

	}

	@Override
	public int getCreditos() {
		
		return creditos;
	}

	@Override
	public void setCreditos(int id) {
		
		this.creditos=159;

	}

	@Override
	public String[] getNombreProfesores() {
		
		return profesores;
	}

	@Override
	public void setNombreProfesores() {
		
		this.profesores= new String[] {"Cristobal Colon el Septimo","Albert Einstein II","Hannibal Lecter"};

	}
	
	public int getCantidadCarrosFabricados() {
		
		return carrosFabricados;
	}
	
	public void setCantidadCarrosFabricados() {
		
		this.carrosFabricados=126;
	}

}
