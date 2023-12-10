package com.tub.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cartao")
public class Cartao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    private Boolean valido;

    @OneToOne(mappedBy = "cartao")
    private Conta contaAssociada;

    public Cartao() {
    }

    public Cartao(Boolean valido) {
        this.valido = valido;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public Conta getContaAssociada() {
        return contaAssociada;
    }

    public void setContaAssociada(Conta contaAssociada) {
        this.contaAssociada = contaAssociada;
    }
}
