package test;







import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class dicEV {
    static HashMap<String, String> hMapEV;
    static ArrayList<String> word;

    public dicEV() {
    }

    public static void HasdMapEVOn() {
        hMapEV = new HashMap();
        word = new ArrayList();
        File f = new File("/Users/leduy/Desktop/Education/Java learning/Dic/src/Data/DictEV.dic");
        String var1 = "";

        try {
            Scanner sc = new Scanner(f);

            try {
                while(true) {
                    while(sc.hasNextLine()) {
                        String[] str = sc.nextLine().split("=");
                        if (str[0] != "" && str[1] != "") {
                            word.add(str[0]);
                            hMapEV.put(str[0].trim(), str[1]);
                            String var10000 = (String)hMapEV.get(str[0].trim());
                        } else {
                            System.out.println("Đã có lỗi !");
                        }
                    }

                    return;
                }
            } catch (Exception var8) {
                System.out.println(var8.getMessage());
            } finally {
                Collections.sort(word);
                if (sc != null) {
                    sc.close();
                }

            }
        } catch (Exception var10) {
            System.out.println(var10.getMessage());
        }

    }
}
