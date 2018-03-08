package com.example.palak.loginregister;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by palak on 5/3/18.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://lovelorn-spar.000webhostapp.com/Register.php";
    private Map<String, String> params;
    public RegisterRequest(String name, String username, String email, String password, Response.Listener<String>listener)
    {
        super(Method.POST,REGISTER_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("email_id", email);
        params.put("password", password);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}