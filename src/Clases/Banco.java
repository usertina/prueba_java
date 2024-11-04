package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Persona> lClientes;
    private List<Tarjeta> lTarjetas;
    private List<Cuenta> lCuenta;

    private static Banco miBanco; // Patrón Singleton

    private Banco() {
        // Inicializamos las listas
        this.lClientes = new ArrayList<Persona>();
        this.lTarjetas = new ArrayList<Tarjeta>();
        this.lCuenta = new ArrayList<Cuenta>();

        //Creamos las cuentas
        Cuenta cuentaNueva = new Cuenta("Andoni", 123456789, "ES001", 100F);

        // Creamos las tarjetas
        Tarjeta tarjetaNueva = new Tarjeta("Andoni", "Irizar", LocalDate.of(2025, 9, 25), 123456789, 1234, cuentaNueva);

        // Creanos los clientes
        Persona nuevoCliente = new Comun("Andoni", "Irizar", LocalDate.of(2000, 1, 16), "55337038G", tarjetaNueva);

        // Añadimos los datos a las listas
        this.lClientes.add(nuevoCliente);
        this.lTarjetas.add(tarjetaNueva);
        this.lCuenta.add(cuentaNueva);
    }

    public static Banco getMiBanco() { // Patrón Singleton
        if (miBanco == null) { //Sólo si no existe ya un banco
            miBanco = new Banco(); // Se crea
        }
        return miBanco;
    }

    public Persona buscarCliente(String nombre) {
        for (Persona cliente : lClientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public Float getSaldoCliente(Persona persona) {
        return persona.getMiTarjeta().getCuenta().getSaldo();
    }

    public Boolean sacarDinero(Persona persona, Float cantidad, Integer pin) {
        if (persona.getMiTarjeta().esMiPin(pin)) { // Comprobamos que los PIN's coincidan
            if (getSaldoCliente(persona) >= cantidad && cantidad > 0) { // Nos aseguramos de que el cliente pueda sacar el dinero y que no sea una cantidad negativa
                float comision=0; // Calculamos la comisión
                if(persona instanceof VIP){ // Si es VIP es de un 2%
                    comision = (float) 0.02;
                }else {
                    comision = (float) 0.05; // Si es Común es de un 5%
                }
                persona.getMiTarjeta().getCuenta().sacarDinero(cantidad + cantidad * comision);
                return true;
            }
        }
        return false; // Si no se cumplen los dos requisitos de arriba llegará a este return
    }

    public Boolean ingresarDinero(Persona persona, Float cantidad, Integer pin) {
        if (persona.getMiTarjeta().esMiPin(pin)) { // Comprobamos que los PIN's coincidan
            if (cantidad > 0) { // Nos aseguramos de que no sea una cantidad negativa
                float comision=0; // Calculamos la comisión
                if(persona instanceof VIP){ // Si es VIP es de un 2%
                    comision = (float) 0.02;
                }else {
                    comision = (float) 0.05; // Si es Común es de un 5%
                }
                persona.getMiTarjeta().getCuenta().ingresarDinero(cantidad - cantidad * comision);
                return true;
            }
        }
        return false; // Si no se cumplen los dos requisitos de arriba llegará a este return
    }

}

