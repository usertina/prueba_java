package Clases;

import java.time.LocalDate;

public class Comun extends Persona {

    public Comun(String nombre, String apellido, LocalDate fechaNacimiento, String dni, Tarjeta tarjeta) {
        super(nombre, apellido, fechaNacimiento, dni, tarjeta);
    }

    @Override
    public void donar() {
    }
}

