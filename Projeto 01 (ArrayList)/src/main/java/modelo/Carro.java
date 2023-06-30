/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Carro {

    private Carro carro;
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int proprietarioId;
        
    public Carro() {
    }

    public Carro(int id, String placa, String marca, String modelo, int proprietarioId) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.proprietarioId = proprietarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public Carro clone() {
        carro = new Carro();
        this.carro.setId(id);
        this.carro.setPlaca(placa);
        this.carro.setMarca(marca);
        this.carro.setModelo(modelo);
        this.carro.setProprietarioId(proprietarioId);
        return carro;
    }

}
