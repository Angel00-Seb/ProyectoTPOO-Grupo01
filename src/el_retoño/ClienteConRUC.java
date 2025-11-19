package el_retoño;


class ClienteConRUC extends Cliente{
    //Atributos
    private String Ruc;
    private String RazonSocial;
    private String Fax;
    private String Contacto;
    
    //Constructores
    public ClienteConRUC() {
        super();
    }

    public ClienteConRUC(String Ruc, String RazonSocial, String Fax, String Contacto, String FechaConstitucion, String Sexo, String Direccion, String Telefono, String Email) {
        // Para empresas, usamos razón social como "nombres" y apellidos vacío
        super("", RazonSocial, FechaConstitucion, "RUC", Ruc, Sexo, Direccion, Telefono, Email);
        this.Ruc = Ruc;
        this.RazonSocial = RazonSocial;
        this.Fax = Fax;
        this.Contacto = Contacto;
    }
    
    //Getters y Setters
    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }
    
    //ToString(VER DATOS)
    @Override
    public String toString() {
        return "\n[CLIENTE JURÍDICO - CON RUC]" +
               "\n   Razón Social: " + RazonSocial +
               "\n   RUC: " + Ruc +
               "\n   Contacto: " + Contacto +
               "\n   Fax: " + Fax +
               "\n   ID Cliente: " + getIdCliente() +
               "\n   Dirección: " + getDireccion() +
               "\n   Teléfono: " + getTelefono() +
               "\n   Email: " + getEmail() +
               "\n   Total pedidos: " + ContarPedidos();
    }
    
    //Métodos
    //Implementación del método abstracto. Retorna la razón social como nombre completo
    @Override
    public String ObtenerNombreCompleto() {
        return RazonSocial;
    }

    @Override
    public void Registrar() {
        System.out.println("\nCLIENTE JURÍDICO REGISTRADO (CON RUC)");
        System.out.println("ID: " + getIdCliente());
        System.out.println("Razón Social: " + RazonSocial);
        System.out.println("RUC: " + Ruc);
        System.out.println("Contacto: " + Contacto);
        System.out.println("Fax: " + Fax);
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Email: " + getEmail());       
    }
}
