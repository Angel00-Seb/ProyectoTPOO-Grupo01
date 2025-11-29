package el_retoño;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PasteleroPanel extends javax.swing.JFrame {
    
    private LoginPastelero loginPastelero;
    private ProductoController productoController;
    private PedidoController pedidoController;
    private CategoriaController categoriaController;
    
    private DefaultTableModel modelPedidosPendientes;

    public PasteleroPanel(LoginPastelero loginPastelero) {
        this.loginPastelero = loginPastelero;
        initControllers();
        initComponent();
        setLocationRelativeTo(null);
        cargarDatosIniciales();
    }

    private void initControllers() {
        categoriaController = new CategoriaController();
        productoController = new ProductoController(categoriaController);
        pedidoController = new PedidoController();
        
        // Asegurar que existan las categorías de panadería/pastelería
        if (categoriaController.BuscarCategoriaPorId("PAN") == null) {
            categoriaController.CrearCategoria("PAN", "Panes");
        }
        if (categoriaController.BuscarCategoriaPorId("TOR") == null) {
            categoriaController.CrearCategoria("TOR", "Tortas");
        }
        
        // Crear productos de ejemplo si no existen
        if (productoController.ListarTodos().isEmpty()) {
            crearProductosEjemplo();
        }
        
        // Crear pedidos de ejemplo si no existen
        if (pedidoController.ObtenerPedidos().isEmpty()) {
            crearPedidosEjemplo();
        }
    }
    
    private void crearProductosEjemplo() {
        productoController.CrearProducto("Pan Francés", 2.50, "Pendiente", 50, "PAN");
        productoController.CrearProducto("Croissant", 3.00, "Pendiente", 30, "PAN");
        productoController.CrearProducto("Torta Chocolate", 25.00, "Pendiente", 10, "TOR");
        productoController.CrearProducto("Torta Vainilla", 22.00, "Pendiente", 8, "TOR");
        productoController.CrearProducto("Pan Integral", 3.50, "En Preparación", 20, "PAN");
        productoController.CrearProducto("Torta Fresa", 28.00, "Terminado", 5, "TOR");
    }
    
    private void crearPedidosEjemplo() {
        // Crear algunos clientes de ejemplo
        ClienteSinRUC cliente1 = new ClienteSinRUC("Gonzales", "Maria", "15/05/1990", 
            "DNI", "12345678", "F", "Av. Principal 123", "987654321", "maria@email.com");
        
        // Crear pedidos con productos pendientes
        String fecha = "15/11/2024";
        Pedido pedido1 = pedidoController.CrearPedido(fecha, cliente1, null);
        
        // Agregar productos pendientes al pedido
        Producto panFrances = productoController.BuscarPorId("PAN001");
        Producto tortaChocolate = productoController.BuscarPorId("TOR001");
        
        if (panFrances != null) {
            PedidoDetalle detalle1 = new PedidoDetalle(2, panFrances);
            pedido1.AgregarDetalle(detalle1);
        }
        
        if (tortaChocolate != null) {
            PedidoDetalle detalle2 = new PedidoDetalle(1, tortaChocolate);
            pedido1.AgregarDetalle(detalle2);
        }
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
        tablaPendientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboFiltroCategoria = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        comboNuevoEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pastelero - Panadería El Retoño");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 248, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 69, 19));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÓDULO PASTELERO");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 10, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 248, 225));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane1.setForeground(new java.awt.Color(139, 69, 19));

        jPanel2.setBackground(new java.awt.Color(255, 248, 225));

        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Categoría", "Estado", "Pedido ID", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPendientes);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(139, 69, 19));
        jLabel2.setText("Filtrar por categoría:");

        comboFiltroCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "Panes", "Tortas" }));
        comboFiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroCategoriaActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(210, 180, 140));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(101, 67, 33));
        btnActualizar.setText("Actualizar Lista");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCambiarEstado.setBackground(new java.awt.Color(210, 180, 140));
        btnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCambiarEstado.setForeground(new java.awt.Color(101, 67, 33));
        btnCambiarEstado.setText("Cambiar Estado");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });

        comboNuevoEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboNuevoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En Preparación", "Terminado" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(139, 69, 19));
        jLabel3.setText("Nuevo estado:");

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
                        .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboNuevoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboNuevoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Órdenes Pendientes", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 248, 225));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Estado", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(139, 69, 19));
        jLabel4.setText("Todos los Productos de Panadería/Pastelería");

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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventario", jPanel3);

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
        modelPedidosPendientes = (DefaultTableModel) tablaPendientes.getModel();
        cargarOrdenesPendientes();
        cargarTodosLosProductos();
    }
    
    private void cargarOrdenesPendientes() {
        modelPedidosPendientes.setRowCount(0);
        String categoriaFiltro = (String) comboFiltroCategoria.getSelectedItem();
        
        // Recorrer todos los pedidos para encontrar productos pendientes de panadería/pastelería
        for (Pedido pedido : pedidoController.ObtenerPedidos()) {
            for (PedidoDetalle detalle : pedido.getListaDetalles()) {
                Producto producto = detalle.getProducto();
                
                // Solo mostrar productos de panadería/pastelería
                if (producto.getCategoria().getIdCategoria().equals("PAN") || 
                    producto.getCategoria().getIdCategoria().equals("TOR")) {
                    
                    // Aplicar filtro de categoría
                    if (categoriaFiltro.equals("TODOS") || 
                        producto.getCategoria().getTipo().equals(categoriaFiltro)) {
                        
                        modelPedidosPendientes.addRow(new Object[]{
                            producto.getIdProducto(),
                            producto.getNombre(),
                            producto.getCategoria().getTipo(),
                            producto.getEstado(),
                            pedido.getIdPedido(),
                            detalle.getCantidad()
                        });
                    }
                }
            }
        }
    }
    
    private void cargarTodosLosProductos() {
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.setRowCount(0);
        
        for (Producto producto : productoController.ListarTodos()) {
            // Solo mostrar productos de panadería/pastelería
            if (producto.getCategoria().getIdCategoria().equals("PAN") || 
                producto.getCategoria().getIdCategoria().equals("TOR")) {
                
                model.addRow(new Object[]{
                    producto.getIdProducto(),
                    producto.getNombre(),
                    producto.getCategoria().getTipo(),
                    producto.getEstado(),
                    producto.getStock()
                });
            }
        }
    }

    private void comboFiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        cargarOrdenesPendientes();
    }                                                    

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        cargarOrdenesPendientes();
        cargarTodosLosProductos();
    }                                             

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int selectedRow = tablaPendientes.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto de la lista", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idProducto = (String) tablaPendientes.getValueAt(selectedRow, 0);
        String nuevoEstado = (String) comboNuevoEstado.getSelectedItem();
        
        Producto producto = productoController.BuscarPorId(idProducto);
        if (producto != null) {
            producto.setEstado(nuevoEstado);
            cargarOrdenesPendientes();
            cargarTodosLosProductos();
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Estado del producto actualizado a: " + nuevoEstado, 
                "Éxito", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setVisible(false);
        loginPastelero.setVisible(true);
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboFiltroCategoria;
    private javax.swing.JComboBox<String> comboNuevoEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaPendientes;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
