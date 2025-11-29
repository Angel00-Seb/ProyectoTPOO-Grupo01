package el_retoño;
import java.util.ArrayList;


class Categoria {
    //Atributos
    private String idCategoria;
    private String Tipo;
    private int ContadorProductos; //Para generar códigos de productos
    private ArrayList<Producto> ListaProductos;

    //Constructores
    public Categoria() {
        this.ContadorProductos = 0;
        this.ListaProductos = new ArrayList<>();
    }

    public Categoria(String idCategoria, String Tipo) {
        this.idCategoria = idCategoria;
        this.Tipo = Tipo;
        this.ContadorProductos = 0;
        this.ListaProductos = new ArrayList<>();
    }

    //Getters y Setters
    public String getIdCategoria() {
        return idCategoria;
    }
    
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getContadorProductos() {
        return ContadorProductos;
    }
    
    //NO hay setter para contadorProductos(encapsulamiento)
    
    public ArrayList<Producto> getListaProductos() {
        return new ArrayList<>(ListaProductos);
    }

    //NO hay setter para ListaProductos porque se maneja con agregarProducto()
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "'CATEGORIA'\n\tID CATEGORIA: " + idCategoria + "\n\tTIPO: " + Tipo;
    }
    
    //Métodos
    public String GenerarCodigoProducto() {
        ContadorProductos++;
        return String.format("%s%03d", idCategoria, ContadorProductos);
    }
    
    public void AgregarProducto(Producto producto) {
        if (producto != null) {
            ListaProductos.add(producto);
        }
    }

    public boolean EliminarProducto(String idProducto) {
        for (Producto p : ListaProductos) {
            if (p.getIdProducto().equals(idProducto)) {
                ListaProductos.remove(p);
                return true;
            }
        }
        return false;
    }

    public Producto BuscarProducto(String idProducto) {
        for (Producto p : ListaProductos) {
            if (p.getIdProducto().equals(idProducto)) {
                return p;
            }
        }
        return null;
    }

    public int ContarProductos() {
        return ListaProductos.size();
    }

    public void MostrarProductos() {
        System.out.println("PRODUCTOS DE LA CATEGORIA: " + Tipo);
        if (ListaProductos.isEmpty()) {
            System.out.println("  No hay productos registrados.");
            return;
        }

        for (Producto p : ListaProductos) {
            System.out.println("  " + p.getIdProducto() + " - " + p.getNombre());
        }
    }
    
}
