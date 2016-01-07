package compte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class View extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private Csv csv = new Csv();
    private History history = new History();
    private JFreeChartComponent chart = new JFreeChartComponent();

    //Url des fichiers Csv
    public static String urlRep = new String();
    public static String url = new String();
    
    // Compte selectionné dans la combobox
    private String ItemSelected = new String();

    public View() {

        initComponents();

        // On récupère le chemin d'accès au dossier qui contiendra les fichiers de sauvegarde
        OSValidator osTester = new OSValidator();
        urlRep = osTester.osTest();

        // La liste déroulante est remplis par les noms des comtpes existant
        comboBox.setModel(csv.liste());
        String g = new String();
                
        // On affiche le total uniquement si au moins un compte existe
        if (csv.fileCount() != 0) {
            g = comboBox.getSelectedItem().toString();
            url = urlRep + "/" + g;
            String total = "";
            
            // On récupère le dernier total calculé
            try {

                BufferedReader br = new BufferedReader(new FileReader(View.url));
                int lineNumber = 0;
                while ((br.readLine()) != null) {
                    String[] line = new Csv().readCSV(View.url, lineNumber);
                    total = line[7];
                    lineNumber++;
                }
                br.close();

            } catch (Exception e) {
                System.out.println(e);
            }
            totalLabel.setText(total);
            Font font = new Font("Arial", Font.BOLD, 40);
            totalLabel.setFont(font);
            
            // En fonction de si le total est positif ou non on change sa couleur
            if (Integer.parseInt(total) >= 0) {
                totalLabel.setForeground(Color.green);
            } else {
                totalLabel.setForeground(Color.red);
            }
        }

        // On remplis la partie historique avec les données existant du compte ouvert
        try {

            TextArea text = new TextArea();
            text.setText(history.affichehistory());

            historique.setLayout(new BorderLayout());
            historique.add(text, BorderLayout.CENTER);
            historique.validate();

        } catch (Exception e) {
        }
        
        // On remplis le graphe
        File testFile = new File(url);
        if (testFile.exists()) {
            chartPanel.removeAll();
            chartPanel.setLayout(new BorderLayout());
            chartPanel.add(chart.graphPanel(), BorderLayout.CENTER);
            chartPanel.validate();
        }

    }
    
    public void refresh() {
        
        // Si aucun fichier n'a été detecté alors tout l'affichage est remis à zero
        if (csv.fileCount() == 0) {
            
            comboBox.setModel(csv.liste());

            chartPanel.removeAll();

            historique.removeAll();

            totalLabel.setText("");
        } else {
            // La combobox est remise à jour
            comboBox.setModel(csv.liste());
            
            // On récupère le numéro du compte selectionné dans la combobox
            int selectedIndex = 0;
            for (int i = 0; i < comboBox.getItemCount(); i++) {
                if (comboBox.getItemAt(i).equalsIgnoreCase(ItemSelected)) {
                    selectedIndex = i;
                }
            }
            File testFile = new File(url);
            // On affiche le compte selectionné en premier dans la liste
            comboBox.setSelectedIndex(selectedIndex);
            this.comboBox.repaint();

            // Si le fichier du compte selectionné existe on affiche :
            // Le graphe 
            // L'historique
            // Le total
            if (testFile.exists()) {
                chartPanel.removeAll();
                chartPanel.setLayout(new BorderLayout());
                chartPanel.add(chart.graphPanel(), BorderLayout.CENTER);
                chartPanel.validate();

                try {
                    TextArea text = new TextArea();
                    text.setText(history.affichehistory());

                    historique.removeAll();
                    historique.setLayout(new BorderLayout());
                    historique.add(text, BorderLayout.CENTER);
                    historique.validate();

                } catch (Exception e) {
                }

                // On s'occupe de l'affichage du Total en couleur
                String total = "";
                try {

                    BufferedReader br = new BufferedReader(new FileReader(View.url));
                    int lineNumber = 0;
                    while ((br.readLine()) != null) {
                        String[] line = new Csv().readCSV(View.url, lineNumber);
                        total = line[7];
                        lineNumber++;
                    }
                    br.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                totalLabel.setText(total);
                Font font = new Font("Arial", Font.BOLD, 40);
                totalLabel.setFont(font);
                if (Integer.parseInt(total) >= 0) {
                    totalLabel.setForeground(Color.green);
                } else {
                    totalLabel.setForeground(Color.red);
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBox = new javax.swing.JComboBox<>();
        newCount = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        mousedragged = new javax.swing.JLabel();
        debit = new javax.swing.JLabel();
        credit = new javax.swing.JLabel();
        chartPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historique = new javax.swing.JTextArea();
        totalLabel = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        newCount.setText("Nouveau");
        newCount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newCountMouseClicked(evt);
            }
        });
        newCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCountActionPerformed(evt);
            }
        });

        jButton4.setText("Graphique");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Diagramme Circulaire");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/delete86.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/down.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        mousedragged.setBackground(new java.awt.Color(0, 0, 0));
        mousedragged.setForeground(new java.awt.Color(102, 102, 102));
        mousedragged.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        mousedragged.setOpaque(true);
        mousedragged.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mousedraggedMouseDragged(evt);
            }
        });
        mousedragged.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mousedraggedMousePressed(evt);
            }
        });

        debit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/sub32.png"))); // NOI18N
        debit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                debitMouseClicked(evt);
            }
        });

        credit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/add74.png"))); // NOI18N
        credit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        historique.setColumns(20);
        historique.setRows(5);
        jScrollPane2.setViewportView(historique);

        jToggleButton1.setText("Supprimer");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mousedragged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(newCount)
                                        .addGap(31, 31, 31)
                                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(credit)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(debit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(totalLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(174, 174, 174)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mousedragged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCount)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(totalLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(credit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(debit)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton4))))
                .addGap(73, 73, 73))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCountActionPerformed

    }//GEN-LAST:event_newCountActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);       
    }//GEN-LAST:event_closeMouseClicked

    private void mousedraggedMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousedraggedMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);

    }//GEN-LAST:event_mousedraggedMouseDragged

    private void mousedraggedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousedraggedMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

    }//GEN-LAST:event_mousedraggedMousePressed

    private void creditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditMouseClicked
        Credit credit = new Credit();
        credit.setVisible(true);
        credit.addView(this);
    }//GEN-LAST:event_creditMouseClicked

    private void newCountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newCountMouseClicked
        NewCount newCount = new NewCount();
        newCount.setVisible(true);
        newCount.addView(this);

    }//GEN-LAST:event_newCountMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.add(chart.piePanel(), BorderLayout.CENTER);
        chartPanel.validate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        ItemSelected = comboBox.getSelectedItem().toString();
        url = urlRep + "/" + ItemSelected;
        this.refresh();
    }//GEN-LAST:event_comboBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.refresh();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void debitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debitMouseClicked
        Debit debit = new Debit();
        debit.setVisible(true);
        debit.addView(this);
    }//GEN-LAST:event_debitMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        File account = new File(url);
        while (account.isFile()) {
            account.delete();
        }
        this.refresh();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel close;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel credit;
    private javax.swing.JLabel debit;
    private javax.swing.JTextArea historique;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel mousedragged;
    private javax.swing.JButton newCount;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
