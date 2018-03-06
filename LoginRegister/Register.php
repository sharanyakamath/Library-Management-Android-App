<?php
    require("password.php");
    $connect = mysqli_connect("localhost", "id4957652_logreg", "LoginRegister", "id4957652_loginregister");
    $roll_no = $_POST["roll_no"];
    $username = $_POST["username"];
    $email = $_POST["email"];
    $password = $_POST["password"];
     function registerUser() {
        global $connect, $roll_no, $username, $email, $password;
        $passwordHash = password_hash($password, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($connect, "INSERT INTO user (roll_no, username, email, password) VALUES (?, ?, ?, ?)");
        mysqli_stmt_bind_param($statement, "siss", $roll_no, $username, $email, $passwordHash);
        mysqli_stmt_execute($statement);
        mysqli_stmt_close($statement);     
    }
    function usernameAvailable() {
        global $connect, $username;
        $statement = mysqli_prepare($connect, "SELECT * FROM user WHERE username = ?"); 
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }
    $response = array();
    $response["success"] = false;  
    if (usernameAvailable()){
        registerUser();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>