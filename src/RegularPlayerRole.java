import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RegularPlayerRole implements PlayerRole{
    @Override
    public String doRole() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the words you choose, divided by ','");
        return sc.nextLine();
    }
}
