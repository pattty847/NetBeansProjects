/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.manager;

import java.util.Arrays;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author pattt
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private FileSearch search = new FileSearch();

    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        inputText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        copy = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        fileDisplay = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Manager");
        setResizable(false);

        jLabel1.setText("Directory");

        copy.setText("Copy");
        copy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyMouseClicked(evt);
            }
        });
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        viewButton.setText("View");
        viewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewButtonMouseClicked(evt);
            }
        });

        openButton.setText("Open");
        openButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openButtonMouseClicked(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        fileDisplay.setEditable(false);
        jScrollPane2.setViewportView(fileDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputText))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {copy, deleteButton, openButton, viewButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openButton)
                            .addComponent(copy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewButton)
                            .addComponent(deleteButton)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method is called when a user attempts to open the directory typed into
     * (inputText) If (inputText) is empty there will be no execution; along
     * with the directory not existing. If it exists, we sent the directory to
     * the (loadDir()) method with "copy" param. The (loadDir()) method will
     * take care of the copy location and execution of this.
     *
     * @param evt
     */
    private void openButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openButtonMouseClicked
        // Checks if Desktop import is supported on current OS
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Open file not supported");
            return;
        }

        // Grab the desktop's instance to open the file
        Desktop desktop = Desktop.getDesktop();
        if (!inputText.getText().isEmpty()) {
            if (search.doesDirExist(inputText.getText())) {
                try {

                    // Open the file with this function
                    desktop.open(search.getMainDir());
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Directory or File not Found.", "Error", JOptionPane.ERROR_MESSAGE);
                inputText.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter a directory to copy.", "Error", JOptionPane.ERROR_MESSAGE);
            inputText.setText(null);
        }
    }//GEN-LAST:event_openButtonMouseClicked

    /**
     * Method is called when the user attempts to copy a file directory typed
     * into (inputText). If (inputText) is empty there will be no execution;
     * along with the directory not existing. If it exists, we sent the
     * directory to the (loadDir()) method with "copy" param. The (loadDir())
     * method will take care of the copy location and execution of this.
     */
    private void copyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMouseClicked
        if (!inputText.getText().isEmpty()) {
            if (search.doesDirExist(inputText.getText())) {
                fileDisplay.setText(Arrays.toString(search.getMainDir().list()).trim());
                jTextPane1.setText(search.getCount());
                search.loadDir(inputText.getText(), "copy");
                
            } else {
                JOptionPane.showMessageDialog(this, "Directory or File not Found.", "Error", JOptionPane.ERROR_MESSAGE);
                inputText.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter a directory to copy.", "Error", JOptionPane.ERROR_MESSAGE);
            inputText.setText(null);
        }
    }//GEN-LAST:event_copyMouseClicked

    /**
     * Method is called when the user attempts to look at a file's contents
     * typed into (inputText). If (inputText) is empty there will be no
     * execution; along with the directory not existing. If it exists, we sent
     * the directory to the (loadDir()) method with "open" param.
     */
    private void viewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewButtonMouseClicked
        if (!inputText.getText().isEmpty()) {
            if (search.doesDirExist(inputText.getText())) {
                fileDisplay.setText(Arrays.toString(search.getMainDir().list()).trim());
                search.loadDir(inputText.getText(), "view");
                jTextPane1.setText(search.getCount());
            } else {
                JOptionPane.showMessageDialog(this, "Directory or File not Found.", "Error", JOptionPane.ERROR_MESSAGE);
                inputText.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter a directory to open.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewButtonMouseClicked

    /**
     * Method used to delete a directory entered by the user
     *
     * @param evt
     */
    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        if (!inputText.getText().isEmpty()) {
            if (search.doesDirExist(inputText.getText())) {
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete: " + inputText.getText());
                if (option == JOptionPane.YES_OPTION) {
                    if (search.getMainDir().delete()) {
                        JOptionPane.showMessageDialog(this, "File deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "There was an error deleting the file.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Directory or File not Found.", "Error", JOptionPane.ERROR_MESSAGE);
                inputText.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter a directory to copy.", "Error", JOptionPane.ERROR_MESSAGE);
            inputText.setText(null);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copy;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextPane fileDisplay;
    private javax.swing.JTextField inputText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton openButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
