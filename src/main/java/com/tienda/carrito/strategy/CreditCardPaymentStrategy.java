package com.tienda.carrito.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con TARJETA DE CRÉDITO por un monto de: $" + monto);
        // Lógica de validación con banco de crédito
        return true;
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta de Crédito";
    }
}
