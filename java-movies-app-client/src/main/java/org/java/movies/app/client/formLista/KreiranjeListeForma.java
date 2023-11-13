/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.java.movies.app.client.formLista;

import org.java.movies.app.client.formFilm.PretragaFilmaForma;
import org.java.movies.app.common.domain.*;
import org.java.movies.app.client.form.MainForma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.java.movies.app.client.model.FullFilmTableModel;
import org.java.movies.app.client.communication.Communication;
/**
 *
 * @author Administrator
 */
public class KreiranjeListeForma extends javax.swing.JDialog {

    private List<Film> filmovi;

    /**
     * Creates new form KreirajListuForma
     */
    public KreiranjeListeForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        filmovi = new ArrayList<>();
        prepareView();
      

        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNaziv = new javax.swing.JLabel();
        txtNazivListe = new javax.swing.JTextField();
        btnDodajListu = new javax.swing.JButton();
        btnDodajFilm = new javax.swing.JButton();
        cbdFilmovi = new javax.swing.JComboBox();
        btnPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        filmTable = new javax.swing.JTable();
        btnUkloni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kreiranje liste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        lblNaziv.setText("Naziv liste: ");

        btnDodajListu.setText("Kreiraj listu");
        btnDodajListu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajListuActionPerformed(evt);
            }
        });

        btnDodajFilm.setText("Dodaj film");
        btnDodajFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajFilmActionPerformed(evt);
            }
        });

        cbdFilmovi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPretrazi.setText("Pretrazi film");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        filmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(filmTable);

        btnUkloni.setText("Ukloni film");
        btnUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDodajListu, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNazivListe, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbdFilmovi, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDodajFilm, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(btnPretrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNazivListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdFilmovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajFilm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretrazi)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodajListu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUkloni))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajFilmActionPerformed
        try {
            Film film = (Film) cbdFilmovi.getSelectedItem();
            if (film == null) {
                throw new Exception("Selektujte film!");
            }

            if (filmovi.contains(film)) {
                throw new Exception("Film je vec dodat!");
            }
            FullFilmTableModel model = (FullFilmTableModel) filmTable.getModel();
            model.addFilm(film);
            //filmovi.add(film);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDodajFilmActionPerformed

    private void btnDodajListuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajListuActionPerformed

        try {
            String naziv = txtNazivListe.getText().trim();
            if (naziv.isBlank()) {
                throw new Exception("Sva polja moraju biti popunjena!");
            }
            Lista lista = new Lista(-1l, naziv, new Date(), null, filmovi);
            Communication.getInstance().addLista(lista);
            JOptionPane.showMessageDialog(this, "Uspešno kreirana lista!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajListuActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        new PretragaFilmaForma(this).setVisible(true);
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniActionPerformed
        try {
            int row = filmTable.getSelectedRow();
            if(row<0)
                throw new Exception("Film mora biti selektovan!");
            FullFilmTableModel model = (FullFilmTableModel) filmTable.getModel();
            Film film=model.getFilm(row);
            filmovi.remove(film);
            model.removeFilm(film);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUkloniActionPerformed

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
            java.util.logging.Logger.getLogger(KreiranjeListeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreiranjeListeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreiranjeListeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreiranjeListeForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KreiranjeListeForma dialog = new KreiranjeListeForma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajFilm;
    private javax.swing.JButton btnDodajListu;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JComboBox cbdFilmovi;
    private javax.swing.JTable filmTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JTextField txtNazivListe;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        try {
            List<Film> filmovi1 = Communication.getInstance().getFilmovi();
            cbdFilmovi.setModel(new DefaultComboBoxModel(filmovi1.toArray()));
            
            cbdFilmovi.setSelectedItem(null);
            filmTable.setModel(new FullFilmTableModel(filmovi));
        } catch (Exception ex) {
            Logger.getLogger(KreiranjeListeForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setFilm(Film film) {
//        FullFilmTableModel model = (FullFilmTableModel) filmTable.getModel();
//        model.addFilm(film);
        cbdFilmovi.getModel().setSelectedItem(film);
    }

}
