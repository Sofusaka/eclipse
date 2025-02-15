package co.edu.upb.pdfconverter;



public record UrlType(String URL, String name) {

	//es para poder crear los URL!!
	
	public String getName() {
		
		return this.name;
	}
	
	public String getUrl() {
		
		return this.URL;
	}
	 
}
