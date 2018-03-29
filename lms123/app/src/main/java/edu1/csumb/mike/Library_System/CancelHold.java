package edu1.csumb.mike.Library_System;
/**
 * Title: CancelHold.java
 * Abstract: This is the class for the ability to cancel a hold placed in the system.
 * Author: Michael Royal
 * Date: 12/9/16
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class CancelHold extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    // creates a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);
    ArrayList<Transaction> transactions;
    ArrayList<Transaction> userRentals;
    ArrayList<String> titles;

    public String bookToCancel;
    public int pickUpDay;
    public int dropDay;
    public int transactionID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create a spinner with each transaction for the persons sign in
        //depending on the choice delte the dates within the choice for the book

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelhold);
        TextView main = (TextView) findViewById(R.id.mainText);

        View cancel = findViewById(R.id.cancel);//for search button
        cancel.setOnClickListener(this);
        View issuebook = findViewById(R.id.issuebook);//for search button
        issuebook.setOnClickListener(this);
        View logout = findViewById(R.id.logout_button);
        logout.setOnClickListener(this);

        //***GET PASSED INFO***
        Bundle extras = getIntent().getExtras();
        String loggedUser = extras.getString("username");


        //Get All Transactions
        transactions = new ArrayList<>(db.getAllTransactions());
        //Rentals belonging to the user
        userRentals = new ArrayList<>();
        //Titles Strings for Spinner
        titles = new ArrayList<>();

        //Go through each transaction and add to rentals and titles if it is active and is of type rental
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getUsername().equals(loggedUser) && transactions.get(i).getTypeNumber() == 1
                    && transactions.get(i).getActive() == 1) {
                userRentals.add(new Transaction(transactions.get(i)));
                titles.add(transactions.get(i).getId() + " " + transactions.get(i).getTitle() + "Date: " + transactions.get(i).getDate());
            }
            if (transactions.get(i).getUsername().equals(loggedUser)) {
                main.append(transactions.get(i).getUsername());
            }
        }

        //Transactions Spinner
        Spinner spinner = (Spinner) findViewById(R.id.transactions_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, titles);
        // Specify the layout to use when the list of choices appears
        titleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(titleAdapter);
        spinner.setOnItemSelectedListener(this);

      /*  if(userRentals.size()<=0){
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("No Active Rentals For This User.\n Press ok to return to main menu!");
            dlgAlert.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent I = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(I);
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }*/
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

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub

        if (arg0.getId() == R.id.transactions_spinner) {
            System.out.println("IN HERE TESTTEST" + userRentals.toString());
            Object item = arg0.getItemAtPosition(arg2);
            String test = item.toString();


            for (int i = 0; i < userRentals.size(); i++) {

                String compare = userRentals.get(i).getId() + " " + userRentals.get(i).getTitle() + "Date: " + userRentals.get(i).getDate();

                System.out.println("COMPARE TESTTEST " + i + ": |" + compare + "| Item: |" + item + "|match: " + (compare.equals(test)));

                if (compare.equals(test)) {
                    TextView main = (TextView) findViewById(R.id.mainText);

                    main.setText("");
                    main.append("Reservation Number: " + userRentals.get(i).getReservation() + "\n");
                    main.append("Title: " + userRentals.get(i).getTitle() + "\n");
                    main.append(userRentals.get(i).getType() + "\n");
                    main.append("Date: " + userRentals.get(i).getDate() + "\n");
                    main.append("Time: " + userRentals.get(i).getTime() + "\n");
                    main.append("Pick Up: " + userRentals.get(i).getPickUpDate() + "\n");
                    main.append("Return: " + userRentals.get(i).getDropOffDate() + "\n");

                    bookToCancel = userRentals.get(i).getTitle();

                    pickUpDay = userRentals.get(i).getPickDayYear();
                    dropDay = userRentals.get(i).getDropDayYear();

                    //userRentals.get(i).setActive(0);
                    //db.updateTransaction(new Transaction(userRentals.get(i)));

                    transactionID = userRentals.get(i).getId();
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
        // your code here
    }

    public void onClick(View v) {
        if (v.getId() == R.id.logout_button) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Successfully Logged Out");
            dlgAlert.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent I = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(I);
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
        else if (v.getId() == R.id.issuebook) {
            Intent I = new Intent(getApplicationContext(), IssueBook.class);
            startActivity(I);
        }
        else if (v.getId() == R.id.cancel) {
            Intent I = new Intent(getApplicationContext(), Inventory.class);
            startActivity(I);
        }
    }
}

