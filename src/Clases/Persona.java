package Clases;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String dni;
    private Tarjeta miTarjeta;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String dni, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.miTarjeta = tarjeta;
    }

    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }

    public Boolean esMiDNI(String dni){
        return this.dni.equals(dni);
    }

    public Tarjeta getMiTarjeta() {
        return this.miTarjeta;
    }

    public abstract void donar();
}
