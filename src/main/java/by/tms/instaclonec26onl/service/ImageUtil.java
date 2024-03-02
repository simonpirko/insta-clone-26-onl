package by.tms.instaclonec26onl.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {
    public static byte[] convertToByteArray(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }

    public static String convertToBase64(byte[] photoBytes) {
        return Base64.getEncoder().encodeToString(photoBytes);
    }
}
