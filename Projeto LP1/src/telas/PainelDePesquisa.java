package telas;

import estruturas.Persistencia;
import estruturas.Arte;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static telas.PainelPrincipal.jTelaPrincipal;

/** Painel de Pesquisa de Obras de Artes
 *    descrição:
 *      Esse painel possuí tudo acerca da pesquisa de uma obra de arte
 *      no acervo cadastrado.
 * 
 *    @author Grupo 06
 *      Alunos: Armando Neto, Douglas Lima
 *              Drayton Corrêa, Ewerton Santos
 */
public class PainelDePesquisa extends javax.swing.JInternalFrame {
     
     /** Construtor:
      *    Descrição:
      *      ELe executa o método atualiza_Arte que abre, lê o arquivo e atualiza
      *      a lista.
      */ 
    public PainelDePesquisa() {
        initComponents();
        atualiza_Arte();
        getRootPane().setDefaultButton(jBPesquisaRes);
    }
   
    
   //MÉTODOS:
    //Métodos Estáticos.
     /** Método que Atualiza a Lista de Obras de Arte  
      *    Descrição:
      *      Percorre a coleção e exibe todos os itens formatados de
      *      acordo com o modelo do método obj.
      */ 
    protected static void atualiza_Arte() {
        p.setupLer();

        if (p.getContinua() == true) {
            p.readRecords();
            p.cleanupLer();
            cad = p.getCad();
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            for (Arte a : cad) {
                model.addRow(obj(a));
            }
        } catch (NullPointerException e) {

        }
    }

     /** Metodo de Atualizar a Tabela Instantaneamente
      *    Descrição:
      *      Atualiza a tabela de pesquisa assim que qualquer alteração é
      *      feita em uma Obra de Arte.
      */
    static void atualizacao_Instantanea() {
        atualiza_Arte();
    }

     /** Método do Modelo de Exibição
      *    Descrição:
      *      O método cria o modelo que será exibido na tabela de pesquisa.
      */
    protected static Object[] obj(Arte a) {
        try {
            Object[] arte = {a.getTitulo(), a.getAno(), a.getNome(), a.getCategoria(), a.getTombo()};
            return arte;
        } catch (Exception e) {
        }
        return null;
    }

    //Métodos Comuns:
     /** Método que Fecha a Janela Aberta:
      *    Descrição:
      *      O método simplesmente fecha por completo a janela aberta no momento
      *      em que ele é chamado.
      */
    private void fecha_Janela() {
        this.dispose();
    }

     /** Método que Centraliza a Janela 
      *    Descrição: 
      *      O método captura o tamanho do painel e, através desse valor,
      *      faz com que as janelas sejam abertas no centro desse painel.
      */
    public void setPosicao() {
        Dimension d = jTelaPrincipal.getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

     /**
      * This method is called from within the constructor to initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is always
      * regenerated by the Form Editor.
      */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelSePesquisa = new javax.swing.JPanel();
        cbCategoriaPesquisa = new javax.swing.JComboBox<>();
        jSMostraPesquisa = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPesquisaNome = new javax.swing.JTextField();
        txtPesquisaArtista = new javax.swing.JTextField();
        lblTituloPainel = new javax.swing.JLabel();
        jBFecharPesquisa = new javax.swing.JButton();
        jBPesquisaRes = new javax.swing.JButton();
        botaoNomeArtista = new javax.swing.JRadioButton();
        botaoTitulo = new javax.swing.JRadioButton();
        botaoCategoria = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pesquisa de Obra de Arte");

        cbCategoriaPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Álbum", "Aquarela", "Colagem", "Desenho", "Escultura", "Foto", "Gravura", "Impressão", "Instalação", "Livro", "Múltiplo", "Objeto", "ObraDesinc", "Perform", "Pintura", "Relevo", "Tapeçaria", "Vídeo" }));
        cbCategoriaPesquisa.setToolTipText("Para pesquisar por Categoria, Selecione a Categoria da Obra e marque a caixa Categoria.");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ano de Produção", "Artista", "Categoria", "Tombo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jSMostraPesquisa.setViewportView(jTable1);

        txtPesquisaNome.setToolTipText("Para pesquisar por Título da Obra, digite o nome completo da obra e marque a caixa Titulo da Obra.");

        txtPesquisaArtista.setToolTipText("Para pesquisar por Nome do Artista, digite o nome completo do Artista e marque a caixa Nome do Artista.");

        lblTituloPainel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTituloPainel.setText("  Pesquisar Registro");

        jBFecharPesquisa.setText("Cadastrar");
        jBFecharPesquisa.setToolTipText("Retorna para a aba de cadastro de obras de arte.");
        jBFecharPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBFecharPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFecharPesquisaActionPerformed(evt);
            }
        });

        jBPesquisaRes.setText("Pesquisar");
        jBPesquisaRes.setToolTipText("Pesquisar dados inseridos.");
        jBPesquisaRes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBPesquisaRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisaResActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoNomeArtista);
        botaoNomeArtista.setText("Nome do Artista:");
        botaoNomeArtista.setToolTipText("");
        botaoNomeArtista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoNomeArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNomeArtistaActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoTitulo);
        botaoTitulo.setText("Titulo da Obra:");
        botaoTitulo.setToolTipText("");
        botaoTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTituloActionPerformed(evt);
            }
        });

        buttonGroup1.add(botaoCategoria);
        botaoCategoria.setText("Categoria:");
        botaoCategoria.setToolTipText("É necessário confirmar a caixa de pesquisa por categoria.");
        botaoCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCategoriaActionPerformed(evt);
            }
        });

        jButton1.setText("Restaurar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSePesquisaLayout = new javax.swing.GroupLayout(jPanelSePesquisa);
        jPanelSePesquisa.setLayout(jPanelSePesquisaLayout);
        jPanelSePesquisaLayout.setHorizontalGroup(
            jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botaoCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addComponent(botaoNomeArtista)
                        .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBPesquisaRes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBFecharPesquisa))
                            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPesquisaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(lblTituloPainel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanelSePesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSMostraPesquisa)
                .addContainerGap())
        );
        jPanelSePesquisaLayout.setVerticalGroup(
            jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSePesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPainel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoNomeArtista)
                    .addComponent(botaoTitulo)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCategoria)
                    .addComponent(cbCategoriaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSePesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPesquisaRes)
                    .addComponent(jBFecharPesquisa)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSMostraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setText("*Clique em cima da obra para vizualizar os detalhes e editar.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(811, Short.MAX_VALUE))
            .addComponent(jPanelSePesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Eventos de Botões e Clicks:
     /** Botão de Cadastrar
      *    Descrição:
      *      Abre uma nova janela de cadastro e fecha a de pesquisa.
      */
    private void jBFecharPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFecharPesquisaActionPerformed
        PainelDeRegistro painelC = new PainelDeRegistro();
        jTelaPrincipal.add(painelC);
        painelC.setTitle("Cadastrar Obra de Arte");
        painelC.setVisible(true);
        painelC.setPosicao();
        this.dispose();
    }//GEN-LAST:event_jBFecharPesquisaActionPerformed

     /** Botão de Pesquisar
      *    Descrição:
      *      Ao ser apertado, ele captura o botão de rádio que foi selecionado
      *      e o campo preenchido para que, com esses dados, percorra a coleção
      *      em busca de todos os objetos que possuam os mesmos dados. 
      */
    private void jBPesquisaResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisaResActionPerformed

        if (botaoTitulo.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (txtPesquisaNome.getText().equals(a.getTitulo())) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }
        if (botaoNomeArtista.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (txtPesquisaArtista.getText().equals(a.getNome())) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }
        if (botaoCategoria.isSelected()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            for (Arte a : cad) {
                if (a.getCategoria().equals(String.valueOf(cbCategoriaPesquisa.getSelectedItem()))) {
                    System.out.println(a.getTombo());
                    modelo.addRow(obj(a));
                }
            }
        }
    }//GEN-LAST:event_jBPesquisaResActionPerformed

     /** Evento do Clique do Mouse na Linha de Tabela
      *    Descrição:
      *      Após um clique em uma das linhas da tabela, é aberto em uma janela
      *      todas as informações sobre a obra de arte.
      */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        PainelDeAmostra painelA = new PainelDeAmostra(p.getArte(jTable1.rowAtPoint(evt.getPoint())).getTombo());
        jTelaPrincipal.add(painelA);
        painelA.setPosicao();
        painelA.setVisible(false);
        painelA.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    //Botões de Rádio:
     /** Botão de Rádio de Título da Obra
      *    Desrição:
      *      Quando ele é pressionado, gera um evento que habilita a escrita
      *      no campo de pesquisa de título e desabilita nos outros dois.
      */
    private void botaoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTituloActionPerformed
        if (botaoTitulo.isSelected()) {
            txtPesquisaNome.setEnabled(true);
            txtPesquisaArtista.setEnabled(false);
            cbCategoriaPesquisa.setEnabled(false);
        }
        if (botaoTitulo.isSelected() == false) {
            txtPesquisaArtista.setEnabled(true);
            cbCategoriaPesquisa.setEnabled(true);
        }
    }//GEN-LAST:event_botaoTituloActionPerformed

     /** Botão de Rádio de Nome do Artista
      *    Desrição:
      *      Quando ele é pressionado, gera um evento que habilita a escrita
      *      no campo de pesquisa do nome do artista e desabilita nos outros 
      *      dois.
      */
    private void botaoNomeArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNomeArtistaActionPerformed
        if (botaoNomeArtista.isSelected()) {
            txtPesquisaArtista.setEnabled(true);
            txtPesquisaNome.setEnabled(false);
            cbCategoriaPesquisa.setEnabled(false);
        }
        if (botaoNomeArtista.isSelected() == false) {
            txtPesquisaNome.setEnabled(true);
            cbCategoriaPesquisa.setEnabled(true);
        }
    }//GEN-LAST:event_botaoNomeArtistaActionPerformed

     /** Botão de Rádio de Nome da Categoria
      *    Desrição:
      *      Quando ele é pressionado, gera um evento que habilita a seleção
      *      na caixa de combinação da categoria e desabilita os campos de
      *      texto.
      */
    private void botaoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCategoriaActionPerformed
        if (botaoCategoria.isSelected()) {
            cbCategoriaPesquisa.setEnabled(true);
            txtPesquisaArtista.setEnabled(false);
            txtPesquisaNome.setEnabled(false);
        }
        if (botaoCategoria.isSelected() == false) {
            txtPesquisaArtista.setEnabled(true);
            txtPesquisaNome.setEnabled(true);
        }
    }//GEN-LAST:event_botaoCategoriaActionPerformed
    
     /** Botão de Restaurar
      *    Descrição:
      *      Ao ser pressionado, restaura a lista de obras de arte para o
      *      seu formato padrão aonde é exibido todas as obras. 
      */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualiza_Arte();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botaoCategoria;
    private javax.swing.JRadioButton botaoNomeArtista;
    private javax.swing.JRadioButton botaoTitulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCategoriaPesquisa;
    private javax.swing.JButton jBFecharPesquisa;
    private javax.swing.JButton jBPesquisaRes;
    protected static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelSePesquisa;
    private javax.swing.JScrollPane jSMostraPesquisa;
    protected static javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTituloPainel;
    private javax.swing.JTextField txtPesquisaArtista;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables
    // Outros Atributos:
    private static Persistencia p = new Persistencia();
    protected static LinkedList<Arte> cad = new LinkedList<Arte>();
    // Fim dos outros Atributos;
}
