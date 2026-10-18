package com.tienda.carrito.service;

import com.tienda.carrito.model.Producto;
import com.tienda.carrito.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarProductos() {
        // Arrange (Preparar datos de prueba)
        Producto p1 = new Producto("Teclado Mecánico", 45.0, 15);
        Producto p2 = new Producto("Mouse Gamer", 25.0, 30);
        when(productoRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        // Act (Ejecutar el método del servicio)
        List<Producto> productos = productoService.listarProductos();

        // Assert (Verificar resultados)
        assertNotNull(productos);
        assertEquals(2, productos.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testGuardarProductoExitoso() {
        // Arrange
        Producto producto = new Producto("Monitor 24 pulgadas", 180.0, 5);
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        // Act
        Producto resultado = productoService.guardarProducto(producto);

        // Assert
        assertNotNull(resultado);
        assertEquals("Monitor 24 pulgadas", resultado.getNombre());
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void testGuardarProductoPrecioNegativoLanzaExcepcion() {
        // Arrange
        Producto productoInvalido = new Producto("Producto Defectuoso", -10.0, 5);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            productoService.guardarProducto(productoInvalido);
        });

        assertEquals("El precio del producto no puede ser negativo", exception.getMessage());
        verify(productoRepository, never()).save(any(Producto.class));
    }

    @Test
    void testBuscarPorId() {
        // Arrange
        Long id = 1L;
        Producto producto = new Producto("Laptop", 1000.0, 2);
        when(productoRepository.findById(id)).thenReturn(Optional.of(producto));

        // Act
        Optional<Producto> resultado = productoService.buscarPorId(id);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Laptop", resultado.get().getNombre());
        verify(productoRepository, times(1)).findById(id);
    }
}
