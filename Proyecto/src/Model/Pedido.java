package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private String cliente;
    private List<DetallePedido> detalles;
    private String estado; 

    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.estado = "Pendiente";
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        detalles.add(new DetallePedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (DetallePedido detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total; 
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarResumen() {
        System.out.println("\n========================================");
        System.out.println("          RESUMEN DE PEDIDO #" + idPedido);
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);
        System.out.println("----------------------------------------");
        if (detalles.isEmpty()) {
            System.out.println("No hay productos agregados.");
        } else {
            for (DetallePedido d : detalles) {
                System.out.println(d);
            }
            System.out.println("----------------------------------------");
            System.out.printf("TOTAL A PAGAR: S/ %.2f\n", calcularTotal());
        }
        System.out.println("========================================\n");
    }
}