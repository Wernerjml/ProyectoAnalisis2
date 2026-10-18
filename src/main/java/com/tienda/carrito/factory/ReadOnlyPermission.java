package com.tienda.carrito.factory;

public class ReadOnlyPermission implements DatabasePermission {
    @Override
    public void aplicarPermiso() {
        System.out.println("Configurando base de datos en modo: SÓLO LECTURA (SELECT)");
    }

    @Override
    public String getTipoPermiso() {
        return "LECTURA";
    }
}
