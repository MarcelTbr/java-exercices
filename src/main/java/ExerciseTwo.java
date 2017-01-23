import java.util.LinkedList;
import java.util.List;

/**
 * Created by marceltauber on 23/1/17.
 */
public class ExerciseTwo {


    public static void main(String [] args){

        String newline = System.getProperty("line.separator");
        List<Integer> repeatedLevels = new LinkedList<Integer>();
        repeatedLevels.add(3);
        repeatedLevels.add(4);
        repeatedLevels.add(5);
        repeatedLevels.add(6);

        ConfigModulus config = new ConfigModulus(9,repeatedLevels);

        System.out.println("Your Reward Level Is: "); System.out.println(newline);
        System.out.println(config.getRewardLevel(13));
    }
}
