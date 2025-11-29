package el_retoño;
import java.util.ArrayList;

public class ProductoController {
   // Lista central de productos
    private ArrayList<Producto> productos;

    // Controlador de categorías para validar y buscar
    private CategoriaController categoriaController;

    // CONSTRUCTOR
    public ProductoController(CategoriaController categoriaController) {
        this.categoriaController = categoriaController;
        this.productos = new ArrayList<>();
    }

    // CRUD
    public Producto CrearProducto(String nombre, double precio, String estado, int stock, String idCategoria) {

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("ERROR: El nombre no puede ser vacío.");
            return null;
        }
        if (precio < 0) {
            System.out.println("ERROR: El precio no puede ser negativo.");
            return null;
        }
        if (stock < 0) {
            System.out.println("ERROR: El stock no puede ser negativo.");
            return null;
        }

        Categoria categoria = categoriaController.BuscarCategoriaPorId(idCategoria);
        if (categoria == null) {
            System.out.println("ERROR: No existe la categoría con ID " + idCategoria);
            return null;
        }

        Producto nuevo = new Producto(nombre, precio, estado, stock, categoria);
        productos.add(nuevo);
        return nuevo;
    }

    public Producto BuscarPorId(String idProducto) {
        for (Producto p : productos) {
            if (p.getIdProducto().equals(idProducto)) {
                return p;
            }
        }
        return null;
    }

    public boolean EliminarProducto(String idProducto) {
        Producto p = BuscarPorId(idProducto);
        return p != null && productos.remove(p);
    }

    // OPERACIONES
    public boolean ActualizarPrecio(String idProducto, double nuevoPrecio) {
        Producto p = BuscarPorId(idProducto);
        if (p == null) return false;

        p.ActualizarPrecio(nuevoPrecio);
        return true;
    }

    public boolean CambiarEstado(String idProducto, String nuevoEstado) {
        Producto p = BuscarPorId(idProducto);
        if (p == null) return false;

        p.CambiarEstado(nuevoEstado);
        return true;
    }

    public boolean AumentarStock(String idProducto, int cantidad) {
        Producto p = BuscarPorId(idProducto);
        if (p == null) return false;

        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad debe ser mayor a 0.");
            return false;
        }

        p.AumentarStock(cantidad);
        return true;
    }

    public boolean ReducirStock(String idProducto, int cantidad) {
        Producto p = BuscarPorId(idProducto);
        if (p == null) return false;

        if (cantidad <= 0) {
            System.out.println("ERROR: La cantidad debe ser mayor a 0.");
            return false;
        }

        return p.ReducirStock(cantidad);
    }

    // LISTADOS
    public ArrayList<Producto> BuscarPorNombre(String nombreParcial) {
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombreParcial.toLowerCase())) {
                lista.add(p);
            }
        }
        return lista;
    }

    public ArrayList<Producto> ListarTodos() {
        return productos;
    }

    public ArrayList<Producto> ListarPorCategoria(String idCategoria) {
        ArrayList<Producto> lista = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getCategoria().getIdCategoria().equals(idCategoria)) {
                lista.add(p);
            }
        }

        return lista;
    }
    
}
