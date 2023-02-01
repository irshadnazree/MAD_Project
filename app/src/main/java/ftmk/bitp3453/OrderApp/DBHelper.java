package ftmk.bitp3453.OrderApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("PRAGMA foreign_key = ON");
        DB.execSQL("create Table Userdetails(userNum integer primary key, name TEXT, phoneNo TEXT unique)");
        DB.execSQL("create Table OrderMade(orderNum integer primary key, numSandwich integer, numCoffee integer, userNum integer, foreign key (userNum) references Userdetails (userNum) ON UPDATE cascade on delete cascade)");
        DB.execSQL("create Table Receipt(receiptNum integer primary key, tpSandwich decimal, tpCoffee decimal, orderNum integer, foreign key (orderNum) references Userdetails (orderNum))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
        DB.execSQL("drop Table if exists OrderMade");
        DB.execSQL("drop Table if exists Receipt");
    }

    public Boolean checkUserDetails(String name, String phoneNo){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where name = ? and phoneNo = ?", new String[] {name, phoneNo});

        if (cursor.getCount() > 0)  // if the data exists then return true
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    //insert data command into sqlite
    public Boolean insertUserData(String name, String phoneNo){
        SQLiteDatabase DB = this.getWritableDatabase();

        //insert values inside table
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phoneNo", phoneNo);

        //db.insert function
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public int fetch_phoneNo(String phoneNo) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where phoneNo = '"+phoneNo +"'" , null);

        if(cursor.moveToFirst()){
            do{
                return cursor.getInt(0);

            }while (cursor.moveToNext());
        }
        else
            return -1;

    }

    public String getID() {
        SQLiteDatabase DB = this.getReadableDatabase();

        //cursor = selecting data
        Cursor cursor = DB.rawQuery("Select userNum from Userdetails", null);

        if (cursor != null && cursor.moveToFirst()) {
            String id = cursor.getString(0);
            cursor.close();
            return id;
        }
        DB.close();
        return null;
    }

    public Boolean insertOrderMade(String numSandwich, String numCoffee){
        SQLiteDatabase DB = this.getWritableDatabase();

        //insert values inside table
        ContentValues contentValues = new ContentValues();
        contentValues.put("numSandwich", numSandwich);
        contentValues.put("numCoffee", numCoffee);

        if ("userNum" != null) {
            contentValues.put("userNum", getID());
        }

        //db.insert function
        long result=DB.insert("OrderMade", null, contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }



//    @SuppressLint("Range")
//    public Order getID(int orderNum){
//        Order order = new Order();
//        Cursor cursor = this.getReadableDatabase().rawQuery("Select * from OrderMade where orderNum = ?", null);
//        if(cursor.moveToFirst())
//        {
//            do {
//
//                order.setNumSandwich(Integer.parseInt(cursor.getString(cursor.getColumnIndex("numSandwich"))));
//                order.setNumCoffee(Integer.parseInt(cursor.getString(cursor.getColumnIndex("numCoffee"))));
//
//            }while(cursor.moveToNext());
//        }
//        return order;
//    }

    //update data command into sqlite
//    public Boolean updateOrderData(String numSandwich, String numCoffee){
//        SQLiteDatabase DB = this.getWritableDatabase();
//
//        //update values inside table
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("numSandwich", numSandwich);
//        contentValues.put("numCoffee", numCoffee);
//
//        //cursor = selecting data
//        Cursor cursor = DB.rawQuery("Select * from OrderMade where orderNum = ?", null);
//        if(cursor.getCount()>0) {
//
//            //db.update function
//            long result = DB.update("OrderMade", contentValues, "orderNum=?",null);
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        else{
//            return false;
//        }
//    }

    public String getOID() {
        SQLiteDatabase DB = this.getReadableDatabase();

        String oid = "";
        //cursor = selecting data
        Cursor cursor = DB.rawQuery("Select orderNum from OrderMade where userNum = ?", new String[]{getID()});

        if (cursor != null && cursor.moveToLast()) {
            oid = cursor.getString(0);
        }

        cursor.close();
        DB.close();
        return oid;
    }

//    public boolean updateOrder1(String numS, String numC){
//        SQLiteDatabase DB = this.getWritableDatabase();
//
//        //update values
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("numSandwich", numS);
//        contentValues.put("numCoffee", numC);
//
//        Cursor cursor = DB.rawQuery("Select * from OrderMade where orderNum = ?", getOID());
//
//        if(cursor.getCount()>0) {
//            //db.update function
//            long result = DB.update("OrderMade", contentValues, "orderNum=?", getOID());
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        else{
//            return false;
//        }
//    }

//    public boolean updateOrder(String numS, String numC){
//        SQLiteDatabase DB = this.getWritableDatabase();
//
//        //update values
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("numSandwich", numS);
//        contentValues.put("numCoffee", numC);
//
//        Cursor cursor = DB.rawQuery("Select * from OrderMade", null);
//
//        if(cursor.getCount()>0) {
//            //db.update function
//            long result = DB.update("OrderMade", contentValues, "orderNum = ?", new String[]{getOID()});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        else{
//            return false;
//        }
//    }

    public String getCurrentId() {
        String oid = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("OrderMade", new String[] { "orderNum" },null, null, null, null, null, null);

        if (cursor != null && cursor.moveToLast()) {
            oid = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return oid;
    }

    public Boolean updateOrder(String numS, String numC) {
        SQLiteDatabase DB = this.getReadableDatabase();
        String oid = getCurrentId();

        if (!oid.equals("")) {
            DB.close();
            DB = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("numSandwich", numS);
            contentValues.put("numCoffee", numC);

            DB.update("OrderMade", contentValues, "orderNum = ?", new String[] { oid });
        }
        DB.close();
        return true;
    }


//    public boolean updateOrder(String numS, String numC) {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        //Cursor cursor = DB.query("OrderMade", new String[] {"orderNum"}, "numSandwich=?", new String[] {"numSandwich"}, null, null, null, null);
//        Cursor cursor = DB.rawQuery("Select * from OrderMade where orderNum=?", null);
//
//        if(cursor != null && cursor.moveToFirst()) {
//            String oid = cursor.getString(0);
//            cursor.close();
//            DB.close();
//            DB = this.getWritableDatabase();
//
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("numSandwich", numS);
//            contentValues.put("numCoffee", numC);
//
//            DB.update("OrderMade", contentValues, "orderNum", new String[] { oid });
//        }
//        DB.close();
//        return true;
//    }

    public Boolean insertReceipt(double oQuantity, double tPrice){
        SQLiteDatabase DB = this.getWritableDatabase();

        //insert values inside table
        ContentValues contentValues = new ContentValues();
        contentValues.put("orderQty", oQuantity);
        contentValues.put("totalPrice", tPrice);

        if ("orderNum" != null) {
            contentValues.put("orderNum", String.valueOf(new String[]{String.valueOf(getOID())}));
        }

        //db.insert function
        long result=DB.insert("Receipt", null, contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //delete data command into sqlite
//    public Boolean deleteOrderData(){
//        SQLiteDatabase DB = this.getWritableDatabase();
//
//        //cursor = selecting data
//        Cursor cursor = DB.rawQuery("Select * from OrderMade where orderNum = ?", getOID());
//
//        if(cursor.getCount()>0) {
//            //db.delete function
//            long result = DB.delete("OrderMade", "orderNum=?", getOID());
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//        else{
//            return false;
//        }
//    }


    //view data command into sqlite
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();

        //cursor = selecting data
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        if(cursor.moveToFirst())
        {
            do {
            }while(cursor.moveToNext());
        }

        return cursor;
    }


//
//    @SuppressLint("Range")
//    public Order fnGetOrder(String userNo)
//    {
//        Order order = new Order();
//        try (Cursor cursor = this.getReadableDatabase().rawQuery("Select * from OrderMade where userNo = ?", new String[]{userNo})) {
//            if (cursor.moveToFirst()) {
//                do {
//
//                    String intNumSandwich = cursor.getString(cursor.getColumnIndex(("numSandwich")));
//                    String intNumCoffee = cursor.getString(cursor.getColumnIndex(("numCoffee")));
//
//                    order = new Order(intNumSandwich, intNumCoffee);
//
//                } while (cursor.moveToNext());
//            }
//        }
//        return order;
//    }
}
