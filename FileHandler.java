package learnJamieChan;

import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    LinkedList<Member> m = new LinkedList<>();
    String lineRead;
    String[] splitLine;
    Member mem;

    public LinkedList<Member> readFile() {
        {
            try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
                String readLine = reader.readLine();
                lineRead = readLine;
                while (lineRead != null) {
                    splitLine = lineRead.split(", ");
                    if (splitLine[0].equals("S")) {
                        mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    } else {
                        mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    }
                    m.add(mem);
                    lineRead = reader.readLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return m;
    }

    public void appendFile(String mem) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true));
            writer.write(mem + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void overWriteFile(LinkedList<Member> m) {

        String s;
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false));
            for (int i = 0; i < m.size(); i++) {
                s = m.get(i).toString();
                writer.write(s + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File f = new File("members.csv");
            File tf = new File("members.temp");
            f.delete();
            tf.renameTo(new File("members.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
