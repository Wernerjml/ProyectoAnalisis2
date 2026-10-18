package com.tienda.carrito.factory;

public class WriteOnlyPermission implements DatabasePermission {
    @Override
    public void aplicarPermiso() {
        System.out.println("Configurando base de datos en modo: SÓLO ESCRITURA (INSERT, UPDATE, DELETE)");
    }

    @Override
    public String getTipoPermiso() {
        return "ESCRITURA";
    }
}
