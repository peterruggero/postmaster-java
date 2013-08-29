package io.postmaster.client.postmasterclient;

import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.Address;
import io.postmaster.entity.Address.AddressValidationResult;
import io.postmaster.entity.Shipment;
import io.postmaster.entity.result.FetchShipmentResult;
import io.postmaster.entity.result.ShipmentTrackResult;
import io.postmaster.errors.HTTPError;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import com.google.gson.Gson;


public class SimplePostmasterClient extends javax.swing.JFrame {

    public SimplePostmasterClient() {
        initComponents();

        //initialize once postmaster library by setting your API key
        PostMasterClient.setApiKey("tt_ODAwMTpSa09JNHktVzJUaFVwZFFCeFBfbTlyUm1UNWs");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        fetchShipmentsButton = new javax.swing.JButton();
        fetchByIdButton = new javax.swing.JButton();
        shipmentIdTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        trackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cityView = new javax.swing.JTextField();
        companyView = new javax.swing.JTextField();
        contactView = new javax.swing.JTextField();
        countryView = new javax.swing.JTextField();
        streetView = new javax.swing.JTextField();
        phoneView = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        stateView = new javax.swing.JTextField();
        zipView = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        validatePredefinedAddressButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find");

        consoleTextArea.setColumns(20);
        consoleTextArea.setRows(5);
        jScrollPane1.setViewportView(consoleTextArea);

        fetchShipmentsButton.setText("Fetch shipments");
        fetchShipmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchShipmentsButtonActionPerformed(evt);
            }
        });

        fetchByIdButton.setText("Fetch by id");
        fetchByIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchByIdButtonActionPerformed(evt);
            }
        });

        shipmentIdTextField.setToolTipText("shipment id");

        jLabel1.setText("Output");

        trackButton.setText("Track by id");
        trackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Current shipment id");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 255, 255), new java.awt.Color(0, 0, 0)));

        cityView.setText("Austin");

        companyView.setText("ASLS");

        contactView.setText("Joe Smith");

        countryView.setText("US");

        streetView.setText("1110 Algarita Ave.");

        phoneView.setText("919-720-7941");

        jLabel3.setText("City");

        jLabel4.setText("Company");

        jLabel5.setText("Contact");

        jLabel6.setText("Country");

        jLabel7.setText("Street");

        jLabel8.setText("Phone");

        stateView.setText("TX");

        zipView.setText("78704");

        jLabel9.setText("State");

        jLabel10.setText("Zip");

        validatePredefinedAddressButton.setText("Validate address");
        validatePredefinedAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validatePredefinedAddressButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(jLabel6)
                            .add(jLabel7))
                        .add(21, 21, 21))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(streetView)
                    .add(countryView)
                    .add(contactView)
                    .add(companyView)
                    .add(cityView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(validatePredefinedAddressButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jLabel9)
                            .add(jLabel10))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(zipView)
                            .add(stateView)
                            .add(phoneView))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cityView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(phoneView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(companyView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(stateView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(contactView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel10)
                        .add(jLabel5))
                    .add(zipView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countryView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(streetView, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(validatePredefinedAddressButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(shipmentIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(fetchShipmentsButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fetchByIdButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(trackButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(shipmentIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(fetchByIdButton))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                        .add(trackButton)
                        .add(10, 10, 10))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(fetchShipmentsButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE)))
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fetchShipmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchShipmentsButtonActionPerformed
        SwingWorker worker = new SwingWorker<ImageIcon[], Void>() {
            private FetchShipmentResult result = null;

            @Override
            public ImageIcon[] doInBackground() {
                try {
                    result = PostMasterClient.fetch(null, null);
                } catch (HTTPError ex) {
                    consoleTextArea.append(ex.getMessage());
                }
                return null;
            }

            @Override
            public void done() {
                fetchShipmentsButton.setEnabled(true);
                StringBuilder sb = new StringBuilder();
                if(result == null){
                    sb.append("Nothing was returned from API");
                }
                else{
                    sb.append("error code:").append(result.getCode()).append("\n");
                    sb.append("error message:").append(result.getCode()).append("\n");
                    if (result.getResults() != null) {
                        Gson gson = new Gson();
                        sb.append("Entity:\n").append(gson.toJson(result.getResults()));

                    }
                }
                
                appendConsoleNewBlock(sb.toString());
            }
        };
        consoleTextArea.append("\nLoading...\n");
        worker.execute();
        fetchShipmentsButton.setEnabled(false);

    }//GEN-LAST:event_fetchShipmentsButtonActionPerformed

    private void trackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackButtonActionPerformed
        final Integer id = extractNumberFromTextField(shipmentIdTextField);
        if (id != null) {
            SwingWorker worker = new SwingWorker<ImageIcon[], Void>() {
                private ShipmentTrackResult result = null;

                @Override
                public ImageIcon[] doInBackground() {
                    try {
                        result = Shipment.track(id);
                    } catch (HTTPError ex) {
                        consoleTextArea.append(ex.getMessage());
                    }
                    return null;
                }

                @Override
                public void done() {
                    trackButton.setEnabled(true);
                    StringBuilder sb = new StringBuilder();
                    sb.append("error code:").append(result.getCode()).append("\n");
                    sb.append("error message:").append(result.getCode()).append("\n");
                    if (result.getTrackingDetails() != null) {
                        Gson gson = new Gson();
                        sb.append("Entity:\n").append(gson.toJson(result.getTrackingDetails()));

                    }
                    appendConsoleNewBlock(sb.toString());
                }
            };
            consoleTextArea.append("\nLoading...\n");
            worker.execute();
            trackButton.setEnabled(false);
        }
    }//GEN-LAST:event_trackButtonActionPerformed

    private void fetchByIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchByIdButtonActionPerformed
        final Integer id = extractNumberFromTextField(shipmentIdTextField);
        if (id != null) {
            SwingWorker worker = new SwingWorker<ImageIcon[], Void>() {
                private Shipment result = null;

                @Override
                public ImageIcon[] doInBackground() {
                    try {
                        result = PostMasterClient.fetchById((long) id);
                    } catch (HTTPError ex) {
                        consoleTextArea.append(ex.getMessage());
                    }
                    return null;
                }

                @Override
                public void done() {
                    fetchByIdButton.setEnabled(true);
                    StringBuilder sb = new StringBuilder();
                    if (result != null) {
                        Gson gson = new Gson();
                        sb.append("Entity:\n").append(gson.toJson(result));
                    }
                    appendConsoleNewBlock(sb.toString());
                }
            };
            consoleTextArea.append("\nLoading...\n");
            worker.execute();
            fetchByIdButton.setEnabled(false);
        }

    }//GEN-LAST:event_fetchByIdButtonActionPerformed

    private void validatePredefinedAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validatePredefinedAddressButtonActionPerformed
        final Address address = Address.create()
                .setCity(cityView.getText())
                .setCompany(companyView.getText())
                .setContact(contactView.getText())
                .setCountry(countryView.getText())
                .setPhoneNumber(phoneView.getText())
                .setState(stateView.getText())
                .setStreet(streetView.getText())
                .setZipCode(zipView.getText());

        SwingWorker worker = new SwingWorker<ImageIcon[], Void>() {
            private AddressValidationResult result = null;

            @Override
            public ImageIcon[] doInBackground() {
                try {
                    result = address.validate();
                } catch (HTTPError ex) {
                    consoleTextArea.append(ex.getMessage());
                }
                return null;
            }

            @Override
            public void done() {
                validatePredefinedAddressButton.setEnabled(true);
                StringBuilder sb = new StringBuilder();
                if (result != null) {
                    Gson gson = new Gson();
                    sb.append("Entity:\n").append(gson.toJson(result));
                }
                appendConsoleNewBlock(sb.toString());
            }
        };
        consoleTextArea.append("\nLoading...\n");
        worker.execute();
        validatePredefinedAddressButton.setEnabled(false);
    }//GEN-LAST:event_validatePredefinedAddressButtonActionPerformed

    private void appendConsoleNewBlock(String input) {
        consoleTextArea.append("\n\n");
        consoleTextArea.append("-----------------------");
        consoleTextArea.append("\n\n");
        consoleTextArea.append(input);
    }

    private Integer extractNumberFromTextField(JTextField tf) {
        Integer result = null;
        try {
            result = Integer.parseInt(tf.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid shipment id! Please enter correct one.",
                    "Invalid shipment id",
                    JOptionPane.INFORMATION_MESSAGE,
                    null);
        }
        return result;
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimplePostmasterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimplePostmasterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimplePostmasterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimplePostmasterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimplePostmasterClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityView;
    private javax.swing.JTextField companyView;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JTextField contactView;
    private javax.swing.JTextField countryView;
    private javax.swing.JButton fetchByIdButton;
    private javax.swing.JButton fetchShipmentsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField phoneView;
    private javax.swing.JTextField shipmentIdTextField;
    private javax.swing.JTextField stateView;
    private javax.swing.JTextField streetView;
    private javax.swing.JButton trackButton;
    private javax.swing.JButton validatePredefinedAddressButton;
    private javax.swing.JTextField zipView;
    // End of variables declaration//GEN-END:variables
}
