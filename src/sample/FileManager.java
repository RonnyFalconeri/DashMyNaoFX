package sample;

import java.io.*;

public class FileManager{

    public static void writeInFile(String pLatestConnection){
        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("latest connection.txt")));
            pWriter.println(pLatestConnection);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
    }

    public static String readInFile() throws IOException {
        String line;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");
        try (BufferedReader reader = new BufferedReader(new FileReader("latest connection.txt"))) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        }
    }

}
