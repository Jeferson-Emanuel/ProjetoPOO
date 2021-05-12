package br.upe.ProjetoPOO.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartamento")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String bloco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apt")
    List<Morador> morador;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apartamento")
    Veiculo veiculo;

    //Contrutores
    public Apartamento() {
    }
    //Construtor
    public Apartamento(String bloco) {
        this.bloco = bloco;
    }

    //Gets & Sets
    public int getId() {
        return id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    //Override método toString padrão da classe
    @Override
    public String toString() {
        return "Apartamento " + bloco;
    }
}
