package com.dmposhost.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad {
    
    public static String Encriptar(String texto) { 
        String secretKey = Util.validaLMK("C");
        String base64EncryptedString = ""; 
        try { 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24); 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key); 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);

            // ✅ Usar Base64 de java.util
            base64EncryptedString = Base64.getEncoder().encodeToString(buf);

        } catch (Exception ex) {
            ex.printStackTrace(); // Mostrar el error en consola para depurar
        }
        return base64EncryptedString;
     }
    
    public static String Desencriptar(String textoEncriptado) throws Exception {
        String secretKey = Util.validaLMK("D");
        String base64EncryptedString = "";
        try {
            // ✅ Usar Base64 de java.util
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);
            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            ex.printStackTrace(); // Mostrar el error en consola para depurar
        }
        return base64EncryptedString;
    }
     
    public static void main(String[] args) throws Exception {
        String encriptado = Encriptar("8888888888");
        System.out.println("Texto Encriptado: " + encriptado);
        String desencriptado = Desencriptar(encriptado);
        System.out.println("Texto Desencriptado: " + desencriptado);
    }
}
