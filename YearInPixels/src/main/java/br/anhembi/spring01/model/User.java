package br.anhembi.spring01.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dados")
public class User {

    @Id
    private int id;
    private int humor;
    private String data;
    private String texto;
    
    public User(int id, int humor, String data, String texto) {
        this.id = id;
        this.humor = humor;
        this.data = data;
        this.texto = texto;
    }
    
    public User() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getHumor() {
        return humor;
    }
    public void setHumor(int humor) {
        this.humor = humor;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    

}