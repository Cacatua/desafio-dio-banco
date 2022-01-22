package com.kktua;

public class Main {

    public static void main(String[] args) {
        String cliente = "Cliente Teste";
        String cliente2 = "Cliente Teste2";

        Banco banco = new Banco();
        banco.setNome(cliente);

        //Criando cliente 1
        banco.cadastrarCliente(cliente);
        banco.criarContaCorrenCliente(cliente);
        banco.depositarContaCorrente(cliente, 10.00);
        banco.extratoCliente(cliente);
        banco.sacarContaCorrente(cliente, 5.25);
        banco.extratoCliente(cliente);

        //Criando cliente 2
        banco.cadastrarCliente(cliente2);
        banco.criarContaCorrenCliente(cliente2);
        banco.extratoCliente(cliente2);

        //Teste transferencia entre contas
        banco.trasferirEntreContasCorrentes(cliente, cliente2, 2.00);

        banco.extratoCliente(cliente);
        banco.extratoCliente(cliente2);

        //Listando Clientes
        banco.listarClientes();

        //Listando Contas
        banco.listarContas();

    }
}
