package el_retoño;
import java.util.ArrayList;

public class PedidoController {
    private ArrayList<Pedido> listaPedidos;

    public PedidoController() {
        listaPedidos = new ArrayList<>();
    }

    // CRUD
    public Pedido CrearPedido(String fecha, Cliente cliente, Personal personal) {
        Pedido nuevo = new Pedido(fecha, cliente, personal);
        listaPedidos.add(nuevo);
        return nuevo;
    }

    public boolean EliminarPedido(int id) {
        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() == id) {
                listaPedidos.remove(p);
                return true;
            }
        }
        return false;
    }

    public Pedido BuscarPedido(int id) {
        for (Pedido p : listaPedidos) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Pedido> ObtenerPedidos() {
        return listaPedidos;
    }

    public void MostrarTodos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido p : listaPedidos) {
                System.out.println(p);
            }
        }
    }
    
}
