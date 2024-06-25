/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author Milton Rodriguez
 */
public class Pedido {
    public String nombre;
    public String tipo;  //Analgesico,Anestesico,Antibiotico,Anticolinergico,Antipiretico
    public int cantidad;
    public String distribuidor;
    public String sucursal;

    public Pedido() {
    }

    public Pedido(String nombre, String tipo, int cantidad, String distribuidor, String sucursal) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.distribuidor = distribuidor;
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + ", distribuidor=" + distribuidor + ", sucursal=" + sucursal + "}\n";
    }
    
    
    
    
    
}
