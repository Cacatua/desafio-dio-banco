package com.kktua;

public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public void sacar(double valor){
        saldo -= valor;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void extrato(){
        System.out.println("----------Extrato----------");
        System.out.printf("Cliente: %s%n", cliente.getNome());
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Conta..: %d%n", numero);
        System.out.printf("Saldo..: %2f%n", saldo);
        System.out.println("---------------------------");
    }
}
