package com.tienda.carrito.factory;

public class PermissionFactory {
    public static DatabasePermission obtenerPermiso(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de permiso no puede ser nulo");
        }
        switch (tipo.toUpperCase()) {
            case "LECTURA":
                return new ReadOnlyPermission();
            case "ESCRITURA":
                return new WriteOnlyPermission();
            case "LECTURA_ESCRITURA":
                return new ReadWritePermission();
            default:
                throw new IllegalArgumentException("Tipo de permiso desconocido: " + tipo);
        }
    }
}
