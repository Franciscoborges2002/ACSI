package com.tub.models;


import jakarta.persistence.*;


@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id", referencedColumnName = "ID")
    private Cartao cartao;

    private Integer pontos;

    public Conta() {
    }

    public Conta(String name, Integer pontos) {
        this.name = name;
        this.pontos = pontos;
    }

    public Conta(String name, Cartao cartao, Integer pontos) {
        this.name = name;
        this.cartao = cartao;
        this.pontos = pontos;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
