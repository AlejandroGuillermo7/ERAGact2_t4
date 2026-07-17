package com.enriquez.act1t4.models.dto;


public class CamionetaDTO{
    private int id;
    private String marca, modelo, categoria;
    private int anio;
    private double precio;

    public CamionetaDTO(int anio, String categoria, int id, String marca, String modelo, double precio) {
        this.anio = anio;
        this.categoria = categoria;
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }


    public CamionetaDTO(){
        
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}