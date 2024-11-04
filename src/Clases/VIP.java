package Clases;

import java.time.LocalDate;

public class VIP extends Persona{

    public VIP(String nombre, String apellido, LocalDate fechaNacimiento, String dni, Tarjeta tarjeta) {
        super(nombre, apellido, fechaNacimiento, dni, tarjeta);
    }

    @Override
    public void donar() {}
}
