package el_retoño;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendedorPanel extends javax.swing.JFrame {
    
    private LoginVendedor loginVendedor;
    private ProductoController productoController;
    private CategoriaController categoriaController;
    private ClienteController clienteController;
    private PedidoController pedidoController;
    
    private DefaultTableModel modelProductos;
    private DefaultTableModel modelCarrito;
    private ArrayList<PedidoDetalle> carrito;
    private double totalPedido;
    
    public VendedorPanel(LoginVendedor loginVendedor) {
        this.loginVendedor = loginVendedor;
        initControllers();
        initComponent();
        setLocationRelativeTo(null);
        cargarDatosIniciales();
    }

    private void initControllers() {
        categoriaController = new CategoriaController();
        productoController = new ProductoController(categoriaController);
        clienteController = new ClienteController();
        pedidoController = new PedidoController();
        
        // Crear categorías si no existen
        if (categoriaController.BuscarCategoriaPorId("PAN") == null) {
            categoriaController.CrearCategoria("PAN", "Panes");
        }
        if (categoriaController.BuscarCategoriaPorId("TOR") == null) {
            categoriaController.CrearCategoria("TOR", "Tortas");
        }
        if (categoriaController.BuscarCategoriaPorId("BEB") == null) {
            categoriaController.CrearCategoria("BEB", "Bebidas");
        }
        
        // Crear algunos productos de ejemplo
        crearProductosEjemplo();
    }
    
    private void crearProductosEjemplo() {
        Categoria panes = categoriaController.BuscarCategoriaPorId("PAN");
        Categoria tortas = categoriaController.BuscarCategoriaPorId("TOR");
        Categoria bebidas = categoriaController.BuscarCategoriaPorId("BEB");
        
        if (productoController.ListarTodos().isEmpty()) {
            productoController.CrearProducto("Pan Francés", 2.50, "Disponible", 50, "PAN");
            productoController.CrearProducto("Croissant", 3.00, "Disponible", 30, "PAN");
            productoController.CrearProducto("Torta Chocolate", 25.00, "Disponible", 10, "TOR");
            productoController.CrearProducto("Torta Vainilla", 22.00, "Disponible", 8, "TOR");
            productoController.CrearProducto("Café", 5.00, "Disponible", 100, "BEB");
            productoController.CrearProducto("Jugo Natural", 8.00, "Disponible", 50, "BEB");
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
        jLabel2 = new javax.swing.JLabel();
        comboFiltroCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarCarrito = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnEliminarItem = new javax.swing.JButton();
        btnFinalizarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendedor - Panadería El Retoño");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 248, 225));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 69, 19));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÓDULO VENDEDOR");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 10, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 248, 225));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane1.setForeground(new java.awt.Color(139, 69, 19));

        jPanel2.setBackground(new java.awt.Color(255, 248, 225));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(139, 69, 19));
        jLabel2.setText("Filtrar por categoría:");

        comboFiltroCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "Panes", "Tortas", "Bebidas" }));
        comboFiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroCategoriaActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(139, 69, 19));
        jLabel3.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.setText("1");

        btnAgregarCarrito.setBackground(new java.awt.Color(210, 180, 140));
        btnAgregarCarrito.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarCarrito.setForeground(new java.awt.Color(101, 67, 33));
        btnAgregarCarrito.setText("Agregar al Carrito");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
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
                        .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 248, 225));

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio Unit.", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaCarrito);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(139, 69, 19));
        jLabel4.setText("Total del Pedido:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(139, 69, 19));
        lblTotal.setText("S/. 0.00");

        btnEliminarItem.setBackground(new java.awt.Color(210, 180, 140));
        btnEliminarItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarItem.setForeground(new java.awt.Color(101, 67, 33));
        btnEliminarItem.setText("Eliminar Item");
        btnEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItemActionPerformed(evt);
            }
        });

        btnFinalizarPedido.setBackground(new java.awt.Color(210, 180, 140));
        btnFinalizarPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarPedido.setForeground(new java.awt.Color(101, 67, 33));
        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Carrito de Compras", jPanel3);

        btnRegresar.setBackground(new java.awt.Color(210, 180, 140));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(101, 67, 33));
        btnRegresar.setText("Regresar al Menú");
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
        // Inicializar carrito
        carrito = new ArrayList<>();
        totalPedido = 0.0;
        
        // Configurar modelos de tabla
        modelProductos = (DefaultTableModel) tablaProductos.getModel();
        modelCarrito = (DefaultTableModel) tablaCarrito.getModel();
        
        // Cargar productos
        cargarProductos();
    }
    
    private void cargarProductos() {
        modelProductos.setRowCount(0);
        String categoriaSeleccionada = (String) comboFiltroCategoria.getSelectedItem();
        
        for (Producto producto : productoController.ListarTodos()) {
            if (categoriaSeleccionada.equals("TODOS") || 
                producto.getCategoria().getTipo().equals(categoriaSeleccionada)) {
                
                modelProductos.addRow(new Object[]{
                    producto.getIdProducto(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getStock(),
                    producto.getCategoria().getTipo()
                });
            }
        }
    }
    
    private void cargarCarrito() {
        modelCarrito.setRowCount(0);
        totalPedido = 0.0;
        
        for (PedidoDetalle detalle : carrito) {
            double subtotal = detalle.CalcularSubtotal();
            totalPedido += subtotal;
            
            modelCarrito.addRow(new Object[]{
                detalle.getProducto().getNombre(),
                detalle.getCantidad(),
                detalle.getProducto().getPrecio(),
                subtotal
            });
        }
        
        lblTotal.setText(String.format("S/. %.2f", totalPedido));
    }

    private void comboFiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        cargarProductos();
    }                                                    

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int selectedRow = tablaProductos.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto de la lista", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String idProducto = (String) tablaProductos.getValueAt(selectedRow, 0);
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            if (cantidad <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "La cantidad debe ser mayor a 0", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Producto producto = productoController.BuscarPorId(idProducto);
            if (producto == null) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Producto no encontrado", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cantidad > producto.getStock()) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Stock insuficiente. Stock disponible: " + producto.getStock(), 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear detalle y agregar al carrito
            PedidoDetalle detalle = new PedidoDetalle(cantidad, producto);
            carrito.add(detalle);
            
            cargarCarrito();
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Producto agregado al carrito", 
                "Éxito", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Ingrese una cantidad válida", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }                                                 

    private void btnEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int selectedRow = tablaCarrito.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un item del carrito", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        carrito.remove(selectedRow);
        cargarCarrito();
    }                                               

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        if (carrito.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El carrito está vacío", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Registrar cliente
        Cliente cliente = registrarCliente();
        if (cliente == null) return;
        
        // Crear pedido
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        Pedido pedido = pedidoController.CrearPedido(fecha, cliente, null);
        
        // Agregar detalles al pedido
        for (PedidoDetalle detalle : carrito) {
            pedido.AgregarDetalle(detalle);
        }
        
        // Marcar como finalizado
        pedido.MarcarComoFinalizado();
        
        // Mostrar resumen
        mostrarResumenPedido(pedido);
        
        // Limpiar carrito
        carrito.clear();
        cargarCarrito();
    }                                                  

    private Cliente registrarCliente() {
        String nombre = javax.swing.JOptionPane.showInputDialog(this, 
            "Ingrese el nombre del cliente:", 
            "Datos del Cliente", 
            javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (nombre == null || nombre.trim().isEmpty()) return null;
        
        String dni = javax.swing.JOptionPane.showInputDialog(this, 
            "Ingrese el DNI del cliente:", 
            "Datos del Cliente", 
            javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (dni == null || dni.trim().isEmpty()) return null;
        
        // Crear cliente natural
        ClienteSinRUC cliente = new ClienteSinRUC("", nombre, "", "DNI", dni, "M", "", "", "");
        clienteController.registrarCliente(cliente);
        
        return cliente;
    }
    
    private void mostrarResumenPedido(Pedido pedido) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("=== RESUMEN DEL PEDIDO ===\n\n");
        resumen.append("N° Pedido: ").append(pedido.getIdPedido()).append("\n");
        resumen.append("Fecha: ").append(pedido.getFecha()).append("\n");
        resumen.append("Cliente: ").append(pedido.getCliente().ObtenerNombreCompleto()).append("\n");
        resumen.append("Estado: ").append(pedido.ObtenerEstadoTexto()).append("\n\n");
        resumen.append("PRODUCTOS:\n");
        
        for (PedidoDetalle detalle : pedido.getListaDetalles()) {
            resumen.append("• ").append(detalle.getCantidad())
                   .append(" x ").append(detalle.getProducto().getNombre())
                   .append(" - S/.").append(detalle.CalcularSubtotal()).append("\n");
        }
        
        resumen.append("\nTOTAL: S/.").append(pedido.getTotal());
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            resumen.toString(), 
            "Pedido Registrado - N° " + pedido.getIdPedido(), 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setVisible(false);
        loginVendedor.setVisible(true);
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnEliminarItem;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboFiltroCategoria;
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
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
