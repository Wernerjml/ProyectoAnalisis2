package com.tienda.carrito.controller;

import com.tienda.carrito.factory.DatabasePermission;
import com.tienda.carrito.factory.PermissionFactory;
import com.tienda.carrito.strategy.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test-factory")
    public String testFactory(@RequestParam(value = "tipo", defaultValue = "LECTURA") String tipo) {
        try {
            DatabasePermission permission = PermissionFactory.obtenerPermiso(tipo);
            permission.aplicarPermiso();
            return "Patrón Factory Method ejecutado con éxito. Tipo de permiso aplicado: " + permission.getTipoPermiso();
        } catch (Exception e) {
            return "Error al aplicar el permiso: " + e.getMessage();
        }
    }

    @GetMapping("/api/test-payment")
    public String testPayment(@RequestParam(value = "metodo", defaultValue = "efectivo") String metodo, 
                              @RequestParam(value = "monto", defaultValue = "100.0") double monto) {
        PaymentContext context = new PaymentContext();
        
        switch (metodo.toLowerCase()) {
            case "efectivo":
                context.setStrategy(new CashPaymentStrategy());
                break;
            case "credito":
                context.setStrategy(new CreditCardPaymentStrategy());
                break;
            case "debito":
                context.setStrategy(new DebitCardPaymentStrategy());
                break;
            case "paypal":
                context.setStrategy(new PayPalPaymentStrategy());
                break;
            default:
                return "Método de pago no válido.";
        }
        
        boolean resultado = context.ejecutarPago(monto);
        return resultado ? "Pago procesado exitosamente usando: " + metodo : "Fallo en el pago.";
    }
}
