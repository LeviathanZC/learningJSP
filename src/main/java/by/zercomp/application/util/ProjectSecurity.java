package by.zercomp.application.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProjectSecurity {

    private static final Logger log = LogManager.getLogger(ProjectSecurity.class);

    public static String generateHash(String ordinal) {
        byte[] hash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            hash = digest.digest(ordinal.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
        }
        return bytesToHex(hash);
    }
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexBuilder = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexBuilder.append('0');
            }
            hexBuilder.append(hex);
        }
        return hexBuilder.toString();
    }

}
