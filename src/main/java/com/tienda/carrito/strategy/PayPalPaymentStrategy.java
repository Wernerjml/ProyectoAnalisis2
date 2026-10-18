package com.tienda.carrito.strategy;

public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago a través de la pasarela PAYPAL por un monto de: $" + monto);
        // Lógica de conexión con API de PayPal
        return true;
    }

    @Override
    public String getNombreMetodo() {
        return "PayPal";
    }
}
