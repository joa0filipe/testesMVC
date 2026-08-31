package model;

public class Conta {
    private int id;
    private float saldo;


    public Conta(int id) {
        this.id = id;
        this.saldo = 0;
    }

    public int getId() {
        return this.id;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void sacar(float valor){
        this.saldo = saldo - valor;
    }
    public void depositar(float valor){
        this.saldo = saldo + valor;
    }
}
