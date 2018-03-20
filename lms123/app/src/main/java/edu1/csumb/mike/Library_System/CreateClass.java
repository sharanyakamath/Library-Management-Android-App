package edu1.csumb.mike.Library_System;
/**
 * Title: CreateClass.java
 * Abstract: This is the class for the ability to add a user to the system.
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
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateClass extends Activity implements View.OnClickListener {

    // creates a database for the app
    MySQLiteHelper db = new MySQLiteHelper(this);
    //Allow only two attempts at creating an account
    //this is the counter
    public int tryFail = 1;
    public int tryFailFormat =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);

        View CreateButton = findViewById(R.id.createaccount_button);
        CreateButton.setOnClickListener(this);
        View help = findViewById(R.id.help_button);
        help.setOnClickListener(this);

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

    public void onClick(View v) {
        String input1;
        String input2;
        String input3;
        String input4;
        EditText cinput1;
        EditText cinput2;
        EditText cinput3;
        EditText cinput4;


        cinput1 = (EditText) findViewById(R.id.username_field);
        input1 = cinput1.getText().toString();

        cinput2 = (EditText) findViewById(R.id.password_field);
        input2 = cinput2.getText().toString();

        cinput3 = (EditText) findViewById(R.id.name_field);
        input3 = cinput1.getText().toString();

        cinput4 = (EditText) findViewById(R.id.email_field);
        input4 = cinput1.getText().toString();

        if (v.getId() == R.id.help_button)
        {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("->Enter your name in the name field\n->Enter the username you want to keep for the app\n->Enter a valid email id\n->Create a strong password at least 6 characters long with at least 1 special character and 1 number");
            dlgAlert.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent I = new Intent(getApplicationContext(), CreateClass.class);
                            startActivity(I);
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
        else if (v.getId() == R.id.createaccount_button) {
            //Check if the inputs are formatted correctly and no duplicate accounts
            //uses duplicate Check Method
            //Successful Attempt at making a username
            if(checkFormat(input2)){

                if (userDuplicateCheck(input1)) {
                    //Create a new user using the inputs
                    User user = new User(input3, input1, input4, input2);
                    db.addUser(user);

                    //Create a timestamp
                    TimeStamp timeStamp = new TimeStamp();

                    //Create a new transaction
                    Transaction transactionNew = new Transaction(user.getUsername(), 3, timeStamp.getDate(), timeStamp.getTime());
                    db.addTransaction(transactionNew);

                    //Alert Success
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Successfully Created Account");
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
                //Second and last chance to create a username for duplicate
                else if (!userDuplicateCheck(input1) && tryFail < 2) {
                    tryFail++;
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Username already Exists, Try once more.");
                    dlgAlert.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
                //Exceeds attempts for duplicate username
                else if (!userDuplicateCheck(input1) && tryFail == 2) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Username already Exists.");
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
            }
            else {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Password should be at least 6 characters long with at least 1 special character and 1 number");
                dlgAlert.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent I = new Intent(getApplicationContext(), CreateClass.class);
                                startActivity(I);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
            //Format is not correct second chance.
	    	 /*   else if(userDuplicateCheck(input1)&&tryFailFormat<2){
	    			tryFailFormat++;
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
				dlgAlert.setMessage("Your Username or Password are not correctly formatted! last chance.");
				dlgAlert.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
							}
						});
				dlgAlert.setCancelable(true);
				dlgAlert.create().show();
			}
			//Format is not correct.
			else if(userDuplicateCheck(input1)&&tryFailFormat==2){
				AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
				dlgAlert.setMessage("Your Username or Password are not correctly formatted!");
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
    }

    //Method to check format for Special characters and atleast 3 Letters
    public boolean checkFormat(String password){

        ArrayList<Character> charList = new ArrayList<Character>();
        ArrayList<Character> numList = new ArrayList<Character>();
        Collections.addAll(charList, '!', '$', '#', '@');
        Collections.addAll(numList, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        //Check for special Character
        boolean containsSpecial = false;
        for(Character character: charList) {
            if (password.contains(Character.toString(character))) {
                containsSpecial = true;
            }
        }
        //Check for numbers
        boolean containsNumber = false;
        for(Character character: numList) {
            if (password.contains(Character.toString(character))) {
                containsNumber = true;
            }
        }
        //Check for Letters
        int numberCharacters = 0;
        if(containsSpecial && containsNumber){
            for(int i=0; i<password.length();i++){
                String symbol = String.valueOf(password.charAt(i));

                //REGEX pattern Check
                Pattern pattern = Pattern.compile("[A-z]");
                Matcher matcher = pattern.matcher(symbol);

                if(matcher.matches()){
                    numberCharacters++;
                    System.out.println("Match: " + numberCharacters);
                }
            }
        }

        if(numberCharacters>5){
            return true;
        }
        else {
            return false;
        }
    }

    //Method to check if username exists
    public boolean userDuplicateCheck(String username){
        ArrayList<User> users = new ArrayList<>(db.getAllUsers());

        for(User user : users){
            if(user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

}