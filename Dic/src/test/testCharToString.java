package test;
import sample.EV.EtoVn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;
import java.util.HashMap;

public class testCharToString {
/*
    private int countWorldInIndexFile(String string){

        int index = 1;
        for(int i = 0;i < string.length() - 1; i++) {
            if(string.charAt(i + 1) == '\t' && string.charAt(i) != '\t') {
                index += 1;
            }
        }
        return index;
    }
    private String splitWord(String string) {
        int amount = countWorldInIndexFile(string);
        String[] parts = new String[amount];
        for(int i = 0;i < amount;i++) parts[i] = "";

        String[] test = string.split("\\W+",amount);

        for(int k = 0;k < amount;k++) {
            System.out.println(test[k]);
        }


        return "";
    }

    private String filePath = "src/Data/anhviet109K.index";
    public HashMap<String,String> map = new HashMap<String, String>();
    private String line;

    public testCharToString(){}

    public int englishToVietnameseOn(String key1) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null ) {
                line = line.trim();
                EtoVn getValue;

                // put to map
                String key = "";
                String value;

                // count amount of word
                int amount = countWorldInIndexFile(line);
                String[] parts = line.split("\t",amount);
                //getValue = new EtoVn(parts[amount - 2],parts[amount - 1]);
                //value = getValue.getWordMeaning();

                for(int i = 0;i < amount - 2;i++) {
                    key = key + " " + parts[i];
                }
                key = key.trim();

                if(key1.equals(key)) {
                    map.put(key,value);
                    return 1;
                }
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e + "loi nay");
        }
        return 0;
    }
    */
}
