package view;
import util.Utils;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Sessao;
import model.TabelaHash;

public class ServidorJFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ServidorJFrame.class.getName());


    public ServidorJFrame() {
        initComponents();
        hashSessoes = new TabelaHash();
        tbl_telefonia.setDefaultEditor(Object.class, null); // tabela só de leitura
        tbl_telefonia.setAutoCreateRowSorter(true);         // clicar no cabeçalho ordena
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_base = new javax.swing.JLabel();
        txt_caminho_arquivo = new javax.swing.JTextField();
        btn_carregar_arquivo = new javax.swing.JButton();
        btn_consultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_telefonia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sessões em telefonia");
        setResizable(false);

        lbl_base.setText("Base de sessões");

        btn_carregar_arquivo.setText("Carregar");
        btn_carregar_arquivo.addActionListener(this::btn_carregar_arquivoActionPerformed);

        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(this::btn_consultarActionPerformed);

        tbl_telefonia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "IMSI", "IMEI", "MCC", "MNC", "Cell ID", "LAC", "Bearer", "Início"
            }
        ));
        jScrollPane2.setViewportView(tbl_telefonia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_base)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_caminho_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(457, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_carregar_arquivo)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_base)
                    .addComponent(txt_caminho_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_carregar_arquivo)
                    .addComponent(btn_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_carregar_arquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregar_arquivoActionPerformed
       String nomeArquivo = txt_caminho_arquivo.getText().trim();
       if(nomeArquivo.isEmpty()){
           JOptionPane.showMessageDialog(this, "Informe o nome do arquivo!");
           txt_caminho_arquivo.requestFocus();//retorna o cursor para a base de entrada
           return;
       }
       // carrega num mapa novo: se a leitura falhar, as sessões antigas continuam na tela
       Map<String, Sessao> novasSessoes = Utils.carregarArquivoEmHashMap(nomeArquivo);
       if(novasSessoes != null){
           hashSessoes.substituir(novasSessoes);
           preencherTabela();
           JOptionPane.showMessageDialog(this, hashSessoes.tamanho() + " sessões carregadas.");
       } else {
           JOptionPane.showMessageDialog(this, "Problemas para ler o arquivo e carregar as sessões.", "Erro", JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_btn_carregar_arquivoActionPerformed

    /** Limpa a tabela e adiciona uma linha para cada sessão do HashMap. */
    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tbl_telefonia.getModel();
        modelo.setRowCount(0); // remove as linhas de uma carga anterior

        for (Sessao s : hashSessoes.todas()) {
            modelo.addRow(new Object[]{
                s.getNumero(),
                s.getImsi(),
                s.getImei(),
                s.getMcc(),
                s.getMnc(),
                s.getCellID(),
                s.getLac(),
                s.getBearer(),
                Utils.formatarDataHora(s.getStartTime())
            });
        }
    }

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        if (hashSessoes.estaVazia()) {
            JOptionPane.showMessageDialog(this, "Carregue o arquivo de sessões antes de consultar.");
            return;
        }
        // a tela de consulta usa a MESMA tabela hash já carregada aqui
        TelaConsultaSessao consulta = new TelaConsultaSessao(hashSessoes);
        consulta.setVisible(true);

        // se houver uma linha selecionada, já abre mostrando aquela sessão
        int linha = tbl_telefonia.getSelectedRow();
        if (linha >= 0) {
            consulta.consultar(tbl_telefonia.getValueAt(linha, 0).toString());
        }
    }//GEN-LAST:event_btn_consultarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ServidorJFrame().setVisible(true));
        
    }
    private final TabelaHash hashSessoes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_carregar_arquivo;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_base;
    private javax.swing.JTable tbl_telefonia;
    private javax.swing.JTextField txt_caminho_arquivo;
    // End of variables declaration//GEN-END:variables
}
