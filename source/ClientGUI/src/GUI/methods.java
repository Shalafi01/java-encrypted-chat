package GUI;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author NICOLA
 */
public class methods {

    public methods() {
    }

    public String generateKeyAES() {

        SecretKey secretKey;                //dichiara una SecretKey
        KeyGenerator keygen = null;         //dichiara un KeyGen
        try {
            keygen = KeyGenerator.getInstance("AES");       //restituisce un KeyGenerator per l'algoritmo dato come parametro 
        } catch (NoSuchAlgorithmException e) {
        }
        keygen.init(256);                   //inizializza il keygen per una certa grandezza della chiave
        secretKey = keygen.generateKey();   //genera la chiave per i parametri fissati
        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());              //codifica la chiave (array di byte) in string secondo 
        
        return keyString;       //ritorna la chiave come string
    }

    public String encryptAES(String strToEncrypt, String keyString) throws Exception {
    byte[] iv = new byte[12]; // 96 bits for GCM IV
    new SecureRandom().nextBytes(iv); // Generate a random IV for each encryption

    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv); // 128 is the tag length in bits
    byte[] aadData = "symService".getBytes(); // Additional Authenticated Data (optional, but keep consistent)

    SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding"); // Use NoPadding with GCM

    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);
    cipher.updateAAD(aadData);

    byte[] encryptedTextBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));

    // Concatenate IV and ciphertext, then encode in Base64
    byte[] combined = new byte[iv.length + encryptedTextBytes.length];
    System.arraycopy(iv, 0, combined, 0, iv.length);
    System.arraycopy(encryptedTextBytes, 0, combined, iv.length, encryptedTextBytes.length);

    return Base64.getEncoder().encodeToString(combined);
}

public String decryptAES(String strToDecrypt, String keyString) throws Exception {
    try {
        byte[] decodedCombined = Base64.getDecoder().decode(strToDecrypt);

        byte[] iv = new byte[12]; // IV is 12 bytes
        System.arraycopy(decodedCombined, 0, iv, 0, iv.length);

        byte[] encryptedTextBytes = new byte[decodedCombined.length - iv.length];
        System.arraycopy(decodedCombined, iv.length, encryptedTextBytes, 0, encryptedTextBytes.length);

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        byte[] aadData = "symService".getBytes(); // Must be the same AAD as encryption

        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(keyString), "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding"); // Use NoPadding with GCM

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
        cipher.updateAAD(aadData);

        byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
        return new String(decryptedTextBytes, "UTF-8");
    } catch (Exception e) {
        // Log the exception for debugging instead of silently returning original string
        e.printStackTrace();
        return strToDecrypt; // Return original if decryption fails (consider throwing exception instead)
    }
}

    public String encryptDES(String str, SecretKey key) throws Exception {

        Cipher ecipher;
        
        ecipher = Cipher.getInstance("DES");    //restiuisce un cipher inizializzato per il DES
        ecipher.init(Cipher.ENCRYPT_MODE, key); //inizializza cipher con modalità (crittazione) e chiave

        byte[] utf8 = str.getBytes("UTF8");     //trasforma la stringa da crittare in un array di byte secondo lo standard UTF8
        byte[] enc = ecipher.doFinal(utf8);     //critta la stringa originale trasformata in byte

        enc = Base64.getEncoder().encode(enc);  //trasforma i byte crittati in stringa

        return new String(enc);
    }

    public String decryptDES(String str, SecretKey key) throws Exception {
        Cipher dcipher;
        
        try {            
            dcipher = Cipher.getInstance("DES");
            dcipher.init(Cipher.DECRYPT_MODE, key);

            byte[] dec = Base64.getDecoder().decode(str);
            byte[] utf8 = dcipher.doFinal(dec);

            return new String(utf8, "UTF8");
        } catch (Exception e) {
            return str;
        }
    }
    
    public SecretKey generateKey3DES() throws NoSuchAlgorithmException {
        KeyGenerator gen = KeyGenerator.getInstance("DESede");
        gen.init(112);
        SecretKey key = gen.generateKey();
        return key;
    }

    public String encrypt3DES(String message, SecretKey key) throws Exception {
    IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    byte[] plainTextBytes = message.getBytes("utf-8");
    byte[] cipherText = cipher.doFinal(plainTextBytes);

    return Base64.getEncoder().encodeToString(cipherText); // Encode as Base64 string
}

    public String decrypt3DES(String base64Message, SecretKey key) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] messageBytes = Base64.getDecoder().decode(base64Message); // Decode from Base64
        byte[] plainText = decipher.doFinal(messageBytes);

        return new String(plainText, "UTF-8");
    }
}    
