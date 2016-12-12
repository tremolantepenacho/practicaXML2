/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaxml2;

/**
 *
 * @author hector
 */
public class Jugador {
    private String nombre;
    private int horas,puntuacion,nivel;

    public Jugador(String nombre) {
        this.nombre=nombre;
        horas=0;
        puntuacion=0;
        nivel=1;
    }

    public Jugador(String nombre, int horas, int puntuacion, int nivel) {
        this.nombre = nombre;
        this.horas = horas;
        this.puntuacion = puntuacion;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
