package test;

import java.io.RandomAccessFile;

public class test {
    private static String dataPath = "/Users/leduy/Desktop/Education/Java learning/Dic/src/Data/anhviet109K.dict";
    private static int length = 0;
    private static int position = 0;



    private static int convertToDecimal(String contents) {
        int result = 0;
        String Sixty_bit = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        for(int i = 0 ;i < contents.length();i++) {
            for(int j = 0; j < Sixty_bit.length();j++) {
                if(contents.charAt(i) == Sixty_bit.charAt(j)) {
                    result = result + j*(int)Math.pow(64,Math.abs(contents.length()-1-i));
                }
            }
        }
        return result;
    }

    private static String getWordMeaning(String Soffset,String Slength) {
        length = convertToDecimal(Slength);
        position = convertToDecimal(Soffset);

        byte[] magic = new byte[length];
        try {
            RandomAccessFile raf = new RandomAccessFile(dataPath,"rw");
            raf.seek(position);
            raf.readFully(magic);
            //System.out.println(new String(magic));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        String m = new String(magic);

        return m;
    }

    public static void main(String[] args) {
        System.out.println(getWordMeaning("sn80","BM"));
    }
}
