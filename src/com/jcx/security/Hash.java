package com.jcx.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jonathan Carlton
 * @version 1.0
 * Hashing and conversion of strings and bytes
 */
public class Hash
{
    public Hash() { }

    /**
     * From a byte[] returns a base 64 representation
     * @param data          byte[] to be encoded
     * @return              String version of the data byte[]
     * @throws IOException
     */
    public String byteToBase64(byte[] data) throws IOException
    {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * From a base 64 returns the corresponding byte[]
     * @param data          base 64 to be decoded
     * @return              corresponding byte[]
     * @throws IOException
     */
    public byte[] base64ToByte(String data) throws IOException
    {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(data);
    }

    /**
     * Gets the hash of a String
     * <p>
     * From a password, a number of iterations and a salt, returns
     * the corresponding digest
     * </p>
     * @param iteration     The number of iterations of the algorithm
     * @param password      The password to encrypt
     * @param salt          The salt
     * @return              The digested password
     * @throws NoSuchAlgorithmException         If the algorithm doesn't exist
     * @throws UnsupportedEncodingException     If the encoding isn't supported
     */
    public byte[] getHash(int iteration, String password, byte[] salt)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(salt);
        byte[] input = digest.digest(password.getBytes("UTF-8"));

        for (int i = 0; i < iteration; i++)
        {
            digest.reset();
            input = digest.digest(input);
        }

        return input;
    }
}
