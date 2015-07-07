package com.shopping.myshop;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;


public class Database {

	
	

	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="persons_name";
	public static final String KEY_CREDIT="persons_creditleft";
	public static final String KEY_EMAIL="persons_email";
	public static final String KEY_PHONE="persons_phone";
	public static final String KEY_PASS="persons_password";
	public static final String KEY_ADDRESS="persons_address";
	public static final String KEY_ITEMNAME="item_name";
	public static final String KEY_ITEMQUANTITY="item_quantity";
	public static final String KEY_ITEMPRICE="item_price";
	private static final String DATABASE_NAME="SHOP";
	private static final String DATABASE_TABLE1="customerTable";
	private static final String DATABASE_TABLE2="stockTable";
	private static final String DATABASE_TABLE3="pass";
	public static final String KEY_ADMIN="persons_admin";
	private static final int DATABASE_VERSION=1;
  
	
	private DbHelp ourHelper;
	private SQLiteDatabase ourDatabase;
	private final Context our;
	
	private static class DbHelp extends SQLiteOpenHelper
	{

		public DbHelp(Context context) {
			super(context,DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE1 +" (" +
					   KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
					    KEY_NAME + " TEXT NOT NULL, " +
					    KEY_EMAIL + " TEXT NOT NULL, " +
					    KEY_PASS +" TEXT NOT NULL, " +
					  KEY_PHONE +" TEXT NOT NULL, " +
					 KEY_ADDRESS +" TEXT NOT NULL, " +
					  KEY_CREDIT + " TEXT NOT NULL);" 
					  );
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE2 +" (" +
					   KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_ITEMQUANTITY + " TEXT NOT NULL, " +
					   KEY_ITEMPRICE +" TEXT NOT NULL, " +
					    KEY_ITEMNAME + " TEXT NOT NULL);"
					 
					  );
			db.execSQL("CREATE TABLE "+ DATABASE_TABLE3 +" (" +
					   KEY_ROWID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_ADMIN + " TEXT NOT NULL);"
					 
					  );
					   		 							
					   		 									
		}

							   		 									
		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
			db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE1);
			db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE2);
			db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE3);
			onCreate(db);
		}
		

	
	

}
	public Database(Context c) {
		// TODO Auto-generated constructor stub
		our=c;
	}

	public  Database open() throws SQLException{
		// TODO Auto-generated method stub
		ourHelper=new DbHelp(our);
		ourDatabase=ourHelper.getWritableDatabase();
		return this;
		
	}

	public long createEntry(String name,String  email,String password,String phone,String address,String credit) throws SQLException{
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME,name);
		cv.put(KEY_CREDIT,credit);
		cv.put(KEY_EMAIL,email);
		cv.put(KEY_PHONE,phone);
		cv.put(KEY_ADDRESS, address);
		cv.put(KEY_PASS,password);
		
		
		return ourDatabase.insert(DATABASE_TABLE1, null, cv);
		}

	
	public void createEntry2(String name, String quan,String price)throws SQLException {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_ITEMNAME,name);
		cv.put(KEY_ITEMQUANTITY,quan);
		cv.put(KEY_ITEMPRICE,price);
		ourDatabase.insert(DATABASE_TABLE2, null, cv);
	
		}
	

	public void close() {
		// TODO Auto-generated method stub
		ourHelper.close();
	}


	public String getCredit(long l) throws SQLException{
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_EMAIL,KEY_PASS,KEY_PHONE,KEY_ADDRESS,KEY_CREDIT};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(6);
				return cred;
		
		}
		
		return null;
	}
	public String getQuantity(long l) throws SQLException{
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_ITEMNAME,KEY_ITEMQUANTITY,KEY_ITEMPRICE};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE2, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String quan=c.getString(2);
				return quan;
		
		}
		
		return null;
	}
	public String getName(long l) throws SQLException{
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_ITEMNAME,KEY_ITEMQUANTITY,KEY_ITEMPRICE};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE2, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String name=c.getString(1);
				return name;
		
		}
		
		return null;
	}
	public String getPrice(long l) throws SQLException{
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_ITEMNAME,KEY_ITEMQUANTITY,KEY_ITEMPRICE};;
		
		Cursor c =ourDatabase.query(DATABASE_TABLE2, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String price=c.getString(3);
				return price;
		
		}
		
		return null;
	}
	
	
	public String getData2() {
		// TODO Auto-generated method stub
String [] columns=new String []{KEY_ROWID,KEY_ITEMNAME,KEY_ITEMQUANTITY,KEY_ITEMPRICE};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE2, columns,null, null, null, null, null);
		String result="";
	
		 for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
		 {
			
			 
			 result=result + c.getString(0)+"               "+c.getString(1)+ "          " + c.getString(2) +"               "+c.getString(3)+"\n";
           		
		 }
		
		return result;
	}
	public String getData() {
		// TODO Auto-generated method stub
		String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_EMAIL,KEY_PASS,KEY_PHONE,KEY_ADDRESS,KEY_CREDIT};
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns,null, null, null, null, null);
		String result="";
	
		 for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
		 {
			
			 
			 result= result +"CUSTOMER ID:"+ c.getString(0)+"\n"+ "NAME:"+
			        c.getString(1)+"\n"+ "EMAIL ID:"+c.getString(2)+"\n"+"PHONE NO:"+c.getString(4)+"\n"+"ADDRESS:"+ c.getString(5) +"\n"+ "CREDIT(in Rs):"+c.getString(6)+"\n\n\n" ;
           		
		 }
		
		return result;
	}
	

	public void updateCredit(Long lr, String credit) throws SQLException{
		// TODO Auto-generated method stub
		
		ContentValues cvUpdate=new ContentValues();
		
		cvUpdate.put(KEY_CREDIT,credit);
		
		
		ourDatabase.update(DATABASE_TABLE1, cvUpdate, KEY_ROWID + "=" + lr, null);
	}

		
	
	public void deleteEntry(Long lr) throws SQLException{
		// TODO Auto-generated method stub
      
		ourDatabase.delete(DATABASE_TABLE1, KEY_ROWID + "=" + lr, null);
	}

	public void updateQuantity(long l2, String upquan) throws SQLException {
		// TODO Auto-generated method stub
ContentValues cvUpdate=new ContentValues();
		
		cvUpdate.put(KEY_ITEMQUANTITY,upquan);
		
		
		ourDatabase.update(DATABASE_TABLE2, cvUpdate, KEY_ROWID + "=" + l2, null);
		
		
	}

	public String getPassword(Long l) throws SQLException{
		// TODO Auto-generated method stub
		
String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_EMAIL,KEY_PASS,KEY_PHONE,KEY_ADDRESS,KEY_CREDIT};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(3);
				return cred;
		
		}
		
		
		return null;
	}

	public String getEmail(Long id) throws SQLException {
		// TODO Auto-generated method stub
String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_EMAIL,KEY_PASS,KEY_PHONE,KEY_ADDRESS,KEY_CREDIT};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE1, columns, KEY_ROWID + "=" + id, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(2);
				return cred;
		
		}
		
		return null;
	}

	public String getpass(int i) throws SQLException {
		// TODO Auto-generated method stub
		
		
String [] columns=new String []{KEY_ROWID,KEY_ADMIN};
		
		Cursor c =ourDatabase.query(DATABASE_TABLE3, columns, KEY_ROWID + "=" + i, null, null, null, null);
		if(c!=null)
		{
		c.moveToFirst()	;
		String cred=c.getString(1);
				return cred;
		
		}
		
		
		return null;
	}

	public void updatepass(int i, String newpass) throws SQLException{
		// TODO Auto-generated method stub
ContentValues cvUpdate=new ContentValues();
		
		cvUpdate.put(KEY_ADMIN,newpass);
		
		
		ourDatabase.update(DATABASE_TABLE3, cvUpdate, KEY_ROWID + "=" + i, null);
	}

	public void createadmin(String id)throws SQLException {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_ADMIN,id);
		
		ourDatabase.insert(DATABASE_TABLE3, null, cv);
		
	}


	
	

	
	
}