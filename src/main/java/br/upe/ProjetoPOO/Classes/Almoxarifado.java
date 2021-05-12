package br.upe.ProjetoPOO.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "almoxarifado")
public class Almoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String data;

    private String tipo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Produto> fluxoProdutos;

    //Construtores
    public Almoxarifado() {
    }

    public Almoxarifado(String tipo, String data, List<Produto> fluxoProdutos) {
    }

    //Gets & Sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getFluxoProdutos() {
        return fluxoProdutos;
    }

    public void setFluxoProdutos(List<Produto> fluxoProdutos) {
        this.fluxoProdutos = fluxoProdutos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}