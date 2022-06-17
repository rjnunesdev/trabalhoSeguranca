/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho;

/**
 *
 * @author rodrigo
 */
public class DadosClienteAutenticados extends DadosCliente{
    private String login;
    private String senha;
    private String auth;

    public DadosClienteAutenticados(String login, String senha){
        super(login, senha);
    } 
    
    /**
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }
    
}
