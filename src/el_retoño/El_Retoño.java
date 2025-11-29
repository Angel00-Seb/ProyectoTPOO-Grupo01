package el_retoño;

public class El_Retoño {
    public static void main(String[] args) {
        /* System.out.println("   SISTEMA DE GESTIÓN - PANADERÍA EL RETOÑO   ");
        
        // ==================== 1. CREAR PUESTOS ====================
        System.out.println("【 REGISTRANDO PUESTOS 】");
        Puesto gerente = new Puesto("Gerente", 2500.00, "Responsable de la panadería");
        Puesto vendedor = new Puesto("Vendedor", 1200.00, "Atención al cliente");
        Puesto cajero = new Puesto("Cajero", 1100.00, "Manejo de caja");
        
        System.out.println(" Puestos creados: " + gerente.getNombre() + ", " + vendedor.getNombre() + ", " + cajero.getNombre());
        
        // ==================== 2. CREAR PERSONAL ====================
        System.out.println("\n【 REGISTRANDO PERSONAL 】");
        Personal gerenteJuan = new Personal(
            "Rodríguez", "Juan Carlos", "10/03/1985", "DNI", "45678901", "M", "admin123", gerente
        );
        gerenteJuan.Registrar();
        
        Personal vendedoraMaria = new Personal(
            "López", "María Elena", "22/07/1995", "CE", "001234567", "F", "maria123", vendedor, gerenteJuan
        );
        vendedoraMaria.Registrar();
        
        Personal cajeroCarlos = new Personal(
            "Torres", "Carlos Alberto", "15/11/1998", "PASAPORTE", "AB123456", "M", "carlos123", cajero, gerenteJuan
        );
        cajeroCarlos.Registrar();
        
        // ==================== 3. CREAR CATEGORÍAS Y PRODUCTOS ====================
        System.out.println(" REGISTRANDO PRODUCTOS ");
        Categoria panes = new Categoria("A", "Panes");
        Categoria tortas = new Categoria("B", "Tortas");
        Categoria bebidas = new Categoria("C", "Bebidas");
        
        Producto p1 = new Producto("Pan de molde", 3.50, "Disponible", 50, panes);
        Producto p2 = new Producto("Pan francés", 0.30, "Disponible", 200, panes);
        Producto p3 = new Producto("Pan integral", 4.00, "Disponible", 30, panes);
        Producto p4 = new Producto("Torta de chocolate", 45.00, "Disponible", 10, tortas);
        Producto p5 = new Producto("Torta tres leches", 35.00, "Disponible", 8, tortas);
        Producto p6 = new Producto("Inca Kola 500ml", 2.50, "Disponible", 100, bebidas);
        
        System.out.println(" " + panes.ContarProductos() + " productos en categoría " + panes.getTipo());
        System.out.println(" " + tortas.ContarProductos() + " productos en categoría " + tortas.getTipo());
        System.out.println(" " + bebidas.ContarProductos() + " productos en categoría " + bebidas.getTipo());
        
        // ==================== 4. CREAR CLIENTES ====================
        System.out.println(" REGISTRANDO CLIENTES ");
        ClienteSinRUC cliente1 = new ClienteSinRUC(
            "García", "Ana María", "15/05/1990","DNI", "72345678", "F",
            "Av. Los Pinos 123", "987654321", "ana.garcia@email.com"
        );
        cliente1.Registrar();
        
        ClienteConRUC cliente2 = new ClienteConRUC(
            "20123456789", "Panadería San José S.A.C.", "044-123456", "Pedro Ruiz", "01/01/2015", "Empresa",
            "Jr. Comercio 456", "944123456", "ventas@sanjose.com"
        );
        cliente2.Registrar();
        
        // ==================== 5. CREAR PEDIDOS ====================
        System.out.println(" PROCESANDO PEDIDOS ");
        
        // Pedido 1 - Cliente Natural
        Pedido pedido1 = new Pedido("18/11/2024", cliente1, vendedoraMaria);
        vendedoraMaria.AtenderPedido(pedido1);
        
        PedidoDetalle det1 = new PedidoDetalle(2, p1); // 2 panes de molde
        PedidoDetalle det2 = new PedidoDetalle(10, p2); // 10 panes franceses
        PedidoDetalle det3 = new PedidoDetalle(2, p6); // 2 bebidas
        
        pedido1.AgregarDetalle(det1);
        pedido1.AgregarDetalle(det2);
        pedido1.AgregarDetalle(det3);
        
        pedido1.MostrarDetalles();
        pedido1.RegistrarPedido();
        pedido1.MarcarComoFinalizado();
        
        // Pedido 2 - Cliente Jurídico (empresa)
        Pedido pedido2 = new Pedido("18/11/2024", cliente2, cajeroCarlos);
        cajeroCarlos.AtenderPedido(pedido2);
        
        PedidoDetalle det4 = new PedidoDetalle(20, p2); // 20 panes franceses
        
        pedido2.MostrarDetalles();
        pedido2.RegistrarPedido();
        pedido2.MarcarComoFinalizado();
        
        // ==================== 6. REPORTES ====================
        System.out.println("              REPORTES DEL SISTEMA             ");
        
        // Historial de clientes
        cliente1.MostrarHistorialPedidos();
        cliente2.MostrarHistorialPedidos();
        
        // Desempeño del personal
        vendedoraMaria.MostrarPedidosAtendidos();
        cajeroCarlos.MostrarPedidosAtendidos();
        
        // Stock de productos
        System.out.println(" STOCK ACTUAL DE PRODUCTOS ");
        panes.MostrarProductos();
        tortas.MostrarProductos();
        
        System.out.println("           FIN DEL SISTEMA DE GESTIÓN          ");
    }PedidoDetalle det5 = new PedidoDetalle(2, p4); // 2 tortas de chocolate
        PedidoDetalle det6 = new PedidoDetalle(5, p3); // 5 panes integrales
        
        pedido2.AgregarDetalle(det4);
        pedido2.AgregarDetalle(det5);
        pedido2.AgregarDetalle(det6);
        
        pedido2.MostrarDetalles();
        pedido2.RegistrarPedido();
        pedido2.MarcarComoFinalizado();
        
        // ==================== 6. REPORTES ====================
        System.out.println("              REPORTES DEL SISTEMA             ");
        
        // Historial de clientes
        cliente1.MostrarHistorialPedidos();
        cliente2.MostrarHistorialPedidos();
        
        // Desempeño del personal
        vendedoraMaria.MostrarPedidosAtendidos();
        cajeroCarlos.MostrarPedidosAtendidos();
        
        // Stock de productos
        System.out.println(" STOCK ACTUAL DE PRODUCTOS ");
        panes.MostrarProductos();
        tortas.MostrarProductos();
        
        System.out.println("           FIN DEL SISTEMA DE GESTIÓN          ");
        */
    }
    
}