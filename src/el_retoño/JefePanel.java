package el_retoño;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JefePanel extends javax.swing.JFrame {
    
    private LoginJefe loginJefe;
    private ProductoController productoController;
    private CategoriaController categoriaController;
    private PedidoController pedidoController;
    private ClienteController clienteController;
    
    private DefaultTableModel modelProductos;
    private DefaultTableModel modelPedidos;
    private DefaultTableModel modelProductosVendidos;
    
    public JefePanel(LoginJefe loginJefe) {
        this.loginJefe = loginJefe;
        initControllers();
        initComponent();
        setLocationRelativeTo(null);
        cargarDatosIniciales();
    }

    private void initControllers() {
        categoriaController = new CategoriaController();
        productoController = new ProductoController(categoriaController);
        pedidoController = new PedidoController();
        clienteController = new ClienteController();
        
        // Asegurar que existan las categorías
        if (categoriaController.BuscarCategoriaPorId("PAN") == null) {
            categoriaController.CrearCategoria("PAN", "Panes");
        }
        if (categoriaController.BuscarCategoriaPorId("TOR") == null) {
            categoriaController.CrearCategoria("TOR", "Tortas");
        }
        if (categoriaController.BuscarCategoriaPorId("BEB") == null) {
            categoriaController.CrearCategoria("BEB", "Bebidas");
        }
        
        // Crear datos de ejemplo si no existen
        if (productoController.ListarTodos().isEmpty()) {
            crearProductosEjemplo();
        }
        if (pedidoController.ObtenerPedidos().isEmpty()) {
            crearPedidosEjemplo();
        }
    }
    
    private void crearProductosEjemplo() {
        productoController.CrearProducto("Pan Francés", 2.50, "Disponible", 50, "PAN");
        productoController.CrearProducto("Croissant", 3.00, "Disponible", 30, "PAN");
        productoController.CrearProducto("Torta Chocolate", 25.00, "Disponible", 10, "TOR");
        productoController.CrearProducto("Torta Vainilla", 22.00, "Disponible", 8, "TOR");
        productoController.CrearProducto("Café", 5.00, "Disponible", 100, "BEB");
        productoController.CrearProducto("Jugo Natural", 8.00, "Disponible", 50, "BEB");
    }
    
    private void crearPedidosEjemplo() {
        // Crear clientes de ejemplo
        ClienteSinRUC cliente1 = new ClienteSinRUC("Gonzales", "Maria", "15/05/1990", 
            "DNI", "12345678", "F", "Av. Principal 123", "987654321", "maria@email.com");
        ClienteSinRUC cliente2 = new ClienteSinRUC("Perez", "Carlos", "20/08/1985", 
            "DNI", "87654321", "M", "Calle Secundaria 456", "987654322", "carlos@email.com");
        
        clienteController.registrarCliente(cliente1);
        clienteController.registrarCliente(cliente2);
        
        // Crear pedidos de ejemplo
        Pedido pedido1 = pedidoController.CrearPedido("15/11/2024", cliente1, null);
        Pedido pedido2 = pedidoController.CrearPedido("16/11/2024", cliente2, null);
        
        // Agregar productos a los pedidos
        Producto panFrances = productoController.BuscarPorId("PAN001");
        Producto tortaChocolate = productoController.BuscarPorId("TOR001");
        Producto cafe = productoController.BuscarPorId("BEB001");
        
        if (panFrances != null) {
            PedidoDetalle detalle1 = new PedidoDetalle(2, panFrances);
            pedido1.AgregarDetalle(detalle1);
        }
        if (tortaChocolate != null) {
            PedidoDetalle detalle2 = new PedidoDetalle(1, tortaChocolate);
            pedido1.AgregarDetalle(detalle2);
        }
        if (cafe != null) {
            PedidoDetalle detalle3 = new PedidoDetalle(3, cafe);
            pedido2.AgregarDetalle(detalle3);
        }
        
        pedido1.MarcarComoFinalizado();
        pedido2.MarcarComoFinalizado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                            
    private void initComponent() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboFiltroCategoria = new javax.swing.JComboBox<>();
        btnActualizarStock = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalVentas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalPedidos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductosVendidos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jefe - Panadería El Retoño");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 248, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 69, 19));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÓDULO JEFE - REPORTES");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 10, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 248, 225));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane1.setForeground(new java.awt.Color(139, 69, 19));

        jPanel2.setBackground(new java.awt.Color(255, 248, 225));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Precio", "Stock", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(139, 69, 19));
        jLabel2.setText("Buscar producto:");

        txtBuscarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N);
        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setBackground(new java.awt.Color(210, 180, 140));
        btnBuscarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(101, 67, 33));
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(139, 69, 19));
        jLabel3.setText("Filtrar por categoría:");

        comboFiltroCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "Panes", "Tortas", "Bebidas" }));
        comboFiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroCategoriaActionPerformed(evt);
            }
        });

        btnActualizarStock.setBackground(new java.awt.Color(210, 180, 140));
        btnActualizarStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarStock.setForeground(new java.awt.Color(101, 67, 33));
        btnActualizarStock.setText("Actualizar Stock");
        btnActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventario", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 248, 225));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Fecha", "Cliente", "Total", "Estado", "Items"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedidos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(139, 69, 19));
        jLabel4.setText("Historial de Pedidos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(139, 69, 19));
        jLabel5.setText("Total de Ventas:");

        lblTotalVentas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTotalVentas.setForeground(new java.awt.Color(0, 153, 0));
        lblTotalVentas.setText("S/. 0.00");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(139, 69, 19));
        jLabel6.setText("Total Pedidos:");

        lblTotalPedidos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTotalPedidos.setForeground(new java.awt.Color(0, 102, 204));
        lblTotalPedidos.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalVentas)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalPedidos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalVentas)
                    .addComponent(jLabel6)
                    .addComponent(lblTotalPedidos))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 248, 225));

        tablaProductosVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Categoría", "Cantidad Vendida", "Total Recaudado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaProductosVendidos);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(139, 69, 19));
        jLabel7.setText("Productos Más Vendidos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos Vendidos", jPanel4);

        btnRegresar.setBackground(new java.awt.Color(210, 180, 140));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(101, 67, 33));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void cargarDatosIniciales() {
        modelProductos = (DefaultTableModel) tablaProductos.getModel();
        modelPedidos = (DefaultTableModel) tablaPedidos.getModel();
        modelProductosVendidos = (DefaultTableModel) tablaProductosVendidos.getModel();
        
        cargarInventario();
        cargarPedidos();
        cargarProductosVendidos();
    }
    
    private void cargarInventario() {
        modelProductos.setRowCount(0);
        String categoriaFiltro = (String) comboFiltroCategoria.getSelectedItem();
        String busqueda = txtBuscarProducto.getText().trim().toLowerCase();
        
        for (Producto producto : productoController.ListarTodos()) {
            boolean cumpleCategoria = categoriaFiltro.equals("TODOS") || 
                                     producto.getCategoria().getTipo().equals(categoriaFiltro);
            boolean cumpleBusqueda = busqueda.isEmpty() || 
                                    producto.getNombre().toLowerCase().contains(busqueda);
            
            if (cumpleCategoria && cumpleBusqueda) {
                modelProductos.addRow(new Object[]{
                    producto.getIdProducto(),
                    producto.getNombre(),
                    producto.getCategoria().getTipo(),
                    producto.getPrecio(),
                    producto.getStock(),
                    producto.getEstado()
                });
            }
        }
    }
    
    private void cargarPedidos() {
        modelPedidos.setRowCount(0);
        double totalVentas = 0;
        int totalPedidos = 0;
        
        for (Pedido pedido : pedidoController.ObtenerPedidos()) {
            if (pedido.isEstado()) { // Solo pedidos finalizados
                totalVentas += pedido.getTotal();
                totalPedidos++;
                
                modelPedidos.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getFecha(),
                    pedido.getCliente().ObtenerNombreCompleto(),
                    pedido.getTotal(),
                    pedido.ObtenerEstadoTexto(),
                    pedido.ContarDetalles()
                });
            }
        }
        
        lblTotalVentas.setText(String.format("S/. %.2f", totalVentas));
        lblTotalPedidos.setText(String.valueOf(totalPedidos));
    }
    
    private void cargarProductosVendidos() {
        modelProductosVendidos.setRowCount(0);
        
        // Mapa para acumular ventas por producto
        Map<String, Object[]> ventasPorProducto = new HashMap<>();
        
        for (Pedido pedido : pedidoController.ObtenerPedidos()) {
            if (pedido.isEstado()) {
                for (PedidoDetalle detalle : pedido.getListaDetalles()) {
                    Producto producto = detalle.getProducto();
                    String productoId = producto.getIdProducto();
                    
                    if (ventasPorProducto.containsKey(productoId)) {
                        Object[] datos = ventasPorProducto.get(productoId);
                        int cantidad = (int) datos[2] + detalle.getCantidad();
                        double total = (double) datos[3] + detalle.CalcularSubtotal();
                        datos[2] = cantidad;
                        datos[3] = total;
                    } else {
                        ventasPorProducto.put(productoId, new Object[]{
                            producto.getNombre(),
                            producto.getCategoria().getTipo(),
                            detalle.getCantidad(),
                            detalle.CalcularSubtotal()
                        });
                    }
                }
            }
        }
        
        // Agregar al modelo
        for (Object[] datos : ventasPorProducto.values()) {
            modelProductosVendidos.addRow(datos);
        }
    }

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        cargarInventario();
    }                                                 

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        cargarInventario();
    }                                                 

    private void comboFiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        cargarInventario();
    }                                                    

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int selectedRow = tablaProductos.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto de la lista", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idProducto = (String) tablaProductos.getValueAt(selectedRow, 0);
        String nombreProducto = (String) tablaProductos.getValueAt(selectedRow, 1);
        
        String nuevoStockStr = javax.swing.JOptionPane.showInputDialog(this, 
            "Nuevo stock para " + nombreProducto + ":", 
            "Actualizar Stock", 
            javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (nuevoStockStr != null) {
            try {
                int nuevoStock = Integer.parseInt(nuevoStockStr);
                if (nuevoStock < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "El stock no puede ser negativo", 
                        "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Producto producto = productoController.BuscarPorId(idProducto);
                if (producto != null) {
                    producto.setStock(nuevoStock);
                    cargarInventario();
                    
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "Stock actualizado correctamente", 
                        "Éxito", 
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Ingrese un número válido", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                                  

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setVisible(false);
        loginJefe.setVisible(true);
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboFiltroCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTotalPedidos;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosVendidos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
