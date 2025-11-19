package el_retoño;


abstract class Persona {
    //Atributos
    private String Apellidos;
    private String Nombres;
    private String FechaNacimiento; // Formato: DD/MM/AAAA
    private String TipoDoc; // "DNI", "CE", "PASAPORTE", "RUC"
    private String NumDoc;
    private String Sexo; // "M", "F", "Otro"
    
    //Constructores
    public Persona() {
    }

    public Persona(String Apellidos, String Nombres, String FechaNacimiento, String TipoDoc, String NumDoc, String Sexo) {
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.FechaNacimiento = FechaNacimiento;
        this.TipoDoc = TipoDoc;
        this.NumDoc = NumDoc;
        this.Sexo = Sexo;
    }

    //Getters y Setters
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTipoDoc() {
        return TipoDoc;
    }

    public void setTipoDoc(String TipoDoc) {
        this.TipoDoc = TipoDoc;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String NumDoc) {
        this.NumDoc = NumDoc;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    //ToString (VER DATOS BÁSICOS)
    @Override
    public String toString() {
        return "\n   Nombre: " + ObtenerNombreCompleto() +
               "\n   Documento: " + ObtenerDocumentoCompleto() +
               "\n   Fecha Nacimiento: " + FechaNacimiento +
               "\n   Edad: " + CalcularEdad() + " años" +
               "\n   Sexo: " + ObtenerGeneroCompleto();
    }
    
    //Métodos
    public String ObtenerNombreCompleto() {
        return Nombres + " " + Apellidos;
    }
    
    public String ObtenerDocumentoCompleto() {
        return TipoDoc + ": " + NumDoc;
    }
    
    public int CalcularEdad() {
        if (FechaNacimiento != null && FechaNacimiento.length() == 10) {
            try {
                String[] partes = FechaNacimiento.split("/");
                int anioNacimiento = Integer.parseInt(partes[2]);
                int anioActual = 2024; // Podrías usar Calendar.getInstance().get(Calendar.YEAR)
                return anioActual - anioNacimiento;
            } catch (Exception e) {
                System.out.println("Error al calcular la edad. Formato esperado: DD/MM/AAAA");
                return 0;
            }
        }
        return 0;
    }
    
    public boolean EsMayorDeEdad() {
        return CalcularEdad() >= 18;
    }
    
    public String ObtenerGeneroCompleto() {
        if (Sexo == null) return "No especificado";
        
        switch (Sexo.toUpperCase()) {
            case "M":
                return "Masculino";
            case "F":
                return "Femenino";
            default:
                return "Otro";
        }
    }
    
    public abstract void Registrar();
}
