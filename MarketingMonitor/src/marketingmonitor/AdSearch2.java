/*
 *  Github.com/EoinReid
 */
package marketingmonitor;

import DTOs.Ad;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.JPanel;

/**
 *
 * @author eoire
 */
public class AdSearch2 extends javax.swing.JFrame {

    /**
     * Creates new form Login2
     */
    public AdSearch2() {
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

        jBackground = new javax.swing.JPanel();
        jSidebar = new javax.swing.JPanel();
        jAdSearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jAdSearch = new javax.swing.JLabel();
        jPriceComparePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPriceCompare = new javax.swing.JLabel();
        jAdPopularityPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jAdPopularity = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JrefCode = new javax.swing.JTextField();
        jSearchIcon = new javax.swing.JLabel();
        jXbtn = new javax.swing.JLabel();
        jDragProgram = new javax.swing.JLabel();
        jTitleResult = new javax.swing.JLabel();
        jPriceResult = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jBackground.setBackground(new java.awt.Color(255, 255, 255));
        jBackground.setForeground(new java.awt.Color(255, 255, 255));
        jBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSidebar.setBackground(new java.awt.Color(54, 33, 89));
        jSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jAdSearchPanel.setBackground(new java.awt.Color(85, 65, 118));
        jAdSearchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAdSearchPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jAdSearchPanelMousePressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(222, 222, 222));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/marketingmonitor/images/icons8_search_15px.png"))); // NOI18N

        jAdSearch.setBackground(new java.awt.Color(255, 255, 255));
        jAdSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jAdSearch.setForeground(new java.awt.Color(255, 255, 255));
        jAdSearch.setText("Ad Search");

        javax.swing.GroupLayout jAdSearchPanelLayout = new javax.swing.GroupLayout(jAdSearchPanel);
        jAdSearchPanel.setLayout(jAdSearchPanelLayout);
        jAdSearchPanelLayout.setHorizontalGroup(
            jAdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAdSearch)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jAdSearchPanelLayout.setVerticalGroup(
            jAdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAdSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jAdSearchPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jAdSearch))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jSidebar.add(jAdSearchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, 40));

        jPriceComparePanel.setBackground(new java.awt.Color(64, 43, 100));
        jPriceComparePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPriceComparePanelMousePressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(222, 222, 222));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/marketingmonitor/images/icons8_price_15px.png"))); // NOI18N

        jPriceCompare.setBackground(new java.awt.Color(255, 255, 255));
        jPriceCompare.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPriceCompare.setForeground(new java.awt.Color(255, 255, 255));
        jPriceCompare.setText("Price Compare");

        javax.swing.GroupLayout jPriceComparePanelLayout = new javax.swing.GroupLayout(jPriceComparePanel);
        jPriceComparePanel.setLayout(jPriceComparePanelLayout);
        jPriceComparePanelLayout.setHorizontalGroup(
            jPriceComparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPriceComparePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPriceCompare)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPriceComparePanelLayout.setVerticalGroup(
            jPriceComparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPriceComparePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPriceComparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPriceCompare))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jSidebar.add(jPriceComparePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jAdPopularityPanel.setBackground(new java.awt.Color(64, 43, 100));
        jAdPopularityPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jAdPopularityPanelMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(222, 222, 222));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/marketingmonitor/images/icons8_graph_15px.png"))); // NOI18N

        jAdPopularity.setBackground(new java.awt.Color(255, 255, 255));
        jAdPopularity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jAdPopularity.setForeground(new java.awt.Color(255, 255, 255));
        jAdPopularity.setText("Ad Popularity");

        javax.swing.GroupLayout jAdPopularityPanelLayout = new javax.swing.GroupLayout(jAdPopularityPanel);
        jAdPopularityPanel.setLayout(jAdPopularityPanelLayout);
        jAdPopularityPanelLayout.setHorizontalGroup(
            jAdPopularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdPopularityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAdPopularity)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jAdPopularityPanelLayout.setVerticalGroup(
            jAdPopularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdPopularityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAdPopularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAdPopularity))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jSidebar.add(jAdPopularityPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 50));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Market Monitor");
        jSidebar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jBackground.add(jSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        jPanel1.setBackground(new java.awt.Color(112, 72, 221));
        jPanel1.setPreferredSize(new java.awt.Dimension(572, 85));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ad Search");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter a product reference code, John.");

        JrefCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));
        JrefCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JrefCodeActionPerformed(evt);
            }
        });

        jSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/marketingmonitor/images/icons8_search_20px.png"))); // NOI18N
        jSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JrefCode, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSearchIcon)))
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(JrefCode))
                    .addComponent(jSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jBackground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 960, 130));

        jXbtn.setBackground(new java.awt.Color(54, 33, 89));
        jXbtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jXbtn.setForeground(new java.awt.Color(54, 33, 89));
        jXbtn.setText("X");
        jXbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXbtnMouseClicked(evt);
            }
        });
        jBackground.add(jXbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 20, 20));

        jDragProgram.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jDragProgramMouseDragged(evt);
            }
        });
        jBackground.add(jDragProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));
        jBackground.add(jTitleResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 40, 20));
        jBackground.add(jPriceResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 40, 20));
        jBackground.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "Price", "ID", "Ebay", "DoneDeal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 920, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public static void AdSearchScreen() {
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
            java.util.logging.Logger.getLogger(AdSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdSearch2().setVisible(true);
            }
        });
    }   
     
    private void jDragProgramMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDragProgramMouseDragged
        int cordX = evt.getXOnScreen();
        int cordY = evt.getYOnScreen();
        
        System.out.println(cordX+","+cordY);
        
        this.setLocation(cordX,cordY);
    }//GEN-LAST:event_jDragProgramMouseDragged

    private void JrefCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JrefCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JrefCodeActionPerformed

    private void jXbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXbtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jXbtnMouseClicked

    private void jSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchIconMouseClicked
     String refCode = JrefCode.getText();
        System.out.println(refCode);
       try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
             OutputStream os = socket.getOutputStream();
            
            PrintWriter out = new PrintWriter(os, true);
            String command = "AdSearch";
            out.write(command +refCode+"\n");  // write command to socket, and newline terminator
            out.flush();              // flush (force) the command over the socket     
            
      InputStream inputStream = socket.getInputStream();
      Scanner socketReader = new Scanner(socket.getInputStream());
      String response = socketReader.nextLine();
      JsonReader jr = Json.createReader(new StringReader(response));
      JsonObject jo = jr.readObject();
            
      JsonObject object = jo.getJsonObject("ads");
      String type = object.getString("Type");
      String title = object.getString("Title");
      String priceResult = object.getString("Price");   
      Double price = Double.parseDouble(priceResult);
      String section = object.getString("Section");
      String description = object.getString("Description");   
      String Id = object.getString("Id"); 
      String currency = object.getString("Currency"); 
      String subsection = object.getString("Subsection");
      String time = object.getString("Time");
      String viewCount = object.getString("ViewCount");
      
      Ad a = new Ad(title,price);
      String titleOut = a.getTitle();
      Double priceOut = a.getPrice();      
      String priceString = String.valueOf(priceOut);
      String priceThree = "€" + priceString;
      
      jTitleResult.setText(titleOut);
      jPriceResult.setText(priceThree);
      
     
      
      
        } catch (IOException ex) {
            Logger.getLogger(AdSearch.class.getName()).log(Level.SEVERE, null, ex);
        }                                      
    }//GEN-LAST:event_jSearchIconMouseClicked

    private void jAdSearchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAdSearchPanelMouseClicked
      
    }//GEN-LAST:event_jAdSearchPanelMouseClicked

    private void jPriceComparePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPriceComparePanelMousePressed
        PriceCompare2 pc = new PriceCompare2();        
         pc.PriceCompareScreen(); 
         dispose();
      
    }//GEN-LAST:event_jPriceComparePanelMousePressed

    private void jAdSearchPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAdSearchPanelMousePressed
            AdSearch2 as = new AdSearch2();        
         as.AdSearchScreen(); 
         dispose();
    
    }//GEN-LAST:event_jAdSearchPanelMousePressed

    private void jAdPopularityPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAdPopularityPanelMousePressed
         AdPopularity2 ap = new AdPopularity2();        
         ap.AdPopularityScreen(); 
         dispose();
    }//GEN-LAST:event_jAdPopularityPanelMousePressed

    
    void setColour(JPanel jp){
    jp.setBackground(new Color(85,65,118));   
    }
    
    void resetColour (JPanel jp){
       jp.setBackground(new Color(64,43,100));        
    }
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
            java.util.logging.Logger.getLogger(AdSearch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdSearch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdSearch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdSearch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdSearch2().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JrefCode;
    private javax.swing.JLabel jAdPopularity;
    private javax.swing.JPanel jAdPopularityPanel;
    private javax.swing.JLabel jAdSearch;
    private javax.swing.JPanel jAdSearchPanel;
    private javax.swing.JPanel jBackground;
    private javax.swing.JLabel jDragProgram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPriceCompare;
    private javax.swing.JPanel jPriceComparePanel;
    private javax.swing.JLabel jPriceResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSearchIcon;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jSidebar;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTitleResult;
    private javax.swing.JLabel jXbtn;
    // End of variables declaration//GEN-END:variables
}
