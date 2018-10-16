package test;

import sample.EV.EtoVn;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main3 {
    public static int locationIfVE(char a){
            if(a == 'k' || a == 'l' || a == 'm' || a == 'n' || a == 'o' || a == 'ỏ' ||
                    a == 'õ' || a == 'ó' || a == 'ò' || a == 'ọ'){
                return 10969;
            } else if(a == 'ô' || a == 'ổ' || a == 'ỗ' ||
                    a == 'ố' || a == 'ồ' || a == 'ộ' ||
                    a == 'ơ' || a == 'ở' || a == 'ỡ' ||
                    a == 'ớ' || a == 'ờ' || a == 'ợ' ||
                    a == 'p' || a == 'q' || a == 'r' || a == 's' ) {
                return 16799;
            } else if(a == 'u' ||a == 'ủ' ||a == 'ũ' ||
                    a == 'ụ' ||a == 'ù' ||a == 'ú' ||
                    a == 'ư' ||a == 'ử' ||a == 'ữ' ||
                    a == 'ự' ||a == 'ừ' ||a == 'ứ' ||
                    a == 't' ||a == 'v' ||a == 'x' ||a == 'y' ) {
                return 20409;

            } else {
                return 0;
            }
    }

    public static void main(String[] args) {




        EtoVn x = new EtoVn();
        x.convertToDecimal("DF");

        int index = 0;
        String line;
        String dataPath = "src/Data/vietanh.index";
        EtoVn getValue = new EtoVn(dataPath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataPath));
            while ((line = reader.readLine()) != null) {
                index++;
                if(index >=1000 && index <= 1001) {
                    System.out.println(line);
                }
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e + "loi nay");
        }
        System.out.println(index);

    }
}
