package com.tienda.carrito.strategy;

public interface PaymentStrategy {
    boolean procesarPago(double monto);
    String getNombreMetodo();
}
