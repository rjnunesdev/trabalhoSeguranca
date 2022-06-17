/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rodrigo
 */
public class Cliente {
    private static List<DadosCliente> clientesCadastrados;
    public static void iniciar(){
        
        clientesCadastrados = new ArrayList<DadosCliente>();
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("1) Cadastrar dados do cliente (logins/senhas) – essa operação simula a criação de dados no\n" +
            "browser do cliente e deve ser feito no lado do cliente. Deve ser permitido ter vários clientes\n" +
            "(Alice, Pedro, João, Maria);\n" +
            "2) Cadastrar contas de clientes no servidor (para guardar dados da autenticação do cliente);\n" +
            "3) Autenticar o cliente no servidor com token de autenticação;\n" +
            "4) Autenticar o cliente no servidor com 2º fator de autenticação;\n" +
            "5) Trocar mensagens cifradas entre cliente e servidor usando chave simétrica de sessão.\n\n" + 
            "0) SAIR");
            opcao = entrada.nextInt();
            String login = "";
            String senha = "";
            boolean cadastradoComSucesso = false;
            boolean autenticadoComSucesso = false;
            boolean mensagemTrocadaComSucesso = false;
            
            switch (opcao) {
                case 1:
                    /*
                        Cadastrar dados do cliente (logins/senhas) – essa operação simula a criação de dados no\n" +
                        "browser do cliente e deve ser feito no lado do cliente. Deve ser permitido ter vários clientes\n" +
                        "(Alice, Pedro, João, Maria)
                    */
                    System.out.println("Insira o login a ser cadastrado:");
                    login = entrada.nextLine();
                    System.out.println("Insira o senha a ser cadastrado:");
                    senha = entrada.nextLine();
                    
                    cadastradoComSucesso = cadastrarDadosClienteNoCliente(login, senha);
                    
                    if(cadastradoComSucesso){
                        System.out.printf("Cliente '\t' cadastrado com sucesso",login);
                    }
                    
                    cadastradoComSucesso = false;
                    break;
                case 2:
                    // Cadastrar contas de clientes no servidor (para guardar dados da autenticação do cliente)
                    System.out.println("Insira o login a ser cadastrado:");
                    login = entrada.nextLine();
                    System.out.println("Insira o senha a ser cadastrado:");
                    senha = entrada.nextLine();
                    
                    cadastradoComSucesso = cadastrarDadosClienteNoServidor(login, senha);
                    
                    if(cadastradoComSucesso){
                        System.out.printf("Cliente '\t' cadastrado com sucesso",login);
                    }
                    cadastradoComSucesso = false;
                    break;

                case 3:
                    // Autenticar o cliente no servidor com token de autenticação;
                    System.out.println("Insira o login a ser cadastrado:");
                    login = entrada.nextLine();
                    System.out.println("Insira o senha a ser cadastrado:");
                    senha = entrada.nextLine();
                    
                    autenticadoComSucesso = autenticarClienteNoServidorViaToken(login, senha);
                    
                    if(autenticadoComSucesso){
                        System.out.printf("Cliente '\t' autenticado com sucesso",login);
                    }
                    autenticadoComSucesso = false;
                    break;
                case 4:
                    // Autenticar o cliente no servidor com 2º fator de autenticação;
                    System.out.println("Insira o login a ser cadastrado:");
                    login = entrada.nextLine();
                    System.out.println("Insira o senha a ser cadastrado:");
                    senha = entrada.nextLine();
                    autenticadoComSucesso = autenticarClienteNoServidor2fa(login, senha);
                    if(autenticadoComSucesso){
                        System.out.printf("Cliente '\t' autenticado com sucesso",login);
                    }
                    autenticadoComSucesso = false;
                    break;
                
                case 5:
                    System.out.println("Escreva a mensagem a ser trocada:");
                    String mensagem = entrada.nextLine();
                    mensagemTrocadaComSucesso = trocarMensagemComChaveSimetricaSessao(login, senha, mensagem);
                    if(mensagemTrocadaComSucesso){
                        System.out.printf("Mensagem '\t' enviada com sucesso",mensagem);
                    }
//                    Trocar mensagens cifradas entre cliente e servidor usando chave simétrica de sessão.
//Cliente e servidor podem ser classes em uma única máquina que são instanciados no
                    mensagemTrocadaComSucesso = false;
                    break;
                case 0: 
                    System.out.println("Obrigado!!!");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
//                    throw new AssertionError();
            }
        } while (opcao != 0);
    }
    
    private static boolean verificarClienteCadastradoNoCliente(String login){
        boolean encontrado = false;
        for (Iterator<DadosCliente> iterator = clientesCadastrados.iterator(); iterator.hasNext();) {
            DadosCliente dadosCliente = iterator.next();
            encontrado = dadosCliente.getLogin().equals(login);
            if(encontrado){
                break;
            }
        }
        return encontrado;
    }

    private static boolean cadastrarDadosClienteNoCliente(String login, String senha) {
        boolean encontrado = verificarClienteCadastradoNoCliente(login);
        if(encontrado){
            return !encontrado;
        } else {
            return clientesCadastrados.add(new DadosCliente(login, senha));
        }
    }

    private static boolean cadastrarDadosClienteNoServidor(String login, String senha) {
        // TODO IMPLEMENTAR
        return true;
    }

    private static boolean autenticarClienteNoServidorViaToken(String login, String senha) {
        // TODO IMPLEMENTAR
        return true;
    }

    private static boolean autenticarClienteNoServidor2fa(String login, String senha) {// TODO IMPLEMENTAR
        return true;
    }

    private static boolean trocarMensagemComChaveSimetricaSessao(String login, String senha, String mensagem) {
        // TODO IMPLEMENTAR
        return true;
    }
}
