package el_retoño;
import java.util.ArrayList;

public class CategoriaController {
    private ArrayList<Categoria> categorias;

    public CategoriaController() {
        this.categorias = new ArrayList<>();
    }

    // Crear y registrar una nueva categoría
    public Categoria CrearCategoria(String idCategoria, String tipo) {
        if (idCategoria == null || idCategoria.trim().isEmpty()) {
            System.out.println("ERROR: idCategoria inválido.");
            return null;
        }
        Categoria c = new Categoria(idCategoria, tipo);
        categorias.add(c);
        return c;
    }

    // Buscar categoría por ID (método que usan otros controllers)
    public Categoria BuscarCategoriaPorId(String idCategoria) {
        if (idCategoria == null) return null;
        for (Categoria c : categorias) {
            if (c.getIdCategoria() != null && c.getIdCategoria().equals(idCategoria)) {
                return c;
            }
        }
        return null;
    }

    // Buscar categorías por nombre parcial
    public ArrayList<Categoria> BuscarCategoriaPorNombre(String nombreParcial) {
        ArrayList<Categoria> resultado = new ArrayList<>();
        if (nombreParcial == null) return resultado;
        for (Categoria c : categorias) {
            String nombre = c.getTipo();
            if (nombre != null && nombre.toLowerCase().contains(nombreParcial.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // Listar todas las categorías
    public ArrayList<Categoria> ListarTodas() {
        return categorias;
    }

    // Agregar un producto a una categoría (usa el método de la entidad)
    public boolean AgregarProductoACategoria(String idCategoria, Producto producto) {
        Categoria c = BuscarCategoriaPorId(idCategoria);
        if (c == null || producto == null) return false;
        c.AgregarProducto(producto);
        return true;
    }

    // Obtener productos de una categoría
    public ArrayList<Producto> ObtenerProductosDeCategoria(String idCategoria) {
        Categoria c = BuscarCategoriaPorId(idCategoria);
        if (c == null) return new ArrayList<>();
        return c.getListaProductos();
    }

    // Eliminar categoría (solo si está vacía)
    public boolean EliminarCategoria(String idCategoria) {
        Categoria c = BuscarCategoriaPorId(idCategoria);
        if (c == null) return false;
        if (!c.getListaProductos().isEmpty()) {
            System.out.println("ERROR: No se puede eliminar categoría con productos.");
            return false;
        }
        return categorias.remove(c);
    }

    // Mostrar info de categoría (útil para la vista)
    public String MostrarInfo(String idCategoria) {
        Categoria c = BuscarCategoriaPorId(idCategoria);
        return (c == null) ? "Categoría no encontrada." : c.toString();
    }

    // Generar código de producto vía la categoría (wrapper)
    public String GenerarCodigoParaProducto(String idCategoria) {
        Categoria c = BuscarCategoriaPorId(idCategoria);
        if (c == null) return null;
        return c.GenerarCodigoProducto();
    }
    
}
