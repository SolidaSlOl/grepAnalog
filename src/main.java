import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by solid on 12.09.2016.
 */
public class main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        String par;
        Pattern p;
        System.out.println("1-not regex, 2-regex");
        if (Integer.parseInt(input.nextLine()) == 1)  {
            par = ".*" + input.nextLine().replace(" ", "+.*").concat("+.*");
            p = Pattern.compile(par, Pattern.CASE_INSENSITIVE);
        } else {
            par = input.nextLine();
            p = Pattern.compile(par, Pattern.CASE_INSENSITIVE);
        }
        ArrayList stringsOut = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        try {
            String line = br.readLine();
            while (line != null){
                if (p.matcher(line).matches())
                    stringsOut.add(line);
                line = br.readLine();
            }
        }
        finally {
            br.close();
        }
        for (Object lines : stringsOut) {
            System.out.println(lines.toString());
        }
    }
}
