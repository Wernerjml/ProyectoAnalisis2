package com.tienda.carrito.strategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago en EFECTIVO por un monto de: $" + monto);
        // Lógica adicional de efectivo (ej. calcular cambio)
        return true;
    }

    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}
