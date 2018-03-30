package edu1.csumb.mike.Library_System;
/**
 * Title: AddBook.java
 * Abstract: This is the class for the ability to add a book to the system.
 * Author: Michael Royal
 * Date: 12/9/2016
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;


public class IssueBook extends Activity implements View.OnClickListener {

    // create a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);
    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issuebook);

        View addBookButton = findViewById(R.id.addbook_button);
        addBookButton.setOnClickListener(this);

        books = new ArrayList<>(db.getAllBooks());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    String title;
    String author;
    String isbn;
    String cost;
    double price;

    EditText titleEdit;
    EditText authorEdit;
    EditText isbnEdit;
    EditText priceEdit;

    public void onClick(View v) {

        titleEdit = (EditText) findViewById(R.id.title);
        title = titleEdit.getText().toString();

        authorEdit = (EditText) findViewById(R.id.author);
        author = authorEdit.getText().toString();

        isbnEdit = (EditText) findViewById(R.id.isbn);
        isbn = isbnEdit.getText().toString();

        priceEdit = (EditText) findViewById(R.id.price);
        cost = priceEdit.getText().toString();


        boolean containsDec = false;
        boolean bookExists = false;
        if (v.getId() == R.id.addbook_button) {
            for (Book book : books) {
                if (book.getTitle().equals(title) && book.getPrice()>=Double.parseDouble(cost)) {
                    price = Double.parseDouble(cost);
                    price = book.getPrice() - price;
                    book.setPrice(price);
                    db.updateBook(book);
                    bookExists = true;
                    break;
                }
            }
            //Check for a duplicate book in existing books
            if (bookExists) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Successfully issued book");
                dlgAlert.setTitle("Library Management System");
                dlgAlert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent I = new Intent(getApplicationContext(), Inventory.class);
                                startActivity(I);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            } else {

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Book not available");
                dlgAlert.setTitle("Library Management System");
                dlgAlert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent I = new Intent(getApplicationContext(), Inventory.class);
                                startActivity(I);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

            }
        }
    }
}