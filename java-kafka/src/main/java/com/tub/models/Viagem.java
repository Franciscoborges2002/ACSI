package com.tub.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "viagem")
public class Viagem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    private Date data;
    private int pontos;
    //private Autocarro autocarro;

    public Viagem() {
    }
}
