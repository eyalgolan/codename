import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RegularPlayerRole implements PlayerRole{
    @Override
    public String doRole() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the row, column location of each word you choose, " +
                "in the following format: row,column#row,column");
        return sc.nextLine();
    }
}
