/******************************************************************
 * Name           : Palaniappan Ramiah
 * ZID            : Z1726972
 * Class          : Android
 * Assignment No. : Graduate Project
 * Program Name   : DbAdapter.java
 * Description    : Db class to store the questions
 * Due Date       : 04/30/2015 11:59:59 pm
 *****************************************************************/

package edu.niu.cs.z1726972.grad_project;

// Importing all the required packages
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter extends SQLiteOpenHelper {

    private SQLiteDatabase dBase;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Quiz"; // Database Name
    private static final String TABLE_QUESTION = "question_table"; // Table name

    // Table Columns names
    private static final String KEY_QUESTION_ID = "id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer"; // Correct option
    private static final String KEY_OPTIONA= "optionA"; // Option a
    private static final String KEY_OPTIONB= "optionB"; // Option b
    private static final String KEY_OPTIONC= "optionC"; // Option c
    private static final String KEY_OPTIOND= "optionD"; // Option d

    public DbAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dBase = db;
        // Creating the questions table
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESTION
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+ KEY_OPTIONA + " TEXT, "+ KEY_OPTIONB
                + " TEXT, " + KEY_OPTIONC + " TEXT, " + KEY_OPTIOND + " TEXT)";
        db.execSQL(sql);
        addQuestions();
    }

    // Method to add questions to the DB
    private void addQuestions()
    {
        Question q1 = new Question("Which of the following languages is more suited to a structured program of network equipment?"
                ,"Ruby", "Python", "BASIC", "PASCAL", "PASCAL");
        this.addQuestion(q1);

        Question q2 = new Question("Which of the following is NOT an operating system?"
                ,"SuSe", "BIOS", "DOS", "Unix", "BIOS");
        this.addQuestion(q2);

        Question q3 = new Question("Which of the following is the fastest writable memory?"
                ,"RAM", "FLASH", "ROM", "Register", "Register");
        this.addQuestion(q3);

        Question q4 = new Question("Which of the following computer language is used for artificial intelligence?"
                ,"FORTRAN", "PROLOG", "C", "COBOL", "PROLOG");
        this.addQuestion(q4);

        Question q5 = new Question("Which of the following is NOT an interpreted language?"
                ,"Ruby", "Python", "BASIC", "PASCAL", "BASIC");
        this.addQuestion(q5);

        Question q6 = new Question("Which of the following is the 1's complement of 10?"
                ,"01", "10", "11", "110", "01");
        this.addQuestion(q6);

        Question q7 = new Question("Which part interprets program instructions and initiate control operations?"
                ,"Input", "Storage unit", "Logic unit", "Control unit", "Control unit");
        this.addQuestion(q7);

        Question q8 = new Question("The binary system uses powers of ___"
                ,"8", "10", "2", "16", "2");
        this.addQuestion(q8);

        Question q9 = new Question("A computer program that converts assembly language to machine language is"
                ,"Assembler", "Compiler", "Interpreter", "Comparator", "Assembler");
        this.addQuestion(q9);

        Question q10 = new Question("Which access method is used for obtaining a record from a cassette tape?"
                ,"Random", "Sequential", "Direct", "All of the above", "Sequential");
        this.addQuestion(q10);
    }

    // Adding new question
    public void addQuestion(Question ques) {

        ContentValues values = new ContentValues();

        values.put(KEY_QUESTION, ques.getQuestion());
        values.put(KEY_ANSWER, ques.getAnswer());
        values.put(KEY_OPTIONA, ques.getOptionA());
        values.put(KEY_OPTIONB, ques.getOptionB());
        values.put(KEY_OPTIONC, ques.getOptionC());
        values.put(KEY_OPTIOND, ques.getOptionD());

        // Inserting a question into the row
        dBase.insert(TABLE_QUESTION, null, values);
    }

    // Method to fetch all the questions from DB
    public List<Question> getAllQuestions() {

        List<Question> questionsList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION; // Select All Query
        dBase = this.getReadableDatabase();
        Cursor cursor = dBase.rawQuery(selectQuery, null);

        // Looping through all rows and adding it to the list
        if (cursor.moveToFirst()) {
            do {
                Question ques = new Question();
                ques.setQuestionId(cursor.getInt(0));
                ques.setQuestion(cursor.getString(1));
                ques.setAnswer(cursor.getString(2));
                ques.setOptionA(cursor.getString(3));
                ques.setOptionB(cursor.getString(4));
                ques.setOptionC(cursor.getString(5));
                ques.setOptionD(cursor.getString(6));
                questionsList.add(ques);
            } while (cursor.moveToNext());
        }
        return questionsList; // Return questions list
    }

    @Override
    // Method if the table needs to update
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION); // Drop older table if existed
        onCreate(db); // Create tables again
    }
}