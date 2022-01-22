package com.kktua;

public class ContaPoupanca extends Conta {

    private static int contaSequencial = 1;

    public void criarContaPoupanca(Cliente cliente) {
        super.agencia = AGENCIA_PADRAO;
        super.numero = contaSequencial++;
        super.cliente = cliente;
    }

}
