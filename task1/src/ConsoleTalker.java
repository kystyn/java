import java.util.Scanner;

public class ConsoleTalker {
    public static void main( String[] Args )
    {
        java.util.Scanner sc = new Scanner(System.in);
        while (true) {
            String sym = sc.nextLine();
            if (sym.charAt(0) != 'q')
                System.out.println(sym.charAt(0));
            else
                System.exit(0);
        }
    }

}
