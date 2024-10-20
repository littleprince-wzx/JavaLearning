package EighthChapterIOStream;

import java.io.*;

public class BasicBytefilterPart5 {

    public static void main(String[] args) {
        BufferedReader stdin=
        new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try{
            input = stdin.readLine();
        }catch (IOException exception){

        }
        System.out.println(input);//这样涉及了作用域问题
    }
}
