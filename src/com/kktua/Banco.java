package com.kktua;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<ContaCorrente> listaContasCorrente = new ArrayList<>();
    private List<ContaPoupanca> listaContasPoupanca = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastrarCliente(String nome) {
        //Nao pode ter dois clientes com mesmo nome
        if (retornaCliente(nome) != null) {
            //TODO: Dar um retorno para saber que falhou o cadastro.
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        listaClientes.add(cliente);
    }

    public void criarContaCorrenCliente(String nome) {
        Cliente cliente = retornaCliente(nome);

        //Cliente ja deve ter cadastro
        if (cliente == null) {
            return;
        }

        //Caso cliente ja tenha conta corrente nao cadastramos novamente
        if (retornaContaCorrenteCliente(nome) != null) {
            return;
        }

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.criarContaCorrente(cliente);
        listaContasCorrente.add(contaCorrente);
    }

    public void depositarContaCorrente(String cliente, Double valor) {
        ContaCorrente contaCorrente = retornaContaCorrenteCliente(cliente);
        if (contaCorrente != null)
            contaCorrente.depositar(valor);
    }

    public void sacarContaCorrente(String cliente, Double valor) {
        ContaCorrente contaCorrente = retornaContaCorrenteCliente(cliente);
        if (contaCorrente != null)
            contaCorrente.sacar(valor);
    }

    public void trasferirEntreContasCorrentes(String clienteOrigem, String clienteDestino, double valor) {
        ContaCorrente contaCorrenteOrigem = retornaContaCorrenteCliente(clienteOrigem);
        ContaCorrente contaCorrenteDestino = retornaContaCorrenteCliente(clienteDestino);

        if (contaCorrenteOrigem == null || contaCorrenteDestino == null)
            return;

        contaCorrenteOrigem.sacar(valor);
        contaCorrenteDestino.depositar(valor);

    }

    public void criarContaPoupancaCliente(String cliente_teste) {
        Cliente cliente = retornaCliente(nome);

        //Cliente ja deve ter cadastro
        if (cliente == null) {
            return;
        }

        //Caso cliente ja tenha conta corrente nao cadastramos novamente
        if (retornaContaPoupancaCliente(nome) != null) {
            return;
        }

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.criarContaPoupanca(cliente);
        listaContasPoupanca.add(contaPoupanca);
    }

    public void extratoCliente(String cliente) {
        ContaCorrente contaCorrente = retornaContaCorrenteCliente(cliente);
        if (contaCorrente != null)
            contaCorrente.extrato();

        ContaPoupanca contaPoupanca = retornaContaPoupancaCliente(cliente);
        if (contaPoupanca != null)
            contaPoupanca.extrato();
    }

    public void listarClientes() {
        System.out.println("-----Lista de clientes-----");
        for (Cliente cliente : listaClientes) {
            System.out.printf("Cliente: %s%n", cliente.getNome());
        }
        System.out.println("---------------------------");
    }

    public void listarContas() {
        System.out.println("-Lista de Contas Poupanca--");
        for (ContaPoupanca conta : listaContasPoupanca) {
            System.out.printf("Agencia: %d Conta: %d Cliente: %s%n", conta.agencia, conta.numero, conta.cliente.getNome());
        }
        System.out.println("---------------------------");

        System.out.println("-Lista de Contas Corrente--");
        for (ContaCorrente conta : listaContasCorrente) {
            System.out.printf("Agencia: %d Conta: %d Cliente: %s%n", conta.agencia, conta.numero, conta.cliente.getNome());
        }
        System.out.println("---------------------------");
    }

    private Cliente retornaCliente(String nome) {
        //Foi utilizado uma busca lenta por ser apenas um exemplo.
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().equals(nome))
                return cliente;
        }
        return null;
    }

    private ContaCorrente retornaContaCorrenteCliente(String nome) {
        //Foi utilizado uma busca lenta por ser apenas um exemplo.
        for (ContaCorrente conta : listaContasCorrente) {
            if (conta.cliente.getNome().equals(nome))
                return conta;
        }
        return null;
    }

    private ContaPoupanca retornaContaPoupancaCliente(String nome) {
        //Foi utilizado uma busca lenta por ser apenas um exemplo.
        for (ContaPoupanca conta : listaContasPoupanca) {
            if (conta.cliente.getNome().equals(nome))
                return conta;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaContasCorrentes=" + listaContasCorrente +
                ", listaContasPoupanca=" + listaContasPoupanca +
                '}';
    }

}
