import java.util.LinkedList;
import java.util.List;

/**
 * Created by marceltauber on 23/1/17.
 */
public class ExerciseOne {

    public static void main(String [] args ){

        String newline = System.getProperty("line.separator");

        List<Integer> higherLevels = new LinkedList<Integer>();
        higherLevels.add(4);
        higherLevels.add(5);
        higherLevels.add(6);

        //first instance
        Config config = new Config();

        config.setMax(7);
        config.setHigherLevels(higherLevels);
        //filling the instance's attributes
        config.makeUnderMax();
        config.makeOverMax(5);
        config.makeRewardsList();

        config.printRewards();
        System.out.print(newline + newline);


        // Second Instance
        // all operations done in the constructor
        Config config2 = new Config(6, higherLevels, 4);

        config2.printRewards();

        System.out.print(newline + newline);
        System.out.println("Your Reward Level is:");
        System.out.print(config2.getRewardByLevel(11));
    }
}
