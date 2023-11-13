/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.java.movies.app.client.formFilm;

import org.java.movies.app.client.communication.Communication;
import org.java.movies.app.common.domain.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import org.java.movies.app.client.model.UlogaTableModel;

/**
 *
 * @author Administrator
 */
public class KreiranjeFilmForma extends javax.swing.JDialog {

    List<Uloga> uloge = new ArrayList<>();
    List<Glumac> glumci = new ArrayList<>();
    /**
     * Creates new form KreirajFilmDijalog
     */
    public KreiranjeFilmForma(JDialog owner) {
        super(owner);
        initComponents();
        prepareView();
        btnDodajFilm.setVisible(false);
        setLocationRelativeTo(null);
    }

    public KreiranjeFilmForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareView();
        btnKreirajFilm.setVisible(false);
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
        txtTrajanjeFilma = new javax.swing.JTextField();
        txtDrzavaPorekla = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbdZanr = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDodajFilm = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNazivFilma = new javax.swing.JTextField();
        txtDatumIzlaska = new javax.swing.JTextField();
        cbdReziser = new javax.swing.JComboBox();
        btnKreirajFilm = new javax.swing.JButton();
        cbdGlumac = new javax.swing.JComboBox();
        lblGlumci = new javax.swing.JLabel();
        btnDodajGlumca = new javax.swing.JButton();
        lblDodatiGlumci = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUloge = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos novog filma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        jLabel1.setText("Naziv filma: ");

        cbdZanr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Datum izlaska: ");

        jLabel3.setText("Trajanje filma:");

        btnDodajFilm.setText("Dodaj film");
        btnDodajFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajFilmActionPerformed(evt);
            }
        });

        jLabel4.setText("Drzava porekla:");

        jLabel5.setText("Zanr:");

        jLabel6.setText("Reziser: ");

        cbdReziser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKreirajFilm.setText("Kreiraj film");
        btnKreirajFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajFilmActionPerformed(evt);
            }
        });

        cbdGlumac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGlumci.setText("Glumci:");

        btnDodajGlumca.setText("Dodaj glumca");
        btnDodajGlumca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajGlumcaActionPerformed(evt);
            }
        });

        tblUloge.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUloge);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(lblGlumci))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazivFilma)
                            .addComponent(txtTrajanjeFilma)
                            .addComponent(cbdZanr, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbdReziser, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDrzavaPorekla)
                            .addComponent(txtDatumIzlaska)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbdGlumac, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajGlumca)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajFilm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnKreirajFilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1)))
                        .addGap(0, 0, 0)))
                .addGap(18, 18, 18)
                .addComponent(lblDodatiGlumci, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivFilma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatumIzlaska, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrajanjeFilma, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDrzavaPorekla, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdZanr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdReziser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdGlumac, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGlumci)
                    .addComponent(btnDodajGlumca))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDodatiGlumci, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajFilm)
                    .addComponent(btnKreirajFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajFilmActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String nazivFilma = txtNazivFilma.getText().trim();
            Date datumIzlaska = format.parse(txtDatumIzlaska.getText().trim());
            int trajanjeFilma = Integer.parseInt(txtTrajanjeFilma.getText().trim());
            String drzavaPorekla = txtDrzavaPorekla.getText().trim();
            Zanr zanr = (Zanr) cbdZanr.getSelectedItem();
            Reziser reziser = (Reziser) cbdReziser.getSelectedItem();
            
            
            Film noviFilm = new Film(-1l, nazivFilma, datumIzlaska, trajanjeFilma, drzavaPorekla, null, zanr, reziser, uloge);
            validate(noviFilm);
            for (Uloga uloga : uloge) {
                uloga.setFilm(noviFilm);
            }
            noviFilm.setUloge(uloge);
            Communication.getInstance().saveFilm(noviFilm);
            JOptionPane.showMessageDialog(this, "Uspešno sacuvan film!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
          } catch (ParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDodajFilmActionPerformed

    private void btnKreirajFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajFilmActionPerformed
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//       String nazivFilma = txtNazivFilma.getText().trim();
//        Date datumIzlaska = new Date();
//       try {
//            datumIzlaska = format.parse(txtDatumIzlaska.getText().trim());
//       } catch (ParseException ex) {
//           JOptionPane.showMessageDialog(this, "Datum mora biti u formatu dd.mm.gggg!");
//        }
//        int trajanjeFilma = Integer.parseInt(txtTrajanjeFilma.getText().trim());
//        String drzavaPorekla = txtDrzavaPorekla.getText().trim();
//        Zanr zanr = (Zanr) cbdZanr.getSelectedItem();
//        Reziser reziser = (Reziser) cbdReziser.getSelectedItem();
//        KreiranjeListeForma mn = (KreiranjeListeForma) getOwner();
//        List<Uloga> uloge;
//        Film noviFilm = new Film(-1l, nazivFilma, datumIzlaska, trajanjeFilma, drzavaPorekla, null, zanr, reziser, uloge);
//
//        mn.addFilm(noviFilm);
//        this.dispose();
    }//GEN-LAST:event_btnKreirajFilmActionPerformed

    private void btnDodajGlumcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajGlumcaActionPerformed
        Glumac glumac = (Glumac) cbdGlumac.getSelectedItem();
      
            UlogaTableModel model=(UlogaTableModel) tblUloge.getModel();
            glumci.add(glumac);
            model.addUloga(glumac, null);
        

    }//GEN-LAST:event_btnDodajGlumcaActionPerformed

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
            java.util.logging.Logger.getLogger(KreiranjeFilmForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreiranjeFilmForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreiranjeFilmForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreiranjeFilmForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajFilm;
    private javax.swing.JButton btnDodajGlumca;
    private javax.swing.JButton btnKreirajFilm;
    private javax.swing.JComboBox cbdGlumac;
    private javax.swing.JComboBox cbdReziser;
    private javax.swing.JComboBox cbdZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDodatiGlumci;
    private javax.swing.JLabel lblGlumci;
    private javax.swing.JTable tblUloge;
    private javax.swing.JTextField txtDatumIzlaska;
    private javax.swing.JTextField txtDrzavaPorekla;
    private javax.swing.JTextField txtNazivFilma;
    private javax.swing.JTextField txtTrajanjeFilma;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        try {
            List<Zanr> zanrovi = Communication.getInstance().getZanrovi();
            List<Reziser> reziseri = Communication.getInstance().getReziseri();
            List<Glumac> glumci = Communication.getInstance().getGlumci();
            cbdReziser.removeAllItems();
            cbdZanr.removeAllItems();
            cbdGlumac.removeAllItems();
            for (Reziser reziser : reziseri) {
                cbdReziser.addItem(reziser);
            }
            for (Zanr zanr : zanrovi) {
                cbdZanr.addItem(zanr);
            }
            for (Glumac glumac : glumci) {
                cbdGlumac.addItem(glumac);
            }
            cbdGlumac.setSelectedItem(null);
            cbdReziser.setSelectedItem(null);
            cbdZanr.setSelectedItem(null);
            TableModel model=new UlogaTableModel(uloge);
            tblUloge.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(KreiranjeFilmForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void validate(Film film) throws Exception {
        String message = "";
        if (film.getNaziv().isBlank() || film.getTrajajanjeFilma() < 0 ||
                film.getDrzavaPorekla().isBlank() || film.getZanr() == null || film.getReziser() == null
                || film.getUloge().isEmpty() ) {
            message += "Sva polja moraju biti uneta!";
        throw new Exception(message);
        }
    }
}
