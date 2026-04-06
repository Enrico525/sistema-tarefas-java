/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author enric
 */
public class Log {   private int id;
    private String acao;
    private String data;
    private Usuario usuario;

    public Log(int id, String acao, String data, Usuario usuario) {
        this.id = id;
        this.acao = acao;
        this.data = data;
        this.usuario = usuario;
    }

    public void registrarAcao() {
        System.out.println("LOG: " + acao + " | Data: " + data + " | Usuário: " + usuario.getNome());
    }
    
}
