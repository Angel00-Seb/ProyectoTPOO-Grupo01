package el_retoño;
import java.util.ArrayList;

public class PuestoController {
    private ArrayList<Puesto> puestos;

    //Constructor
    public PuestoController() {
        puestos = new ArrayList<>();
    }

    //CRUD
    public void AgregarPuesto(Puesto p) {
        puestos.add(p);
    }

    public boolean EliminarPuesto(int idPuesto) {
        Puesto p = BuscarPorId(idPuesto);
        if (p != null) {
            puestos.remove(p);
            return true;
        }
        return false;
    }

    public boolean ActualizarPuesto(int idPuesto, String nuevoNombre, double nuevoSueldo, String nuevaDescripcion) {
        Puesto p = BuscarPorId(idPuesto);
        if (p == null) return false;

        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty())
            p.setNombre(nuevoNombre);

        if (nuevoSueldo > 0)
            p.setSueldo(nuevoSueldo);

        if (nuevaDescripcion != null)
            p.setDescripcion(nuevaDescripcion);

        return true;
    }

    //Métodos de búsqueda
    public Puesto BuscarPorId(int id) {
        for (Puesto p : puestos) {
            if (p.getIdPuesto() == id)
                return p;
        }
        return null;
    }

    public Puesto BuscarPorNombre(String nombre) {
        for (Puesto p : puestos) {
            if (p.getNombre().equalsIgnoreCase(nombre))
                return p;
        }
        return null;
    }

    //Listado de puestos
    public void MostrarPuestos() {
        if (puestos.isEmpty()) {
            System.out.println("No hay puestos registrados.");
            return;
        }

        for (Puesto p : puestos) {
            System.out.println(p);
        }
    }

    public ArrayList<Puesto> getListaPuestos() {
        return puestos;
    }
    
}
