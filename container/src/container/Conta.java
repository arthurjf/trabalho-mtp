/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author filip
 */
class Conta {
    private String Login;
    private String Senha;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    } 

    void setLogin(JTextField jNome) {
        this.Login = Login;
    }

    void setSenha(JPasswordField jSenha) {
        this.Senha = Senha;
    }
    }
