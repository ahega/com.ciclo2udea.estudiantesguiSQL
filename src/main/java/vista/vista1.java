package vista;

import javax.swing.JButton;

public class vista1 extends javax.swing.JFrame {

    public vista1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Title = new javax.swing.JLabel();
        lbl_subheader = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_listar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GotIt");

        lbl_Title.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lbl_Title.setText("Universidad de Antioquia");

        lbl_subheader.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbl_subheader.setText("Menú Principal - Seleccione una opción:");

        btn_ingresar.setText("Ingresar Registro de Estudiante");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar Registro de Estudiante");

        btn_modificar.setText("Modificar Registro de Estudiante");

        btn_eliminar.setText("Eliminar Registro de Estudiante");

        btn_listar.setText("Ver Listados de Registros");

        btn_salir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(lbl_Title))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbl_subheader)))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_ingresar)
                    .addComponent(btn_listar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_buscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_subheader)
                .addGap(30, 30, 30)
                .addComponent(btn_ingresar)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar)
                .addGap(18, 18, 18)
                .addComponent(btn_modificar)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminar)
                .addGap(18, 18, 18)
                .addComponent(btn_listar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ingresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_listar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_subheader;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_buscar() {
        return btn_buscar;
    }

    public void setBtn_buscar(JButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    public JButton getBtn_eliminar() {
        return btn_eliminar;
    }

    public void setBtn_eliminar(JButton btn_eliminar) {
        this.btn_eliminar = btn_eliminar;
    }

    public JButton getBtn_ingresar() {
        return btn_ingresar;
    }

    public void setBtn_ingresar(JButton btn_ingresar) {
        this.btn_ingresar = btn_ingresar;
    }

    public JButton getBtn_listar() {
        return btn_listar;
    }

    public void setBtn_listar(JButton btn_listar) {
        this.btn_listar = btn_listar;
    }

    public JButton getBtn_modificar() {
        return btn_modificar;
    }

    public void setBtn_modificar(JButton btn_modificar) {
        this.btn_modificar = btn_modificar;
    }

    public JButton getBtn_salir() {
        return btn_salir;
    }

    public void setBtn_salir(JButton btn_salir) {
        this.btn_salir = btn_salir;
    }


}
