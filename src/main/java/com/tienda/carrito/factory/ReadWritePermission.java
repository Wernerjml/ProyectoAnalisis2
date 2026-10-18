package com.tienda.carrito.factory;

public class ReadWritePermission implements DatabasePermission {
    @Override
    public void aplicarPermiso() {
        System.out.println("Configurando base de datos en modo: LECTURA Y ESCRITURA (Acceso Total)");
    }

    @Override
    public String getTipoPermiso() {
        return "LECTURA_ESCRITURA";
    }
}
