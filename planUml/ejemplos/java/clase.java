package planUml.ejemplos.java;


/*
* @startuml
* abstract        abstract
* abstract class  "abstract class"
* annotation      annotation
* circle          circle
* ()              circle_short_form
* class           class
* diamond         diamond
* <>              diamond_short_form
* entity          entity
* enum            enum
* interface       interface
* @enduml
*/

public class clase {
	
	boolean confirmacion;
	
	boolean error;

	public boolean isConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
}
