package Files.PracticalTask.Package1;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DecodeFileRunner {

    public static void main(String[] args) throws IOException {
        decode("src/Files.PracticalTask.Package1/decode.txt", "src/Files.PracticalTask.Package1/win1251.txt");
    }

    public static void decode(String source, String dest) throws IOException {

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Reader reader = new InputStreamReader(new FileInputStream(source), Charset.forName("UTF-8"));
        Writer writer = new OutputStreamWriter(new FileOutputStream(dest), Charset.forName("WINDOWS-1251"));

        int i;
        while ((i = reader.read()) != -1) {
            writer.write(i);
        }


        writer.write("\n\n" + sdf.format(currentDate));

        reader.close();
        writer.close();
    }
}