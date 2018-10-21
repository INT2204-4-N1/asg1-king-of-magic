package sample.EV;
import sample.EV.EtoVn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TranslateEV {
    /**
     * dounded : khi tim thay du lieu se tra ve true, khong tim thay tra ve false
     */
    public Boolean founded = false;

    public Boolean foundedOrNot(Boolean found){
        return found;
    }

    /**
     * dem cac tu cach nhau rieng le trong 1 String
     */
    private int countWorldInIndexFile(String string){

        int index = 1;
        for(int i = 0;i < string.length() - 1; i++) {
            if(string.charAt(i + 1) == '\t' && string.charAt(i) != '\t') {
                index += 1;
            }
        }
        return index;
    }

    /**
     * Tach cac tu trong string ra thanh cac tu rieng
     */
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

    /**
     * duong dan file .index va .dict
     */
    private String filePath = "src/Data/anhviet109K.index";
    private String dataPath = "src/Data/anhviet109K.dict";

    /**
     * luu du lieu voi key va value cua tu can tim
     */
    public HashMap<String,String> map = new HashMap<String, String>();
    private String line;
    public TranslateEV(String filePath,String dataPath){
        this.filePath = filePath;
        this.dataPath = dataPath;
    }
    public TranslateEV(){}

    /**
     * lay nghia cua tu can tim "keySearch"
     */
    public void englishToVietnameseOn(String keySearch) {
        if(map.get(keySearch) != null) {
            this.founded = true;
            System.out.println("thuc hien bo qua truy cap dataPath.");
            return;
        }

        EtoVn getValue = new EtoVn(dataPath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null ) {
                line = line.trim();
                // put to map
                String key = "";
                String value;
                // count amount of word
                int amount = countWorldInIndexFile(line);
                String[] parts = line.split("\t",amount);
                if(parts[0].charAt(0) == keySearch.charAt(0)){
                     getValue.setEtoVn(parts[amount - 2],parts[amount - 1]);
                     value = getValue.getWordMeaning();

                     for(int i = 0;i < amount - 2;i++) {
                         key = key + " " + parts[i];
                      }
                      key = key.trim();
                      if(keySearch.equals(key)) {
                          map.put(key,value);
                          this.founded = true;
                          return;
                      }
                }
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e + " Loi nay");
        }
        this.founded = false;
    }
}