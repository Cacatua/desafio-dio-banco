package com.kktua;

public class ContaCorrente extends Conta {

    private static int contaSequencial = 1;

    public void criarContaCorrente(Cliente cliente) {
        super.agencia = AGENCIA_PADRAO;
        super.numero = contaSequencial++;
        super.cliente = cliente;
    }
}
