
//Copyright @Ascitechno
//
package com.example.sony.student_attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.*;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    String s;


    public DBHelper(Context context) {
        super(context, "Attendance3", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        s = "";
        db.execSQL("CREATE TABLE IF NOT EXISTS Faculty(FId INTEGER PRIMARY KEY AUTOINCREMENT,FirstName VARCHAR,LastName VARCHAR,MobNo INT,Address VARCHAR,UserName VARCHAR,Password VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Subject(SId INTEGER PRIMARY KEY AUTOINCREMENT,SubjectName VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Course(CId INTEGER PRIMARY KEY AUTOINCREMENT,CourseName VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Branch(BId INTEGER PRIMARY KEY AUTOINCREMENT,CId INT,BranchName VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Student(SId INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR,FName VARCHAR,MobNo INT,Address VARCHAR,CId INT,BId INT,Year INT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Faculty");
        db.execSQL("DROP TABLE IF EXISTS Subject");
        db.execSQL("DROP TABLE IF EXISTS Course");
        onCreate(db);
    }

    public String save(String fn, String ln, String mob, String add, String uname, String pass) {
        int mb = Integer.parseInt(mob);
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("INSERT INTO Faculty(FirstName,LastName,MobNo,Address,UserName,Password)VALUES('" + fn + "','" + ln + "','" + mb + "','" + add + "','" + uname + "','" + pass + "');");
        } catch (Exception e) {

            s = e.toString();
        }
        return s;
    }

    public String saves(String sn) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("INSERT INTO Subject(SubjectName)VALUES('" + sn + "');");
        } catch (Exception e) {

            s = e.toString();
        }
        return s;
    }

    public String shows(String sn) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Subject", null);

        if (c.getCount() == 0) {
            s = "No records found";

        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append(c.getString(1) + "\n");
        }
        String data = buffer.toString();
        return data;

    }

    public String savec(String cn) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("INSERT INTO Course(CourseName)VALUES('" + cn + "');");
        } catch (Exception e) {

            s = e.toString();
        }
        return s;
    }

    public String showc() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Course", null);

        if (c.getCount() == 0) {
            s = "No records found";

        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append(c.getString(1) + "\n");
        }
        String data = buffer.toString();
        return data;
    }

    public String updatec(String id, String cn) {
        SQLiteDatabase db = this.getWritableDatabase();
        int eid = Integer.parseInt(id);
        try {
            Cursor c = db.rawQuery("SELECT * FROM Course WHERE CId='" + eid + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("UPDATE Course  SET CourseName ='" + cn + "' WHERE CId='" + eid + "'");
                s = "Record Modified";
            } else {
                s = "Invalid Course ID";
            }
        } catch (Exception e) {
            s = e.toString();
        }

        return s;
    }

    public String[] searchc(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        int eid = Integer.parseInt(id);
        String[] s = new String[2];
        Cursor c = db.rawQuery("SELECT * FROM Course WHERE CId='" + eid + "'", null);
        if (c.moveToFirst()) {
            s[0] = c.getString(1);
        } else {
            s[0] = "Invalid Course ID";
        }
        return s;
    }

    public String deletec(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int eid = Integer.parseInt(id);
        Cursor c = db.rawQuery("SELECT * FROM Course WHERE CId ='" + eid + "'", null);
        if (c.moveToFirst()) {
            db.execSQL("DELETE FROM Course WHERE CId ='" + eid + "'");
            s = "Record Deleted";
        } else {
            s = "Invalid Course ID ";
        }
        return s;
    }

    public List<String> showcc() {
        List<String> list = new ArrayList<String>();
        String[] s = new String[20];
        int i = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Course", null);

        if (c.getCount() == 0) {
            s[0] = "No records found";

        }

        if (c.moveToFirst()) {
            do {
                list.add(c.getString(1));//adding 2nd column data
                i=i+1;
            } while (c.moveToNext());
        }
        return list;
    }
    public String showb() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Branch", null);

        if (c.getCount() == 0) {
            s = "No records found";

        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append(c.getString(1));
            buffer.append(c.getString(2) + "\n");
        }
        String data = buffer.toString();
        return data;
    }
    public String saveb(String cn,String bn) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
        Cursor c = db.rawQuery("SELECT * FROM Course WHERE CourseName='" + cn + "'", null);
        if (c.moveToFirst()) {
            s = c.getString(0);
        }
int id=Integer.parseInt(s);
            db.execSQL("INSERT INTO Branch(CId,BranchName)VALUES('" + id + "','" + bn + "');");
        } catch (Exception e) {

            s = e.toString();
        }
        return s;
    }
    public String[] searchb(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        int eid = Integer.parseInt(id);
        String[] s = new String[2];
        Cursor c = db.rawQuery("SELECT * FROM Branch WHERE BId='" + eid + "'", null);
        if (c.moveToFirst()) {
            s[0] = c.getString(2);
            s[1]=c.getString(1);
        } else {
            s[0] = "Invalid Branch ID";
        }
        return s;
    }
    public String updateb(String id, String bn,String cn) {
        SQLiteDatabase db = this.getWritableDatabase();
       int eid = Integer.parseInt(id);
        try {
            Cursor c = db.rawQuery("SELECT * FROM Course WHERE CourseName='" + cn + "'", null);
            if (c.moveToFirst()) {
                s = c.getString(0);
            }
            int cid=Integer.parseInt(s);
            Cursor c1 = db.rawQuery("SELECT * FROM Branch WHERE BId='" + eid + "'", null);
            if (c1.moveToFirst()) {
                db.execSQL("UPDATE Branch  SET BranchName ='" + bn + "',CId='"+ cid +"' WHERE BId='" + eid + "'");
                s = "Record Modified";
            } else {
                s = "Invalid Course ID";
            }
        } catch (Exception e) {
            s = e.toString();
        }
        return s;
    }
    public String deleteb(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int eid = Integer.parseInt(id);
        Cursor c = db.rawQuery("SELECT * FROM Branch WHERE BId ='" + eid + "'", null);
        if (c.moveToFirst()) {
            db.execSQL("DELETE FROM Branch WHERE BId ='" + eid + "'");
            s = "Record Deleted";
        } else {
            s = "Invalid Branch ID ";
        }
        return s;
    }
    public List<String> showbb() {
        List<String> list = new ArrayList<String>();
        String[] s = new String[20];
        int i = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Branch", null);

        if (c.getCount() == 0) {
            s[0] = "No records found";

        }

        if (c.moveToFirst()) {
            do {  list.add(c.getString(2));//adding 2nd column data
                i=i+1;
            } while (c.moveToNext());
        }
        return list;
    }
    public String savest(String n, String fn, String mob, String add, String cname, String bname,String year) {
        int mb = Integer.parseInt(mob);
        int yr=0,cid=0,bid=0;
        SQLiteDatabase db = this.getWritableDatabase();
        if(year.equals("1st"))
            yr=1;
        else  if(year.equals("2nd"))
            yr=2;
        else  if(year.equals("3rd"))
            yr=4;
        else  if(year.equals("4th"))
            yr=4;
        try {
        Cursor c = db.rawQuery("SELECT * FROM Course WHERE CourseName='" + cname + "'", null);
        if (c.moveToFirst()) {
            s = c.getString(0);
            cid=Integer.parseInt(s);
        }
        Cursor c1 = db.rawQuery("SELECT * FROM Branch WHERE BranchName='" + bname + "'", null);
        if (c1.moveToFirst()) {
            s = c1.getString(0);
            bid=Integer.parseInt(s);
        }

            db.execSQL("INSERT INTO Student(Name,FName,MobNo,Address,CId,BId,Year)VALUES('" + n + "','" + fn + "','" + mb + "','" + add + "','" + cid + "','" + bid + "','" + yr + "');");
        } catch (Exception e) {

            s = e.toString();
        }
        return s;
    }

    public ArrayList<HashMap<String, String>> GetStudent(String cname,String bname,String year){
        int yr=0,cid=0,bid=0;
        SQLiteDatabase db = this.getWritableDatabase();
        if(year.equals("1st"))
            yr=1;
        else  if(year.equals("2nd"))
            yr=2;
        else  if(year.equals("3rd"))
            yr=3;
        else  if(year.equals("4th"))
            yr=4;
        Cursor c = db.rawQuery("SELECT * FROM Course WHERE CourseName='" + cname + "'", null);
        if (c.moveToFirst()) {
            s = c.getString(0);
            cid=Integer.parseInt(s);
        }
        Cursor c1 = db.rawQuery("SELECT * FROM Branch WHERE BranchName='" + bname + "'", null);
        if (c1.moveToFirst()) {
            s = c1.getString(0);
            bid=Integer.parseInt(s);
        }

        ArrayList<HashMap<String, String>> userList = new ArrayList<>();

        Cursor c2 = db.rawQuery("SELECT * FROM Student WHERE CId='"+ cid +"' AND BId='" + bid + "' AND Year='"+ yr +"'" , null);
        //Cursor c2 = db.rawQuery("SELECT * FROM Student" , null);
        while (c2.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",c2.getString(0));
            user.put("designation",c2.getString(1));
            user.put("location",c2.getString(2));
            userList.add(user);
        }
        return  userList;
    }
    public ArrayList<HashMap<String, String>> GetStudent1(String str){
        int sid;
        sid=Integer.parseInt(str);
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
//Cursor c2 = db.rawQuery("SELECT * FROM Student WHERE CId='"+ cid +"' AND BId='" + bid + "' AND Year='"+ yr +"'" , null);
        Cursor c2 = db.rawQuery("SELECT * FROM Student WHERE SId='"+ sid +"'" , null);
        while (c2.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",c2.getString(0));
            user.put("designation",c2.getString(1));
            user.put("location",c2.getString(2));
            userList.add(user);
        }
        return  userList;
    }
    public ArrayList<HashMap<String, String>> GetStudent2(String name){
        int yr=0,cid=0,bid=0;
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String, String>> userList = new ArrayList<>();

        Cursor c2 = db.rawQuery("SELECT * FROM Student WHERE Name LIKE '%"+name+"%' " , null);
        //Cursor c2 = db.rawQuery("SELECT * FROM Student" , null);
        while (c2.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",c2.getString(0));
            user.put("designation",c2.getString(1));
            user.put("location",c2.getString(2));
            userList.add(user);
        }
        return  userList;
    }
}
