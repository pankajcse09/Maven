
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

/*
 * Copyright 2014 kapil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author kapil
 */
public class GenHashMD5Code {
    
    public String genHash(String plaintext)throws Exception
    {
//        String plaintext = "kapilsaini0506@gmail.com";
MessageDigest m = MessageDigest.getInstance("MD5");

m.reset();
m.update(plaintext.getBytes());
byte[] digest = m.digest();
BigInteger bigInt = new BigInteger(1,digest);
String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
while(hashtext.length() < 32 ){
  hashtext = "0"+hashtext;
}
System.out.println(hashtext);
return hashtext;
    }
    
 private static byte[] iv =
      { 0x0a, 0x01, 0x02, 0x03, 0x04, 0x0b, 0x0c, 0x0d };

  private static byte[] encrypt(byte[] inpBytes,
      SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    IvParameterSpec ips = new IvParameterSpec(iv);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    return cipher.doFinal(inpBytes);
  }

  private static byte[] decrypt(byte[] inpBytes,
      SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    IvParameterSpec ips = new IvParameterSpec(iv);
    cipher.init(Cipher.DECRYPT_MODE, key);
    return cipher.doFinal(inpBytes);   
  }
    
    public static void main(String ar[])
    {
//        GenHashMD5Code gh=new GenHashMD5Code();
//        try{
//        String txt=gh.genHash("kapilsaini0506@gmail.com");
//        gh.genHash(txt);
//        }catch(Exception e){}
        
        
        String xform = "DES/ECB/PKCS5Padding";
    // Generate a secret key
        try{
    KeyGenerator kg = KeyGenerator.getInstance("DES");
    kg.init(56); // 56 is the keysize. Fixed for DES
    SecretKey key = kg.generateKey();
    String msg="J2EE Security for Servlets, EJBs and Web Services";
    byte[] dataBytes = msg.getBytes();

    byte[] encBytes = encrypt(dataBytes, key, xform);
    System.out.println("decrypted value:" + encBytes.toString());
    
    byte[] decBytes = decrypt(encBytes, key, xform);
    System.out.println("decrypted value:" + new String(decBytes, Charset.forName("US-ASCII")));

    boolean expected = java.util.Arrays.equals(dataBytes, decBytes);
    System.out.println("Test " + (expected ? "SUCCEEDED!" : "FAILED!"));
     }catch(Exception e){System.out.println("EX: " +e.getMessage());}
    }
    
}
