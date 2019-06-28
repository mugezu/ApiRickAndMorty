package com.example.AwesomeCompan.demo.service;

import com.example.AwesomeCompan.demo.entity.Character;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UtilService {
    private static final String DEFAULT_PATH = "C:\\newDirectory\\";

    public static Long getLastDomain(String url) {
        String[] strings = url.split("/");
        return Long.parseLong(strings[strings.length - 1]);
    }

    public void fileStream(Character character) {
        URL url = null;
        try {
            url = new URL(character.getImage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection conn;
        try {
            conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            byte[] result = new byte[bis.available()];
            bis.read(result);

            character.setAvatar(result);
            bis.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
