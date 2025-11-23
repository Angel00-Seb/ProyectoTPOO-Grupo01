package el_retoño;


class ClienteSinRUC extends Cliente{
    //Ya no necesita atributos.
    
    //Constructores
    public ClienteSinRUC() {
        super();
    }

    public ClienteSinRUC(String Apellidos, String Nombres, String FechaNacimiento, String TipoDoc, String NumDoc, String Sexo, String Direccion, String Telefono, String Email) {
        super(Apellidos, Nombres, FechaNacimiento, TipoDoc, NumDoc, Sexo, Direccion, Telefono, Email);
    }
    
    
    //No tiene Getters ni Setters
    
    //ToString
    @Override
    public String toString() {
        return "\n[CLIENTE NATURAL - SIN RUC]" + super.toString();
    }
    
    //Métodos
    //Implementación del método abstracto de Persona
    @Override
    public void Registrar() {
        System.out.println("\nCLIENTE NATURAL REGISTRADO (SIN RUC)");
        System.out.println("ID: " + getIdCliente());
        System.out.println(this);
        System.out.println("Mayor de edad: " + (EsMayorDeEdad() ? "Sí" : "No"));
    }
}
