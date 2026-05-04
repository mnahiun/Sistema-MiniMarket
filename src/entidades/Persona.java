
package entidades;

//Clase abstracta base que representa a una persona en el sistema.
//Aplica: Abstracción, Encapsulamiento

public abstract class  Persona {
    private String nombre;
    private String cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

     // Getters y Setters (Encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    // Método abstracto que cada subclase debe implementar (Abstracción + Polimorfismo)
    public abstract void mostrarInfo();  
    
}
