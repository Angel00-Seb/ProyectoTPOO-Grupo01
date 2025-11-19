package el_retoño;
import java.util.ArrayList;


class Pedido {
    //Atributos
    private int idPedido;
    private String Fecha; //DATE
    private boolean Estado; //true = Finalizado, false = Pendiente
    private double Total;
    private Cliente Cliente; // Relación con Cliente (1:n)
    private Personal Personal; // Relación con Personal (1:n)
    private ArrayList<PedidoDetalle> ListaDetalles; // Relación con PedidoDetalle (1:n)
    private static int ContadorPedidos = 0; // Para generar IDs automáticamente

    //Constructores
    public Pedido() {
        this.ListaDetalles = new ArrayList<>();
    }

    public Pedido(String Fecha, Cliente Cliente, Personal Personal) {
        ContadorPedidos++;
        this.idPedido = ContadorPedidos;
        this.Fecha = Fecha;
        this.Estado = false;
        this.Total = 0.0;
        this.Cliente = Cliente;
        this.Personal = Personal;
        this.ListaDetalles = new ArrayList<>();
        // Agregar el pedido al historial del cliente
        if (Cliente != null) {
            Cliente.AgregarPedido(this);
        }
    }

    //Getters y Setters
    public int getIdPedido() {
        return idPedido;
    }

    //No hay setter para idPedido porque se genera automáticamente

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public double getTotal() {
        return Total;
    }

    //No hay setter para total porque se calcula automáticamente

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Personal getPersonal() {
        return Personal;
    }

    public void setPersonal(Personal Personal) {
        this.Personal = Personal;
    }

    public ArrayList<PedidoDetalle> getListaDetalles() {
        return ListaDetalles;
    }

    //NO hay setter para PedidoDetalle porque se maneja con agregarProducto()
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "ID_PEDIDO: " + idPedido + ", FECHA: " + Fecha + ", ESTADO: " + ObtenerEstadoTexto() + ", TOTAL: " + Total + ", CLIENTE: " + Cliente.ObtenerNombreCompleto() + "ITEAMS: " + ContarDetalles();
    }
    
    //Métodos
    public void AgregarDetalle(PedidoDetalle detalle) {
        if (detalle != null) {
            ListaDetalles.add(detalle);
            ActualizarTotal();
            System.out.println("Detalle agregado: " + detalle.getProducto().getNombre() + 
                             " x" + detalle.getCantidad());
        } else {
            System.out.println("Error: No se puede agregar un detalle nulo.");
        }
    }
    
    public boolean EliminarDetalle(int idDetalle) {
        for (PedidoDetalle detalle : ListaDetalles) {
            if (detalle.getIdDetalle() == idDetalle) {
                ListaDetalles.remove(detalle);
                ActualizarTotal();
                System.out.println("Detalle eliminado correctamente.");
                return true;
            }
        }
        System.out.println("Error: No se encontró el detalle con ID " + idDetalle);
        return false;
    }
    
    public double CalcularTotal() {
        double suma = 0;
        for (PedidoDetalle detalle : ListaDetalles) {
            suma += detalle.CalcularSubtotal();
        }
        return suma;
    }
    
    private void ActualizarTotal() {
        this.Total = CalcularTotal();
    }
    
    public void MarcarComoFinalizado() {
        this.Estado = true;
        System.out.println("Pedido #" + idPedido + " marcado como FINALIZADO.");
    }
    
    public void MarcarComoPendiente() {
        this.Estado = false;
        System.out.println("Pedido #" + idPedido + " marcado como PENDIENTE.");
    }
    
    public String ObtenerEstadoTexto() {
        return Estado ? "FINALIZADO" : "PENDIENTE";
    }
    
    public boolean TieneDetalles() {
        return !ListaDetalles.isEmpty();
    }
    
    public int ContarDetalles() {
        return ListaDetalles.size();
    }
    
    public void MostrarDetalles() {
        System.out.println("DETALLES DEL PEDIDO #" + idPedido);
        System.out.println("Fecha: " + Fecha);
        System.out.println("Cliente: " + (Cliente != null ? Cliente.ObtenerNombreCompleto() : "N/A"));
        //System.out.println("Atendido por: " + (Personal != null ? Personal.ObtenerNombreCompleto() : "N/A"));
        System.out.println("Estado: " + ObtenerEstadoTexto());
        System.out.println("-----------------------------------------------");
        
        if (ListaDetalles.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            System.out.println("PRODUCTOS:");
            for (PedidoDetalle detalle : ListaDetalles) {
                System.out.println("    " + detalle);
            }
            System.out.println("-----------------------------------------------");
            System.out.println("TOTAL: S/. " + String.format("%.2f", Total));
        }
    }
    
    public void RegistrarPedido() {
        if (TieneDetalles()) {
            System.out.println("\n¡Pedido #" + idPedido + " registrado exitosamente!");
            System.out.println("Total: S/. " + String.format("%.2f", Total));
            System.out.println("Estado: " + ObtenerEstadoTexto());
        } else {
            System.out.println("Error: No se puede registrar un pedido sin productos.");
        }
    }
}
