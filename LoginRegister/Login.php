<?php
    require("password.php");
    $con = mysqli_connect("localhost", "id4957652_logreg", "LoginRegister", "id4957652_loginregister");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ?");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $colName, $colUsername, $colEmail, $colPassword);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        if (password_verify($password, $colPassword)) {
            $response["success"] = true;  
            $response["name"] = $colName;
            $response["username"] = $colUsername;
            $response["email"] = $colEmail;
        }
    }
    echo json_encode($response);
?>