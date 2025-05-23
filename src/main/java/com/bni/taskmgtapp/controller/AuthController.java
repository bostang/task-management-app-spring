package com.bni.taskmgtapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bni.taskmgtapp.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/************************ LAYER CONTROLLER/PRESENTATION ************************/
@RestController // menandakan layer ini adalah layer controller
public class AuthController {
    
    private final JwtUtil jwtService;

    public AuthController(JwtUtil jwtService){
        this.jwtService = jwtService;
    }

    // generate token JWT untuk username yang diberikan
    @GetMapping("/get-token/{username}")    // atur endpoint API
    public String getToken(@PathVariable String username) {
        // @PathVariable : mengambil nilai variabel dari URL endpoint.
        return jwtService.createToken(username);
    }

    // validasi token JWT yang diberikan
    @PostMapping("/validate-token")     // atur endpoint API
    public String validateToken(@RequestBody String token) {
        // @RequestBody : mengikat (bind) data JSON/XML dari body HTTP request ke parameter method di controller
        try{    // apabila token valid
            return "Token is valid for user: "+ jwtService.validateToken(token);
        }       // apabila token tidak valid
        catch (Exception e){
            return "Invalid token: " + e.getMessage();      // tampilkan pesan error
        }
    }
}
/************************ END OF LAYER CONTROLLER/PRESENTATION ************************/
