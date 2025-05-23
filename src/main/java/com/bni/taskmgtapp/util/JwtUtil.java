package com.bni.taskmgtapp.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service    // menandakan JWT Util sebagai layer service

/**
 * seharusnya:
 *      Controller ➡️ Service ➡️ Repository ➡️ Utility
 * namun dalam kasus ini:
 *      Controller ➡️ Service (Utility)
 */

/************************ UTILITY TOOL : JWT ************************/
public class JwtUtil {
    // deklarasi secret
        // best practice : jangan hard-coded seperti ini
        // bisa simpan secret key di environment variable atau config file.
    private static final String SECRET = "ThisIsASuperSecretKeyThatShouldBeLongEnoughHS256";
    private static final Key SIGNING_KEY = new SecretKeySpec(
        Base64.getDecoder().decode(SECRET),         // key
        SignatureAlgorithm.HS256.getJcaName());     // algorithm
    
    // generate token
    public String createToken(String Username){
        return Jwts.builder()               // Membuat instance JwtBuilder untuk konstruksi token.
            .setSubject(Username)           // Menetapkan subjek token
            .signWith(SIGNING_KEY)          // Menandatangani token
            .compact();                     // Mengkompres token menjadi format string
    }       // contoh output : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMTIzIn0.XYZ123... (signature)

    // validasi token
    public String validateToken(String token){
        return Jwts.parserBuilder()         // Membuat JwtParserBuilder untuk mem-parsing token
            .setSigningKey(SIGNING_KEY)     // Menetapkan secret key u/ memverifikasi signature token.
            .build()                        // Menghasilkan instance JwtParser
            .parseClaimsJws(token)          // Decode token untuk token signed (JWS).
            .getBody()                      // Mengembalikan objek Claims (payload JWT)
            .getSubject();                  // Mengambil nilai dari claim sub
    }
}
/************************ END OF UTILITY TOOL : JWT ************************/

// catatan:
    // method-chaining
        // cara kerja:
            // 1. Setiap Method Mengembalikan Objek
            // 2. Objek yang Dikembalikan Memiliki Method Berikutnya
            // 3. Pemanggilan method dieksekusi dari kiri ke kanan.