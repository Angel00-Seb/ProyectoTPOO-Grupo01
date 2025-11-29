package el_retoño;
import java.util.ArrayList;

public class PersonalController {
    private ArrayList<Personal> listaPersonal;

    public PersonalController() {
        listaPersonal = new ArrayList<>();
    }

    //CRUD BÁSICO
    public void agregarPersonal(Personal p) {
        if (p != null) {
            listaPersonal.add(p);
        }
    }

    public Personal buscarPorId(int id) {
        for (Personal p : listaPersonal) {
            if (p.getIdPersonal() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Personal> obtenerTodos() {
        return listaPersonal;
    }

    public void mostrarTodo() {
        if (listaPersonal.isEmpty()) {
            System.out.println("No hay personal registrado.");
            return;
        }

        System.out.println("\n=== LISTA DE PERSONAL ===");
        for (Personal p : listaPersonal) {
            System.out.println(p);
        }
    }

    //FUNCIONES ESPECIALES
    public boolean asignarSupervisor(int idEmpleado, int idSupervisor) {
        Personal empleado = buscarPorId(idEmpleado);
        Personal supervisor = buscarPorId(idSupervisor);
        if (empleado == null || supervisor == null) {
            return false;
        }
        empleado.setSupervisor(supervisor);
        return true;
    }

    public boolean iniciarSesion(String numDoc, String contrasena) {
        for (Personal p : listaPersonal) {
            if (p.IniciarSesion(numDoc, contrasena)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarPedidoAtendido(int idPersonal, Pedido pedido) {
        Personal p = buscarPorId(idPersonal);
        if (p == null || pedido == null) {
            return false;
        }
        p.AtenderPedido(pedido);
        return true;
    }
    
}
