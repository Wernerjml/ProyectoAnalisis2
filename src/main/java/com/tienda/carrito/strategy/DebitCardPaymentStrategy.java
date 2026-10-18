package com.tienda.carrito.strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con TARJETA DE DÉBITO por un monto de: $" + monto);
        // Lógica de validación con cuenta de ahorros/débito
        return true;
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta de Débito";
    }
}
