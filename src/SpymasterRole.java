import java.util.Scanner;

public class SpymasterRole implements PlayerRole{
    @Override
    public String doRole() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Give a hint to you team players");
        return sc.nextLine();
    }
}
