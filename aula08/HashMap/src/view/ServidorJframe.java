package view;

import util.Utils;
import javax.swing.JOptionPane;
import model.TabelaHash;

public class ServidorJframe extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ServidorJframe.class.getName());


    public ServidorJframe() {
        initComponents();
        hashSessoes = new TabelaHash();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_base = new javax.swing.JLabel();
        lbl_ = new javax.swing.JLabel();
        txt_caminho_arquivo = new javax.swing.JTextField();
        btn_carregar_arquivo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sessões em telefonia");
        setResizable(false);

        lbl_base.setText("Base de sessões");

        btn_carregar_arquivo.setText("Carregar");
        btn_carregar_arquivo.addActionListener(this::btn_carregar_arquivoActionPerformed);

        btn_editar.setText("Editar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_base)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_caminho_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_)
                        .addContainerGap(8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_carregar_arquivo)
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_base)
                    .addComponent(lbl_)
                    .addComponent(txt_caminho_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_carregar_arquivo)
                    .addComponent(btn_editar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_carregar_arquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregar_arquivoActionPerformed
       if(txt_caminho_arquivo.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Informe o nome do arquivo!");
           txt_caminho_arquivo.requestFocus();//retorna o cursor para a base de entrada
           return;
       }
       String res;
       if(Utils.carregarArquivoEmHashMap(res, sessoes, dadosSessoes)){
       
       }
       
    }//GEN-LAST:event_btn_carregar_arquivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ServidorJframe().setVisible(true));
        
    }
    TabelaHash hashSessoes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carregar_arquivo;
    private javax.swing.JButton btn_editar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_;
    private javax.swing.JLabel lbl_base;
    private javax.swing.JTextField txt_caminho_arquivo;
    // End of variables declaration//GEN-END:variables
}
