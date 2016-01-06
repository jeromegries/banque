package compte;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jerome
 */
public class Debit extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private View view;
    private Csv csv = new Csv();

    public Debit() {
        initComponents();
    }

    public void addView(View v) {
        this.view = v;
    }

    public void saveDebit() {

        String[] debit = new String[8];
        debit[0] = "debit";
        debit[1] = name.getText();
        debit[2] = amount.getText();
        debit[3] = category.getSelectedItem().toString();
        debit[4] = day.getText();
        debit[5] = month.getText();
        debit[6] = year.getText();

        String[] total = new String[8];

        try {

            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
            while ((br.readLine()) != null) {
                total = new Csv().readCSV(View.url, lineNumber);
                lineNumber++;
            }
            br.close();
        } catch (Exception e) {

        }

        int montant = Integer.parseInt(debit[2]);
        int totalcourant = Integer.parseInt(total[7]);
        int global = totalcourant - montant;
        String global7 = Integer.toString(global);
        debit[7] = global7;

        try {
            csv.writeCSV(debit);
        } catch (IOException e) {
            e.printStackTrace();  // or handle in some other way
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        setVisible(false);
        this.view.refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JLabel();
        cancel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        day = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        montant = new javax.swing.JLabel();
        slash0 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        slash = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        cat = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        mousedragged = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/basic.png"))); // NOI18N
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compte/pictures/delete86.png"))); // NOI18N
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });

        name.setToolTipText("");
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountKeyPressed(evt);
            }
        });

        day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dayKeyPressed(evt);
            }
        });

        description.setText("Description");

        montant.setText("Montant");

        slash0.setText("/");

        date.setText("Date");

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

        cat.setText("Catégorie");

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

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Logement / Chauffage / Eclairage", "Transport", "Alimentation", "Loisirs / Culture", "Mobiliers", "Habillements", "Santé", "Communication", "Education", "Autre" }));
        category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montant)
                    .addComponent(description)
                    .addComponent(date)
                    .addComponent(cat))
                .addGap(224, 224, 224)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(slash0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(slash)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                    .addComponent(amount)
                    .addComponent(name)
                    .addComponent(category, 0, 128, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mousedragged, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cat)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slash0, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slash, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_cancelMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        this.saveDebit();
    }//GEN-LAST:event_saveMouseClicked

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
            this.saveDebit();
        }
    }//GEN-LAST:event_nameKeyPressed

    private void amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveDebit();
        }
    }//GEN-LAST:event_amountKeyPressed

    private void categoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveDebit();
        }
    }//GEN-LAST:event_categoryKeyPressed

    private void dayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveDebit();
        }
    }//GEN-LAST:event_dayKeyPressed

    private void monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveDebit();
        }
    }//GEN-LAST:event_monthKeyPressed

    private void yearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.saveDebit();
        }
    }//GEN-LAST:event_yearKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Debit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JLabel cancel;
    private javax.swing.JLabel cat;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel close;
    private javax.swing.JLabel date;
    private javax.swing.JTextField day;
    private javax.swing.JLabel description;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel montant;
    private javax.swing.JTextField month;
    private javax.swing.JLabel mousedragged;
    private javax.swing.JTextField name;
    private javax.swing.JLabel save;
    private javax.swing.JLabel slash;
    private javax.swing.JLabel slash0;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
