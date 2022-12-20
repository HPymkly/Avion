package com.main.demo.model.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyTool {
    public static List<Integer> toInt(List<String> liste) {
        if (liste == null) {
            return null;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < liste.size(); i++) {
            ans.add(Integer.parseInt(liste.get(i)));
        }
        return ans;
    }

    public static <T extends Object> T[] toArray(List<T> list, Class<T> classes) {
        T[] ans = (T[]) Array.newInstance(classes, list.size());
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (T) list.get(i);
        }
        return ans;
    }

    public static BufferedWriter getBuffer(String fic) throws IOException {
        File f = new File(fic);
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter w = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(w);
        return bw;
    }

    public static void insert(String fic, String[] liste) throws IOException {
        BufferedWriter bw = MyTool.getBuffer(fic);
        for (int i = 0; i < liste.length; i++) {
            bw.write(liste[i]);
            bw.newLine();
        }
        bw.close();
    }

    public static ArrayList<String> read(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new Exception("No File");
        }
        ArrayList<String> ans = new ArrayList<String>();
        FileInputStream finps = new FileInputStream(file);
        InputStreamReader insr = new InputStreamReader(finps, "UTF-8");
        BufferedReader r = new BufferedReader(insr);
        String line = "";
        while ((line = r.readLine()) != null) {
            ans.add(line);
        }
        r.close();
        insr.close();
        finps.close();
        return ans;
    }
}
