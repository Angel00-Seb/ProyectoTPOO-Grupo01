package el_retoño;


class Producto {
    //Atributos
    private String idProducto;
    private String Nombre;
    private double Precio;
    private String Estado;
    private int Stock;
    private Categoria Categoria; //Relación con Categoria (1:n)
    
    //Constructores
    public Producto() {
    }

    public Producto(String Nombre, double Precio, String Estado, int Stock, Categoria Categoria) {
        this.idProducto = Categoria.GenerarCodigoProducto(); //Genera automáticamente
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Estado = Estado;
        this.Stock = Stock;
        this.Categoria = Categoria;
        Categoria.AgregarProducto(this); //Agregar este producto a la categoría
    }
    
    //Getters y Setters
    public String getIdProducto() {
        return idProducto;
    }
    
    //No hay setter para idProducto porque se genera automáticamente

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        if (Precio >= 0) {
            this.Precio = Precio;
        } else {
            System.out.println("Error: El precio no puede ser negativo.");
        }
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        if (Stock >= 0) {
            this.Stock = Stock;
        } else {
            System.out.println("Error: El stock no puede ser negativo.");
        }
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "ID_PRODUCTO: " + idProducto + "\n\tNOMBRE: " + Nombre + "\n\tPRECIO: S/." + Precio + "\n\tESTADO: " + Estado + "\n\tSTOCK: " + Stock + Categoria;
    }
    
    //Métodos
    public void ActualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio >= 0) {
            this.Precio = nuevoPrecio;
            System.out.println("Precio actualizado correctamente para: " + Nombre);
        } else {
            System.out.println("Error: El precio debe ser mayor o igual a 0.");
        }
    }
    
    public void CambiarEstado(String nuevoEstado) {
        this.Estado = nuevoEstado;
        System.out.println("Estado actualizado a: " + nuevoEstado + " para " + Nombre);
    }
    
    public boolean HayStock() {
        return Stock > 0;
    }
    
    public boolean ReducirStock(int cantidad) {
        if (cantidad <= Stock) {
            Stock -= cantidad;
            return true;
        } else {
            System.out.println("Error: Stock insuficiente para " + Nombre);
            return false;
        }
    }
    
    public void AumentarStock(int cantidad) {
        if (cantidad > 0) {
            Stock += cantidad;
            System.out.println("Stock aumentado en " + cantidad + " para " + Nombre);
        }
    }
}
