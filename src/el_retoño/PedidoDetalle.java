package el_retoño;


class PedidoDetalle {
    //Atributos
    private int idDetalle;
    private double Importe;
    private int Cantidad;
    private Producto Producto; //Relación con Producto (1:n)
    private static int ContadorDetalles = 0; // Para generar IDs automáticamente

    //Constructores
    public PedidoDetalle() {
    }

    public PedidoDetalle(int Cantidad, Producto Producto) {
        ContadorDetalles++;
        this.idDetalle = ContadorDetalles;
        this.Importe = CalcularSubtotal();
        this.Cantidad = Cantidad;
        this.Producto = Producto;
        //Reducir el stock del producto
        if (Producto != null) {
            Producto.ReducirStock(Cantidad);
        }
    }

    //Getters y Setters
    public int getIdDetalle() {
        return idDetalle;
    }

    //No hay setter para idDetalle porque se genera automáticamente

    public double getImporte() {
        return Importe;
    }

    //No hay setter para importe porque se calcula automáticamente

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "ID_DATALLE: " + idDetalle + "\n\tRESUMEN: " + ObtenerResumen();
    }
    
    //Métodos
    public double CalcularSubtotal() {
        if (Producto != null) {
            return Producto.getPrecio() * Cantidad;
        }
        return 0.0;
    }
    
    public void ActualizarImporte() {
        this.Importe = CalcularSubtotal();
    }
    
    public void AumentarCantidad(int incremento) {
        if (incremento > 0) {
            this.Cantidad += incremento;
            this.Importe = CalcularSubtotal();
            
            // Reducir stock adicional
            if (Producto != null) {
                Producto.ReducirStock(incremento);
            }
            
            System.out.println("Cantidad aumentada a: " + Cantidad);
        }
    }
    
    public void DisminuirCantidad(int decremento) {
        if (decremento > 0 && decremento < Cantidad) {
            this.Cantidad -= decremento;
            this.Importe = CalcularSubtotal();
            
            // Devolver stock
            if (Producto != null) {
                Producto.AumentarStock(decremento);
            }
            
            System.out.println("Cantidad disminuida a: " + Cantidad);
        } else {
            System.out.println("Error: No se puede disminuir la cantidad a 0 o menos.");
        }
    }
    
    public String ObtenerResumen() {
        if (Producto != null) {
            return Cantidad + " x " + Producto.getNombre() + 
                   " @ S/." + String.format("%.2f", Producto.getPrecio()) + 
                   " = S/." + String.format("%.2f", Importe);
        }
        return "Producto no disponible";
    }

}

