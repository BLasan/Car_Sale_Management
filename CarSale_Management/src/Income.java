
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Income extends javax.swing.JFrame {
    public DefaultTableModel dm1;
    public java.util.Date dates;
    public double profit=0,kilometer=0,deduct_price=0, profit1=0,profit2=0,profit3=0,profit4=4,profit5=0,profit6=0,profit7=0,
            profit8=0,profit9=0,profit10=0,profit11=0,profit12=0,owner_income=0,init=0;
    public String vehicle_number,date,month,monthYear,pDate,rDate,pDate1;
    public int dif=0,count=0,count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0,count11=0;
    public String status1,status2,status3,status4,status5,status6,status7,status8,status9,status10,status11,status12;
    public String proDate1,proDate2,proDate3,proDate4,proDate5,proDate6,proDate7,proDate8,proDate9,proDate10,proDate11,proDate12;
    
    public Income() {
        initComponents();
        getProfit();

    }

    @SuppressWarnings("StringEquality")
    private void getProfit(){
        java.util.Date date3=new java.util.Date();
        String year=new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String url = "jdbc:sqlite:car_sale.db";
        String sql="select deduct_price,kilometer,vehicle_number,date_purchased,returned_date from customer_details";
        DecimalFormat df = new DecimalFormat("#.##");  
        Connection con;
        dm1=(DefaultTableModel)jTable1.getModel();
        PreparedStatement pstmt;
        PreparedStatement pstmts;
        PreparedStatement insertPre;
        PreparedStatement retrieve;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        DateFormat dateFormat1 = new SimpleDateFormat("MM");
	Date date1 = new Date();
        String tempDate=dateFormat.format(date1);
        
        try{
            
            String sqlOwner="select owner_payment from car_details";
            Connection cons=DriverManager.getConnection(url);
            PreparedStatement p=cons.prepareStatement(sqlOwner);
             ResultSet rss = p.executeQuery();
                        while(rss.next()){
                            
                            owner_income+=rss.getDouble("owner_payment");
                            
                        
                        }
            
  
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
        try {
            String sql2="insert or ignore into month_payment values(?,?,?)";
            
            
            con= DriverManager.getConnection(url);
            pstmt=con.prepareStatement(sql);
            ResultSet rss = pstmt.executeQuery();
                        while(rss.next()){
                            date=rss.getString("returned_date");
                            pDate=rss.getString("date_purchased");
                            
                            if(date!=null && pDate!=null){
                                
                                rDate=date.substring(8,10);
                                pDate1=pDate.substring(8,10);
                                int ret=Integer.parseInt(rDate);
                                int pur=Integer.parseInt(pDate1);
                                dif=ret-pur;
                                
                            }
                            if(date!=null){
                                monthYear=date.substring(0,7);
                                month=date.substring(5,7);
                                 try {

                       dates = dateFormat.parse(monthYear);
          
 
              } catch (ParseException e) {
                  JOptionPane.showMessageDialog(null,"Error Casting");
           } 
                                
                            }
                            vehicle_number=rss.getString("vehicle_number"); 
                            String sql1="select cost,owner_payment,cost_kilometer from car_details where vehicle_number='"+vehicle_number+"'";
                            pstmts=con.prepareStatement(sql1);
                            ResultSet rs;
                            
                            deduct_price=rss.getDouble("deduct_price");
                            kilometer=rss.getDouble("kilometer")-100*dif;
                            
                             if("01".equals(month)){
                                
                                rs=pstmts.executeQuery();
                                
                                 if(count==0){
                                   
                                   if(kilometer>=0)
                                      profit1+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit1+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit1+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit1+=(dif*rs.getDouble("cost")-deduct_price);
                                 
                                if(tempDate.equals(monthYear)){
                                
                                    status1="calculating";
                                    proDate1=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status1="Done";
                                    proDate1=monthYear;
                                }
                                
                                count++;
                            }
                            
                            else if("02".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                 if(count1==0){
                                   
                                   if(kilometer>=0)
                                      profit2+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit2+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit2+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit2+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status2="calculating";
                                    proDate2=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status2="Done";
                                    proDate2=monthYear;
                                }
                                count1++;
                            }
                             
                            else if("03".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                  if(count2==0){
                                   
                                   if(kilometer>=0)
                                      profit3+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit3+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit3+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit3+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status3="calculating";
                                    proDate3=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status3="Done";
                                    proDate3=monthYear;
                                }
                                count2++;
                            
                            }
                              
                            else if("04".equals(month)){
                                rs=pstmts.executeQuery();
                                 if(count3==0){
                                   
                                   if(kilometer>=0)
                                      profit4+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit4+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit4+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit4+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status4="calculating";
                                    proDate4=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status4="Done";
                                    proDate4=monthYear;
                                }
                                count3++;
                            
                            }
                               
                            else if("05".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                 if(count4==0){
                                   
                                   if(kilometer>=0)
                                      profit5+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit5+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit5+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit5+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status5="calculating";
                                    proDate5=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status5="Done";
                                    proDate5=monthYear;
                                }
                                count4++;
                            
                            }
                            
                            else if("06".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                  if(count5==0){
                                   
                                   if(kilometer>=0)
                                      profit6+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit6+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit6+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit6+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status6="calculating";
                                    proDate6=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status6="Done";
                                    proDate6=monthYear;
                                }
                                count5++;
                            
                            }
                            
                            else if("07".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                  if(count6==0){
                                   
                                   if(kilometer>=0)
                                      profit7+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit7+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit7+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit7+=(dif*rs.getDouble("cost")-deduct_price);
                                 
                                if(tempDate.equals(monthYear)){
                                
                                    status7="calculating";
                                    proDate7=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status7="Done";
                                    proDate7=monthYear;
                                }
                                 count6++;
                            
                            }
                            
                            else if("08".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                  if(count7==0){
                                   
                                   if(kilometer>=0)
                                      profit8+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit8+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit8+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit8+=(dif*rs.getDouble("cost")-deduct_price);
                                
                                if(tempDate.equals(monthYear)){
                                
                                    status8="calculating";
                                    proDate8=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status8="Done";
                                    proDate8=monthYear;
                                }
                                count7++;
                            
                            }
                            
                            else if("09".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                  if(count8==0){
                                   
                                   if(kilometer>=0)
                                      profit9+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit9+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit9+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit9+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status9="calculating";
                                    proDate9=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status9="Done";
                                    proDate9=monthYear;
                                }
                                count8++;
                            
                            
                            }
                            
                            else if("10".equals(month)){
                                
                                rs=pstmts.executeQuery();
                                 if(count9==0){
                                   
                                   if(kilometer>=0)
                                      profit10+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit10+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit10+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit10+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status10="calculating";
                                    proDate10=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status10="Done";
                                    proDate10=monthYear;
                                }
                                count9++;
                            
                            }
                            
                            else if("11".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                 if(count10==0){
                                   
                                   if(kilometer>=0)
                                      profit11+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit11+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit11+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit11+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status11="calculating";
                                    proDate11=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status11="Done";
                                    proDate11=monthYear;
                                }
                                count10++;
                            
                            
                            }
                            
                            else if("12".equals(month)){
                                rs=pstmts.executeQuery();
                                
                                 if(count11==0){
                                   
                                   if(kilometer>=0)
                                      profit12+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price)-owner_income;
                                    
                                   else
                                        profit12+=(dif*rs.getDouble("cost")-deduct_price);
                                 }
                                  if(kilometer>=0)
                                      profit12+=((kilometer*rs.getDouble("cost_kilometer"))+rs.getDouble("cost")-deduct_price);
                                    
                                  else
                                        profit12+=(dif*rs.getDouble("cost")-deduct_price);
                                if(tempDate.equals(monthYear)){
                                
                                    status12="calculating";
                                    proDate12=monthYear;
                                }
                                
                                else if(dates.before(date1)){
                                
                                    status12="Done";
                                    proDate12=monthYear;
                                }
                                count11++;
                            
                            }
           
                       
                        }
                        
        
         pstmt=con.prepareStatement(sql2);
         if(!("".equals(proDate1))){
         pstmt.setString(1,proDate1);
         pstmt.setDouble(2,profit1);
         pstmt.setString(3,status1);
         pstmt.executeUpdate();
         }
         
        if(!("".equals(proDate2))){
         pstmt.setString(1,proDate2);
         pstmt.setDouble(2,profit2);
         pstmt.setString(3,status2);
         pstmt.executeUpdate();
         }
        
         if(!("".equals(proDate3))){
         pstmt.setString(1,proDate3);
         pstmt.setDouble(2,profit3);
         pstmt.setString(3,status3);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate4))){
         pstmt.setString(1,proDate4);
         pstmt.setDouble(2,profit4);
         pstmt.setString(3,status4);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate5))){
         pstmt.setString(1,proDate5);
         pstmt.setDouble(2,profit5);
         pstmt.setString(3,status5);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate6))){
         pstmt.setString(1,proDate6);
         pstmt.setDouble(2,profit6);
         pstmt.setString(3,status6);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate7))){
         pstmt.setString(1,proDate7);
         pstmt.setDouble(2,profit7);
         pstmt.setString(3,status7);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate8))){
         pstmt.setString(1,proDate8);
         pstmt.setDouble(2,profit8);
         pstmt.setString(3,status8);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate9))){
         pstmt.setString(1,proDate9);
         pstmt.setDouble(2,profit9);
         pstmt.setString(3,status9);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate10))){
         pstmt.setString(1,proDate10);
         pstmt.setDouble(2,profit10);
         pstmt.setString(3,status10);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate11))){
         pstmt.setString(1,proDate11);
         pstmt.setDouble(2,profit11);
         pstmt.setString(3,status11);
         pstmt.executeUpdate();
         }
         
         if(!("".equals(proDate12))){
         pstmt.setString(1,proDate12);
         pstmt.setDouble(2,profit12);
         pstmt.setString(3,status12);
         pstmt.executeUpdate();
         }
         
         retrieve=con.prepareStatement("select * from month_payment");
         ResultSet ret = retrieve.executeQuery();
                        while(ret.next()){
                          
                            dm1.addRow(new Object[]{ret.getString("date"),df.format(ret.getDouble("profit"))
                            ,ret.getString("status")});
                        }
               
           con.close();
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PROFIT");
        setBackground(new java.awt.Color(63, 63, 63));
        setPreferredSize(new java.awt.Dimension(2147483647, 2147483647));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Profit", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Monthly Profit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Income().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
