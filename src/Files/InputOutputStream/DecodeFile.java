package Files.InputOutputStream;

import java.io.*;
import java.nio.charset.Charset;

public class DecodeFile {

    public static void main(String[] args) throws IOException {
        recode("src/Files/InputOutputStream/recode.txt", "UTF-8",
                "src/Files/InputOutputStream/win1251.txt", "WINDOWS-1251");
    }

    public static void recode(String source, String sEnc, String dest, String dEnc) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(source), Charset.forName(sEnc));
        Writer writer = new OutputStreamWriter(new FileOutputStream(dest), Charset.forName(dEnc));

        int i;
        while ((i = reader.read()) != -1) {
            writer.write(i);
        }
        reader.close();
        writer.close();
    }
}
