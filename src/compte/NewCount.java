package compte;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class NewCount extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private View view;
    private Csv csv = new Csv();

    public NewCount() {
        initComponents();
    }

    public void addView(View v) {
        this.view = v;
    }

    public void saveNewCount() {
        String[] credit = new String[8];
        credit[0] = "credit";
        credit[1] = "";
        credit[2] = amount.getText();
        credit[3] = "";
        credit[4] = day.getText();
        credit[5] = month.getText();
        credit[6] = year.getText();
        credit[7] = amount.getText();

        String s = name.getText();

        try {
            csv.newCount(s, credit);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(false);
        this.view.refresh();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        save = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        slash0 = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        slash = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        day = new javax.swing.JTextField();
        cancel = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        mousedragged = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/basic.png"))); // NOI18N
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        nom.setText("Nom du compte");

        jLabel1.setText("Somme disponible");

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountKeyPressed(evt);
            }
        });

        jLabel2.setText("Date de création");

        slash0.setText("/");

        month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthKeyPressed(evt);
            }
        });

        slash.setText("/");

        year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yearKeyPressed(evt);
            }
        });

        day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dayKeyPressed(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/delete86.png"))); // NOI18N
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/down.png"))); // NOI18N
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/delete86.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slash0, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slash, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(amount)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mousedragged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(close)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mousedragged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(year)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(slash, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(slash0, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        this.saveNewCount();
    }//GEN-LAST:event_saveMouseClicked

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_cancelMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(ICONIFIED);// TODO add your handling code here:
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.setVisible(false);
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

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveNewCount();
        }
    }//GEN-LAST:event_nameKeyPressed

    private void amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveNewCount();
        }
    }//GEN-LAST:event_amountKeyPressed

    private void dayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveNewCount();
        }
    }//GEN-LAST:event_dayKeyPressed

    private void monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveNewCount();
        }
    }//GEN-LAST:event_monthKeyPressed

    private void yearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveNewCount();
        }
    }//GEN-LAST:event_yearKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewCount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCount().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JLabel cancel;
    private javax.swing.JLabel close;
    private javax.swing.JTextField day;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField month;
    private javax.swing.JLabel mousedragged;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel save;
    private javax.swing.JLabel slash;
    private javax.swing.JLabel slash0;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
