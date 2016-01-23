package com.herotculb.qunhaichat.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper helper;  
    private SQLiteDatabase db;
    
    public DBManager(Context context) {  
        helper = new DBHelper(context);  
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);  
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里  
        db = helper.getWritableDatabase();  
    } 
    
    /** 
     * add persons 
     * @param persons 
     */  
    public void add(List<Person> persons) {  
        db.beginTransaction();  //开始事务  
        try {  
            for (Person person : persons) {  
                db.execSQL("INSERT INTO person VALUES(null, ?, ?)", new Object[]{person.name, person.phone});  
            }  
            db.setTransactionSuccessful();  //设置事务成功完成  
        } finally {  
            db.endTransaction();    //结束事务  
        }  
    }
    
    /** 
     * query all persons, return list 
     * @return List<Person> 
     */  
    public List<Person> query() {  
        ArrayList<Person> persons = new ArrayList<Person>();  
        Cursor c = queryTheCursor();  
        while (c.moveToNext()) {  
            Person person = new Person();  
            person._id = c.getInt(c.getColumnIndex("_id"));  
            person.name = c.getString(c.getColumnIndex("name"));  
            person.phone = c.getString(c.getColumnIndex("phone"));  
            persons.add(person);  
        }  
        c.close();  
        return persons;  
    }
    
    /** 
     * query all persons, return cursor 
     * @return  Cursor 
     */  
    public Cursor queryTheCursor() {  
        Cursor c = db.rawQuery("SELECT * FROM person", null);  
        return c;  
    } 
    
    /** 
     * close database 
     */  
    public void closeDB() {  
        db.close();  
    }
    
}
