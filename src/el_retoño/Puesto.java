package el_retoño;


class Puesto {
    //Atributos
    private int idPuesto;
    private String Nombre;
    private double Sueldo;
    private String Descripcion;
    private static int ContadorPuestos = 0; // Para generar IDs automáticamente

    //Constructores
    public Puesto() {
    }

    public Puesto(String Nombre, double Sueldo) {
        ContadorPuestos++;
        this.idPuesto = ContadorPuestos;
        this.Nombre = Nombre;
        this.Sueldo = Sueldo;
        this.Descripcion = "";
    }
    
    public Puesto(String Nombre, double Sueldo, String Descripcion) {
        ContadorPuestos++;
        this.idPuesto = ContadorPuestos;
        this.Nombre = Nombre;
        this.Sueldo = Sueldo;
        this.Descripcion = Descripcion;
    }

    //Getters y Setters
    public int getIdPuesto() {
        return idPuesto;
    }
    
    // No hay setter para idPuesto porque se genera automáticamente
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }
    
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return " 'Puesto'" + " NOMBRE: " + Nombre + ", SUELDO: " + Sueldo;
    }
    
    //Métodos
    public void AumentarSueldo(double porcentaje) {
        if (porcentaje > 0) {
            double aumento = Sueldo * (porcentaje / 100);
            Sueldo += aumento;
            System.out.println("Sueldo aumentado en " + porcentaje + "%. Nuevo sueldo: S/." + 
                             String.format("%.2f", Sueldo));
        } else {
            System.out.println("Error: El porcentaje debe ser mayor a 0.");
        }
    }
    
    public double CalcularSueldoAnual() {
        return Sueldo * 12;
    }
    
    public boolean TieneMayorSueldoQue(Puesto otroPuesto) {
        return this.Sueldo > otroPuesto.getSueldo();
    }
}
