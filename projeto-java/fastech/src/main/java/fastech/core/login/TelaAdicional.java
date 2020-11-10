/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastech.core.login;

import fastech.oshi.gui.OshiGui;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mmaia
 */
public class TelaAdicional extends javax.swing.JFrame {
    private Point point = new Point();

    /**
     * Creates new form TelaAdicional
     */
    public TelaAdicional() {
        initComponents();
    }

    
    static boolean maximized = true;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        header = new javax.swing.JPanel();
        iconMinMaxClose = new javax.swing.JPanel();
        buttonClose = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        buttonCloseMax = new javax.swing.JPanel();
        buttonMax = new javax.swing.JPanel();
        fullMax = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuIcon = new javax.swing.JPanel();
        lineHideMenu = new javax.swing.JPanel();
        hideMenu = new javax.swing.JPanel();
        buttonmenu = new javax.swing.JLabel();
        lineseting = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lineHideSettingto = new javax.swing.JPanel();
        buttonSeting2 = new javax.swing.JLabel();
        setting3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        setting = new javax.swing.JPanel();
        buttonSeting = new javax.swing.JLabel();
        buttonSeting3 = new javax.swing.JLabel();
        menuHide = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        view = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(5, 10, 46));
        header.setPreferredSize(new java.awt.Dimension(800, 50));
        header.setLayout(new java.awt.BorderLayout());

        iconMinMaxClose.setBackground(new java.awt.Color(5, 10, 46));
        iconMinMaxClose.setPreferredSize(new java.awt.Dimension(150, 50));
        iconMinMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClose.setBackground(new java.awt.Color(5, 10, 46));
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
        });
        buttonClose.setLayout(new java.awt.BorderLayout());

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_32px.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        buttonClose.add(close, java.awt.BorderLayout.CENTER);

        iconMinMaxClose.add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        buttonCloseMax.setBackground(new java.awt.Color(5, 10, 46));
        buttonCloseMax.setLayout(new java.awt.BorderLayout());
        iconMinMaxClose.add(buttonCloseMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        buttonMax.setBackground(new java.awt.Color(5, 10, 46));
        buttonMax.setLayout(new java.awt.BorderLayout());

        fullMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/full_screen_32px.png"))); // NOI18N
        fullMax.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fullMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fullMaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fullMaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fullMaxMouseExited(evt);
            }
        });
        buttonMax.add(fullMax, java.awt.BorderLayout.CENTER);

        iconMinMaxClose.add(buttonMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        header.add(iconMinMaxClose, java.awt.BorderLayout.LINE_END);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.add(jLabel4, java.awt.BorderLayout.LINE_START);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        menu.setPreferredSize(new java.awt.Dimension(270, 450));
        menu.setLayout(new java.awt.BorderLayout());

        menuIcon.setBackground(new java.awt.Color(5, 10, 46));
        menuIcon.setPreferredSize(new java.awt.Dimension(50, 450));
        menuIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lineHideMenu.setBackground(new java.awt.Color(5, 10, 46));
        lineHideMenu.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout lineHideMenuLayout = new javax.swing.GroupLayout(lineHideMenu);
        lineHideMenu.setLayout(lineHideMenuLayout);
        lineHideMenuLayout.setHorizontalGroup(
            lineHideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        lineHideMenuLayout.setVerticalGroup(
            lineHideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        menuIcon.add(lineHideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 10));

        hideMenu.setBackground(new java.awt.Color(5, 10, 46));
        hideMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hideMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hideMenuMouseExited(evt);
            }
        });

        buttonmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back_32px.png"))); // NOI18N

        javax.swing.GroupLayout hideMenuLayout = new javax.swing.GroupLayout(hideMenu);
        hideMenu.setLayout(hideMenuLayout);
        hideMenuLayout.setHorizontalGroup(
            hideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hideMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );
        hideMenuLayout.setVerticalGroup(
            hideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonmenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menuIcon.add(hideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 50));

        lineseting.setBackground(new java.awt.Color(5, 10, 46));
        lineseting.setPreferredSize(new java.awt.Dimension(50, 5));

        jPanel3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout linesetingLayout = new javax.swing.GroupLayout(lineseting);
        lineseting.setLayout(linesetingLayout);
        linesetingLayout.setHorizontalGroup(
            linesetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        linesetingLayout.setVerticalGroup(
            linesetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, linesetingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        menuIcon.add(lineseting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 50, -1));

        lineHideSettingto.setBackground(new java.awt.Color(5, 10, 46));
        lineHideSettingto.setLayout(new java.awt.BorderLayout());
        menuIcon.add(lineHideSettingto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 50, -1));

        buttonSeting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSeting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings_32px.png"))); // NOI18N
        buttonSeting2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuIcon.add(buttonSeting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 50, 50));

        setting3.setBackground(new java.awt.Color(5, 10, 46));
        setting3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setting3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setting3MouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_35px.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout setting3Layout = new javax.swing.GroupLayout(setting3);
        setting3.setLayout(setting3Layout);
        setting3Layout.setHorizontalGroup(
            setting3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setting3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setting3Layout.setVerticalGroup(
            setting3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menuIcon.add(setting3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 50, 50));

        setting.setBackground(new java.awt.Color(5, 10, 46));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });

        javax.swing.GroupLayout settingLayout = new javax.swing.GroupLayout(setting);
        setting.setLayout(settingLayout);
        settingLayout.setHorizontalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        settingLayout.setVerticalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        menuIcon.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 50, -1));

        buttonSeting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuIcon.add(buttonSeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 40, 40));

        buttonSeting3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSeting3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/combo_chart_35px.png"))); // NOI18N
        buttonSeting3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSeting3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSeting3MouseClicked(evt);
            }
        });
        menuIcon.add(buttonSeting3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 50, 50));

        menu.add(menuIcon, java.awt.BorderLayout.LINE_START);

        menuHide.setBackground(new java.awt.Color(25, 29, 74));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N

        javax.swing.GroupLayout menuHideLayout = new javax.swing.GroupLayout(menuHide);
        menuHide.setLayout(menuHideLayout);
        menuHideLayout.setHorizontalGroup(
            menuHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuHideLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        menuHideLayout.setVerticalGroup(
            menuHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuHideLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        menu.add(menuHide, java.awt.BorderLayout.CENTER);

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        view.setBackground(new java.awt.Color(73, 128, 242));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/house_127px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seja bem vindo !");

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Powerd by: Fastech");

        javax.swing.GroupLayout viewLayout = new javax.swing.GroupLayout(view);
        view.setLayout(viewLayout);
        viewLayout.setHorizontalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );
        viewLayout.setVerticalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLayout.createSequentialGroup()
                .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2))
                    .addGroup(viewLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        getContentPane().add(view, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(827, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered


    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited

    }//GEN-LAST:event_closeMouseExited

    private void fullMaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullMaxMouseEntered
   
    }//GEN-LAST:event_fullMaxMouseEntered

    private void fullMaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullMaxMouseExited
     }//GEN-LAST:event_fullMaxMouseExited

    private void fullMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullMaxMouseClicked
        
        if(maximized){
            
            TelaAdicional.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            TelaAdicional.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        }else{
        
            setExtendedState(JFrame.NORMAL);
                  
        maximized = true;
        }
       
        
    }//GEN-LAST:event_fullMaxMouseClicked

    private void hideMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMenuMouseEntered
        
    }//GEN-LAST:event_hideMenuMouseEntered

    private void hideMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMenuMouseExited
    }//GEN-LAST:event_hideMenuMouseExited

    private void hideMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMenuMouseClicked


    }//GEN-LAST:event_hideMenuMouseClicked

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered

    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
    }//GEN-LAST:event_settingMouseExited

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
       System.exit(0);
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void setting3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_setting3MouseEntered

    private void setting3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_setting3MouseExited

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
  Point p = this.getLocation();
      
      this.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
 point.x = evt.getX();
        point.y = evt.getY();

    }//GEN-LAST:event_formMousePressed

    private void buttonSeting3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSeting3MouseClicked
  
        new OshiGui().setVisible(true);
       this.setVisible(false);
        
    }//GEN-LAST:event_buttonSeting3MouseClicked

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
            java.util.logging.Logger.getLogger(TelaAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonClose;
    private javax.swing.JPanel buttonCloseMax;
    private javax.swing.JPanel buttonMax;
    private javax.swing.JLabel buttonSeting;
    private javax.swing.JLabel buttonSeting2;
    private javax.swing.JLabel buttonSeting3;
    private javax.swing.JLabel buttonmenu;
    private javax.swing.JLabel close;
    private javax.swing.JLabel fullMax;
    private javax.swing.JPanel header;
    private javax.swing.JPanel hideMenu;
    private javax.swing.JPanel iconMinMaxClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel lineHideMenu;
    private javax.swing.JPanel lineHideSettingto;
    private javax.swing.JPanel lineseting;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuHide;
    private javax.swing.JPanel menuIcon;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel setting3;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables

    private void changecolor(JPanel buttonClose, Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
