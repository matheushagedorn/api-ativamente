package br.univille.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String local;
    private LocalDate data;
    private String descricao;
    private LocalTime hora;
    private Boolean status;
    private int valor;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getlocal() {
        return local;
    }
    public void setlocal(String local) {
        this.local = local;
    
    }
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalTime gethora() {
        return hora;
    }
    public void sethora(LocalTime hora) {
        this.hora = hora;
    }

    public String getdescricao() {
        return descricao;
    }
    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getvalor() {
        return valor;
    }
    public void setvalor(int valor) {
        this.valor = valor;        
    }
    public Boolean getstatus() {
        return status;
    }
    public void setstatus(Boolean status) {
        this.status = status;
    }
    
}