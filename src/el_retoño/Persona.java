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
        if (TipoDoc == null) {
            this.TipoDoc = null;
            return;
        }

        String tipoMayus = TipoDoc.toUpperCase();
        if (tipoMayus.equals("DNI") || tipoMayus.equals("CE") || tipoMayus.equals("PASAPORTE")) {
            this.TipoDoc = tipoMayus;
        }
        else {
            System.err.println("Tipo de documento no válido. Debe ser 'DNI', 'CE' o 'PASAPORTE'.");
            this.TipoDoc = null;
        }
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String NumDoc) {
        if (this.TipoDoc == null) {
            System.err.println("Establezca primero un Tipo de Documento válido antes de asignar el Número de Documento.");
            this.NumDoc = null;
            return;
        }
        int longitudEsperada;
        if (this.TipoDoc.equals("DNI")) {
            longitudEsperada = 8;
        } else if (this.TipoDoc.equals("CE")) {
            longitudEsperada = 12 ;
        } else if (this.TipoDoc.equals("PASAPORTE")) {
            longitudEsperada = 12;
        } else {
            longitudEsperada = -1;
        }
        
        if (NumDoc != null && NumDoc.length() == longitudEsperada && NumDoc.matches("\\d+")) {
            this.NumDoc = NumDoc;
        } else {
            System.err.println("Número de Documento no válido para el tipo " + this.TipoDoc + ". Debe tener " + longitudEsperada + " dígitos.");
            this.NumDoc = null;
        }
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
