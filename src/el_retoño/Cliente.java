package el_retoño;
import java.util.ArrayList;


abstract class Cliente extends Persona{
    //Atributos
    private int idCliente;
    private String Direccion;
    private String Telefono;
    private String Email;
    private ArrayList<Pedido> HistorialPedidos;
    private static int ContadorClientes = 0; //Para generar IDs automáticamente

    //Constructores
    public Cliente() {
        super();
        this.HistorialPedidos = new ArrayList<>();
    }

    public Cliente(String Apellidos, String Nombres, String FechaNacimiento, String TipoDoc, String NumDoc, String Sexo, String Direccion, String Telefono, String Email) {
        super(Apellidos, Nombres, FechaNacimiento, TipoDoc, NumDoc, Sexo);
        ContadorClientes++;
        this.idCliente = ContadorClientes;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        this.HistorialPedidos = new ArrayList<>();
    }

    //Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    //No hay setter para idCliente porque se genera automáticamente

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public ArrayList<Pedido> getHistorialPedidos() {
        return HistorialPedidos;
    }
    //NO hay setter para HistorialPedidos porque se maneja con agregarProducto()
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return super.toString() +
               "\n   ID Cliente: " + idCliente +
               "\n   Dirección: " + Direccion +
               "\n   Teléfono: " + Telefono +
               "\n   Email: " + Email +
               "\n   Total pedidos: " + ContarPedidos();
    }
    
    //Métodos    
    public void ActualizarDatos(String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        this.Direccion = nuevaDireccion;
        this.Telefono = nuevoTelefono;
        this.Email = nuevoEmail;
        System.out.println("Datos del cliente actualizados correctamente.");
    }
    
    public void AgregarPedido(Pedido pedido) {
        if (pedido != null) {
            HistorialPedidos.add(pedido);
            System.out.println("Pedido agregado al historial del cliente " + idCliente);
        }
    }
    
    public void MostrarHistorialPedidos() {
        System.out.println("\nHISTORIAL DE PEDIDOS - Cliente ID: " + idCliente);
        System.out.println("Cliente: " + ObtenerNombreCompleto());
        
        if (HistorialPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados para este cliente.");
        } else {
            for (Pedido pedido : HistorialPedidos) {
                System.out.println("    " + pedido);
            }
            System.out.println("-----------------------------------------------");
            System.out.println("Total de pedidos: " + ContarPedidos());
            System.out.println("Total gastado: S/." + String.format("%.2f", CalcularTotalGastado()));
        }
    }
    
    public int ContarPedidos() {
        return HistorialPedidos.size();
    }
    
    public double CalcularTotalGastado() {
        double total = 0;
        for (Pedido pedido : HistorialPedidos) {
            total += pedido.getTotal();
        }
        return total;
    }
    
    public boolean EsClienteFrecuente() {
        return ContarPedidos() >= 5;
    }
}
