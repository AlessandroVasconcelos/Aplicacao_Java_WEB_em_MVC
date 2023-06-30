/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Proprietario {
    
    private Proprietario proprietario;
    private int id;
    private String nome;
    private String cpf;
    private Carro carro = new Carro();
   
    public Proprietario() {
    }

    public Proprietario(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.carro.setProprietarioId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Proprietario clone() {
        proprietario = new Proprietario();
        this.proprietario.setId(id);
        this.proprietario.setNome(nome);
        this.proprietario.setCpf(cpf);
        return proprietario;
    }

}
