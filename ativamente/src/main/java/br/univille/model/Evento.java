package br.univille.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String local;
    private int data;
    private String descricao;
    private int hora;
    private String status;
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
    public int getdata() {
        return data;
    }
    public void setdata(int data) {
        this.data = data;
    }
    public int gethora() {
        return hora;
    }
    public void sethora(int hora) {
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
    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }
    
}