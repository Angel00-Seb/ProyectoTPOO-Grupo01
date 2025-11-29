package el_retoño;
import java.util.ArrayList;

public class ClienteController {
    private ArrayList<Cliente> clientes;

    public ClienteController() {
        clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    //Agregar un cliente al sistema
    public void registrarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
            System.out.println("Cliente registrado correctamente: " +
                               cliente.getIdCliente() + " - " + cliente.ObtenerNombreCompleto());
        }
    }

    //Buscar cliente por ID
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    //Buscar cliente por número de documento
    public Cliente buscarPorDocumento(String numDoc) {
        for (Cliente c : clientes) {
            if (c.getNumDoc().equals(numDoc)) {
                return c;
            }
        }
        return null;
    }

    //Buscar por nombre o apellido
    public ArrayList<Cliente> buscarPorNombre(String nombre) {
        ArrayList<Cliente> encontrados = new ArrayList<>();

        for (Cliente c : clientes) {
            if (c.ObtenerNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    //Actualizar datos de un cliente
    public boolean actualizarDatos(int idCliente, String nuevaDireccion,
                                   String nuevoTelefono, String nuevoEmail) {

        Cliente cliente = buscarPorId(idCliente);

        if (cliente == null) {
            System.out.println("No se encontró el cliente con ID: " + idCliente);
            return false;
        }

        cliente.ActualizarDatos(nuevaDireccion, nuevoTelefono, nuevoEmail);
        return true;
    }

    //Agregar pedido a un cliente
    public void registrarPedidoParaCliente(int idCliente, Pedido pedido) {
        Cliente cliente = buscarPorId(idCliente);

        if (cliente != null) {
            cliente.AgregarPedido(pedido);
        } else {
            System.out.println("No se pudo agregar pedido. Cliente no encontrado.");
        }
    }

    //Mostrar todos los clientes
    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún.");
            return;
        }

        System.out.println("\n======= LISTA DE CLIENTES REGISTRADOS =======");
        for (Cliente c : clientes) {
            System.out.println(c);
            System.out.println("----------------------------------------");
        }
    }
}
