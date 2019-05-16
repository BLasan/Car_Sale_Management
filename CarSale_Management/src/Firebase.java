
import java.util.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import static com.google.firebase.database.DatabaseReference.goOnline;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;


public class Firebase {
    public static Connection conn;
    public static int leap_year=0;
    public static double owner_payment,cost,cost_kilometer,deduct_price,start_meter,end_meter,kilometer,profit;
    public static int owner_contact,customer_contact,record_id=0;
    public static String vehicle_number,vehicle_brand,owner_id,owner_name,owner_address,date,status;
    public static String customer_name,customer_address,customer_nic,date_purchased,time_purchased,returned_date,returned_time;
    public static void main(String[] args)  {
           try{
 String timeStamp = new SimpleDateFormat("MM-dd").format(Calendar.getInstance().getTime());
 String year=new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
       
//FileInputStream serviceAccount =new FileInputStream("carsale-1293b-firebase-adminsdk-eus70-a70f8ad932.json");
FileInputStream serviceAccount =new FileInputStream("car-sale-6e014-firebase-adminsdk-o7818-8d763384ea.json");


/*FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://carsale-1293b.firebaseio.com/")
  .build();*/

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://car-sale-6e014.firebaseio.com/")
  .build();
FirebaseApp.initializeApp(options);
goOnline();

        CountDownLatch done = new CountDownLatch(1);
        
        
         FirebaseDatabase.getInstance().getReference("vehicle_details").setValue("", new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                          
                           FirebaseDatabase.getInstance().getReference("customer_details").setValue("", new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                            
                            FirebaseDatabase.getInstance().getReference("month_payment").setValue("", new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                            
      
        String url = "jdbc:sqlite:car_sale.db";
        String sql="select * from car_details";
        String sql1="select * from customer_details";
        String sql2="select * from month_payment";
        PreparedStatement pstmt,pstmt1;
        
        try {
            conn = DriverManager.getConnection(url);
            pstmt=conn.prepareStatement(sql);
            ResultSet rss = pstmt.executeQuery();
           
                                   while(rss.next()){
                           
                           vehicle_number=rss.getString("vehicle_number");
                           vehicle_brand=rss.getString("vehicle_brand");
                           owner_id=rss.getString("owner_id");
                           owner_name=rss.getString("owner_name");
                           owner_contact=rss.getInt("owner_contact");
                           owner_address=rss.getString("owner_address");
                           owner_payment=rss.getDouble("owner_payment");
                           cost=rss.getDouble("cost");
                           cost_kilometer=rss.getDouble("cost_kilometer");
                           date_purchased=rss.getString("borrowed_date");
                           returned_date=rss.getString("returned_date");
                           
                               
                            FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("vehicle_number").setValue(rss.getString("vehicle_number"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                            
                             
                          
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("vehicle_brand").setValue(rss.getString("vehicle_brand"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                             
                                   
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("owner_id").setValue(rss.getString("owner_id"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("owner_name").setValue(rss.getString("owner_name"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                            
                              }

                             });
                             
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("owner_contact").setValue(rss.getInt("owner_contact"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                               
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("owner_address").setValue(rss.getString("owner_address"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                            
                                     
                                     
                            
                           
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("owner_payment").setValue(rss.getDouble("owner_payment"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("cost").setValue(rss.getDouble("cost"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("cost_kilometer").setValue(rss.getDouble("cost_kilometer"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              done.countDown();
                              }

                             });
                             
                             
                             
                              FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("borrowed_date").setValue(rss.getDouble("borrowed_date"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              done.countDown();
                              }

                             });
                              
                               FirebaseDatabase.getInstance().getReference("/vehicle_details/"+vehicle_number).child("returned_date").setValue(rss.getDouble("returned_date"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              done.countDown();
                              }

                             });
                             done.await();  
                                     
                                    
                        
                        }
                        
                        
          pstmt1=conn.prepareStatement(sql1);
          ResultSet rss1=pstmt1.executeQuery();
         while(rss1.next()){
              customer_name=rss1.getString("customer_name");
              customer_address=rss1.getString("customer_address");
              customer_nic=rss1.getString("customer_nic");
              vehicle_number=rss1.getString("vehicle_number");
              date_purchased=rss1.getString("date_purchased");
              time_purchased=rss1.getString("time_purchased");
              returned_date=rss1.getString("returned_date");
              returned_time=rss1.getString("returned_time");
              customer_contact=rss1.getInt("customer_contact");
              start_meter=rss1.getDouble("start_meter");
              end_meter=rss1.getDouble("end_meter");
              kilometer=rss1.getDouble("kilometer");
              deduct_price=rss1.getDouble("deduct_price");
              
              
              
                            FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("customer_name").setValue(rss1.getString("customer_name"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                            
                             
                          
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("customer_address").setValue(rss1.getString("customer_address"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                             
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("vehicle_number").setValue(rss1.getString("vehicle_number"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("deduct_price").setValue(rss1.getDouble("deduct_price"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                            
                              }

                             });
                             
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("date_purchased").setValue(rss1.getString("date_purchased"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                               
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("time_purchased").setValue(rss1.getString("time_purchased"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                            
                                     
                                     
                            
                           
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("returned_date").setValue(rss1.getString("returned_date"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("returned_time").setValue(rss1.getString("returned_time"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                         
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("customer_contact").setValue(rss1.getInt("customer_contact"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                            
                             
                              
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("start_meter").setValue(rss1.getDouble("start_meter"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                             
                             
                              
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("end_meter").setValue(rss1.getDouble("end_meter"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                             
                              
                             FirebaseDatabase.getInstance().getReference("/customer_details/"+customer_nic).child("kilometer").setValue(rss1.getDouble("kilometer"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              done.countDown();
                              }

                             });
                         
                             done.await();  
                                     
              
        
              
          }
          
          pstmt1=conn.prepareStatement(sql2);
          ResultSet rss2=pstmt1.executeQuery();
          while(rss2.next()){
              
              date=rss2.getString("date");
              profit=rss2.getDouble("profit");
              status=rss2.getString("status");
              
              
             FirebaseDatabase.getInstance().getReference("/month_payment/"+date).child("date").setValue(date, new DatabaseReference.CompletionListener() {
             @Override
             public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                 
                              }

                             });
                             
                            
                             
                          
             FirebaseDatabase.getInstance().getReference("/month_payment/"+date).child("profit").setValue(profit, new DatabaseReference.CompletionListener() {
                    @Override
              public void onComplete(DatabaseError de, DatabaseReference dr) {
                             done.countDown();
                              }

                             });
             
               FirebaseDatabase.getInstance().getReference("/month_payment/"+date).child("status").setValue(status, new DatabaseReference.CompletionListener() {
                    @Override
              public void onComplete(DatabaseError de, DatabaseReference dr) {
                             done.countDown();
                              }

                             });
             
             
             
                done.await();
                
                
            
                
          }
          
          String sql3="select * from delete_records";
          pstmt1=conn.prepareStatement(sql3);
          ResultSet rss3=pstmt1.executeQuery();
          while(rss3.next()){
                           
                           record_id=rss3.getInt("del_no");
                           vehicle_number=rss3.getString("vehicle_number");
                           vehicle_brand=rss3.getString("vehicle_brand");
                           owner_id=rss3.getString("owner_id");
                           owner_name=rss3.getString("owner_name");
                           owner_contact=rss3.getInt("owner_contact");
                           owner_address=rss3.getString("owner_address");
                           owner_payment=rss3.getDouble("owner_payment");
                           cost=rss3.getDouble("cost");
                           cost_kilometer=rss3.getDouble("cost_kilometer");
                           date_purchased=rss3.getString("borrowed_date");
                           returned_date=rss3.getString("returned_date");
                          
              
                            FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("vehicle_number").setValue(rss3.getString("vehicle_number"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                            
                             
                          
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("vehicle_brand").setValue(rss3.getString("vehicle_brand"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                             
                         
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("owner_id").setValue(rss3.getString("owner_id"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("owner_name").setValue(rss3.getString("owner_name"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                            
                              }

                             });
                             
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("owner_contact").setValue(rss3.getInt("owner_contact"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                               
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("owner_address").setValue(rss3.getString("owner_address"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                            
                                     
                                     
                            
                           
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("owner_payment").setValue(rss3.getDouble("owner_payment"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("cost").setValue(rss3.getDouble("cost"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                           
                                     
                                     
                            
                            
                             FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("cost_kilometer").setValue(rss3.getDouble("cost_kilometer"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                             
                             
                             
                              FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("borrowed_date").setValue(rss3.getDouble("borrowed_date"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                              
                              }

                             });
                              
                               FirebaseDatabase.getInstance().getReference("/delete_rocords/"+record_id).child("returned_date").setValue(rss3.getDouble("returned_date"), new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError de, DatabaseReference dr) {
                             
                              }

                             });
                            
                                     
                             
          }
          
                     
          
          JOptionPane.showMessageDialog(null,"Uploaded");
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Empty Result Set");
        }
    
        try {
            conn.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error Closing");
        }
        
       FirebaseApp.getInstance().delete();

           }
           catch(Exception e){
               
           JOptionPane.showMessageDialog(null,e);
}
    
    
    
    
    
   
    
    }}
