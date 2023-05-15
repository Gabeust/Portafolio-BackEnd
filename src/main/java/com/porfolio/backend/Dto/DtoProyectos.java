package com.porfolio.backend.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyectos {
     @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
     @NotBlank
    private String img;
    @NotBlank
    private String url; 

    public DtoProyectos() {
    }

    public DtoProyectos(String nombre, String descripcion, String img, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

     
}
