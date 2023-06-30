/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mamat
 */
@Entity
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id"),
    @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carro.findByMarca", query = "SELECT c FROM Carro c WHERE c.marca = :marca"),
    @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "Carro.findByProprietarioId", query = "SELECT c FROM Carro c WHERE c.proprietarioId = :proprietarioId")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "proprietarioId", referencedColumnName = "id")
    @ManyToOne
    private Proprietario proprietarioId;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String placa, String marca, String modelo, Proprietario proprietarioId) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.proprietarioId = proprietarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Proprietario getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Proprietario proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Carro[ id=" + id + " ]";
    }
    
}
