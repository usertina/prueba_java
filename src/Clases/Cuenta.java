package Clases;

public class Cuenta {
    private String titular;
    private Integer tarjetaAsociada;
    private String numeroCuenta;
    private Float saldo;

    public Cuenta(String titular, Integer tarjetaAsociada, String numeroCuenta, Float saldo) {
        this.titular = titular;
        this.tarjetaAsociada = tarjetaAsociada;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void sacarDinero(Float cantidad) {
        saldo = saldo - cantidad;
    }
    public Float getSaldo(){return saldo;}
    public void ingresarDinero(Float cantidad){saldo = saldo + cantidad;}
}
