package com.tienda.carrito.strategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean ejecutarPago(double monto) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha seleccionado ningún método de pago");
        }
        return strategy.procesarPago(monto);
    }
}
