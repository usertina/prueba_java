package Clases;

import java.time.LocalDate;

public class Tarjeta {
    private String nombreTitular;
    private String apellidoTitular;
    private LocalDate fechaCaducidad;
    private Integer numeroTarjeta;
    private Integer pin;
    private Cuenta cuenta;

    public Tarjeta(String nombreTitular, String apellidoTitular, LocalDate fechaCaducidad, Integer numeroTarjeta, Integer pin, Cuenta cuenta) {
        this.nombreTitular = nombreTitular;
        this.apellidoTitular = apellidoTitular;
        this.fechaCaducidad = fechaCaducidad;
        this.numeroTarjeta = numeroTarjeta;
        this.pin = pin;
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public Boolean esMiPin(Integer pin) {
        if (this.pin.equals(pin)) {
            return true;
        } else {
            return false;
        }
    }
}
