package co.edu.upb.ejerciciointerfaces;

public class Docente implements Persona {

	public String name;
	public String nacionalidad;
	public int id;
	public int edad;
	public String estatus;
	
	@Override
	public String getNombres() {
		
		return name;
	}

	@Override
	public void setNombres(String nombres) {
		this.name="Lili";
		

	}

	@Override
	public String getNacionalidad() {
		
		return nacionalidad;
	}

	@Override
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad="venezolana";
	}

	@Override
	public int getId() {
		
		return id;
	}

	@Override
	public void setId(int id) {
		
		this.id=49999;

	}

	@Override
	public int getEdad() {
		
		return edad;
	}

	@Override
	public void setEdad(int edad) {
		
		this.edad=48;

	}
	
public String getEstatus() {
		
		return estatus;
	}
	
	public void setEstatus() {
		
		this.estatus="activo";
	}
	

}
