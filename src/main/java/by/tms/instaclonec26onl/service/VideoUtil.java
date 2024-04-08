package by.tms.instaclonec26onl.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class VideoUtil {

    public static byte[] convertToByteArray(InputStream inputStream) throws IOException {
//        try (FileInputStream inputStream = new FileInputStream(videoFilePath)) {
//            byte[] buffer = new byte[8192];
//            int bytesRead;
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            return outputStream.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
        return inputStream.readAllBytes();
    }

    public static String convertToBase64(byte[] videoBytes) {
        return Base64.getEncoder().encodeToString(videoBytes);
    }

}
