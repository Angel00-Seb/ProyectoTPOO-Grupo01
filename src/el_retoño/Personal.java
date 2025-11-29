package el_retoño;
import java.util.ArrayList;


class Personal extends Persona {
    //Atributos
    private int idPersonal;
    private String Contrasena;
    private Puesto Puesto; //Relación con Puesto (1:1)
    private Personal Supervisor; // Relación "A Cargo" (auto-referencia)
    private ArrayList<Pedido> PedidosAtendidos; //Historial de pedidos atendidos
    private static int ContadorPersonal = 0; //Para generar IDs automáticamente

    //Constructores
    public Personal() {
        super();
        this.PedidosAtendidos = new ArrayList<>();
    }

    public Personal(String Apellidos, String Nombres, String FechaNacimiento, String TipoDoc, String NumDoc, String Sexo, String Contrasena, Puesto Puesto) {
        super(Apellidos, Nombres, FechaNacimiento, TipoDoc, NumDoc, Sexo);
        ContadorPersonal++;
        this.idPersonal = ContadorPersonal;
        this.Contrasena = Contrasena;
        this.Puesto = Puesto;
        this.Supervisor = null;
        this.PedidosAtendidos = new ArrayList<>();
    }

    public Personal(String Apellidos, String Nombres, String FechaNacimiento, String TipoDoc, String NumDoc, String Sexo, String Contrasena, Puesto Puesto, Personal Supervisor) {
        super(Apellidos, Nombres, FechaNacimiento, TipoDoc, NumDoc, Sexo);
        ContadorPersonal++;
        this.idPersonal = ContadorPersonal;
        this.Contrasena = Contrasena;
        this.Puesto = Puesto;
        this.Supervisor = Supervisor;
        this.PedidosAtendidos = new ArrayList<>();
    }
    
    
    //Getters y Setters
    public int getIdPersonal() {
        return idPersonal;
    }

    //No hay setter para idPersonal porque se genera automáticamente  

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Puesto getPuesto() {
        return Puesto;
    }

    public void setPuesto(Puesto Puesto) {
        this.Puesto = Puesto;
    }

    public Personal getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(Personal Supervisor) {
        this.Supervisor = Supervisor;
    }
    
    public ArrayList<Pedido> getPedidosAtendidos() {
        return PedidosAtendidos;
    }
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "\n[PERSONAL #" + idPersonal + "]" +
               super.toString() +
               (Puesto != null ? Puesto : "") +
               "\n   Supervisor: " + (Supervisor != null ? Supervisor.ObtenerNombreCompleto() : "Ninguno") +
               "\n   Pedidos atendidos: " + ContarPedidosAtendidos();
    }
    
    //Métodos
    public boolean IniciarSesion(String numDoc, String contrasena) {
        if (this.getNumDoc().equals(numDoc) && this.Contrasena.equals(contrasena)) {
            System.out.println("¡Bienvenido/a " + ObtenerNombreCompleto() + "!");
            System.out.println("Puesto: " + (Puesto != null ? Puesto.getNombre() : "Sin asignar"));
            System.out.println("Documento: " + ObtenerDocumentoCompleto());
            return true;
        }
        System.out.println("Error: Número de documento o contraseña incorrectos.");
        return false;
    }

    public void AtenderPedido(Pedido pedido) {
        if (pedido != null) {
            PedidosAtendidos.add(pedido);
            pedido.setPersonal(this);
            System.out.println(ObtenerNombreCompleto() 
                + " atendió el pedido #" + pedido.getIdPedido());
        }
    }

    public void MostrarPedidosAtendidos() {
        System.out.println("\nPEDIDOS ATENDIDOS POR: " + ObtenerNombreCompleto());
        if (PedidosAtendidos.isEmpty()) {
            System.out.println("No ha atendido ningún pedido aún.");
            return;
        }
        double totalVendido = 0;
        for (Pedido pedido : PedidosAtendidos) {
            System.out.println("    " + pedido);
            totalVendido += pedido.getTotal();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total pedidos: " + PedidosAtendidos.size());
        System.out.println("Total vendido: S/." + String.format("%.2f", totalVendido));
    }

    public int ContarPedidosAtendidos() {
        return PedidosAtendidos.size();
    }

    public double CalcularTotalVendido() {
        double total = 0;
        for (Pedido pedido : PedidosAtendidos) {
            total += pedido.getTotal();
        }
        return total;
    }

    public String ObtenerRol() {
        return Puesto != null ? Puesto.getNombre() : "Sin puesto asignado";
    }

    public boolean TieneSupervisor() {
        return Supervisor != null;
    }

    public boolean CambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (this.Contrasena.equals(contrasenaActual)) {
            this.Contrasena = nuevaContrasena;
            System.out.println("Contraseña cambiada exitosamente.");
            return true;
        }
        System.out.println("Error: La contraseña actual es incorrecta.");
        return false;
    }

    @Override
    public void Registrar() {
        System.out.println("\nPERSONAL REGISTRADO EXITOSAMENTE");
        System.out.println("ID: " + idPersonal);
        System.out.println(this);
    }
    
}
