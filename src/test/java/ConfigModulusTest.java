import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by marceltauber on 24/1/17.
 */
public class ConfigModulusTest {

    /** 1) Change endTestingLevel to the desired amount of levels to print on the console
     *  2) add the desired levels to 'repeatedLevels' in order to repeat them
     *  3) change the ConfigModulus instantiation to determine the 'maxLevel' from which
     *  'repeatedLevel' will start.
     *  */

    @org.testng.annotations.Test
    public void testGetRewardLevel() throws Exception {

        int endTestingLevel = 15;

        String newline = System.getProperty("line.separator");
        List<Integer> repeatedLevels = new LinkedList<Integer>();

        repeatedLevels.add(4);
        repeatedLevels.add(5);
        repeatedLevels.add(6);

        ConfigModulus config = new ConfigModulus(8,repeatedLevels);

        //just printing out all the levels up to endTestingLevel for visual feedback
        for(int i = 1; i <= endTestingLevel; i++){

            System.out.println("level: " + i + newline + "reward level: " +config.getRewardLevel(i));
            System.out.print(newline + newline);

        }

        // testing all level rewards up to 'maxLevel'
        for(int i = 1; i <= config.maxLevel; i++ ){

            Assert.assertEquals(i,config.getRewardLevel(i));

        }

        // testing from next to 'maxLevel' up to 'endTestingLevel'

        List<Integer> repeatedRewards = new LinkedList<>();

        // 1) iterate from start to end of repeatedLevels and fill repeatedRewards
        //    with the corresponding reward level, to create a control list.
        int j = 0;
        for(int i = config.maxLevel + 1 ; i <= endTestingLevel; i++){

            repeatedRewards.add(config.repeatedLevels.get(j));

            if ( j < config.repeatedLevels.size() - 1) {
                j++;
            } else {
                j = 0;
            }
        }

        // 2) iterate from start to end of repeatedLevels and check with our control list
        int k = 0;
        for(int i = config.maxLevel + 1 ; i <= endTestingLevel; i++){
            int control = repeatedRewards.get(k);
//            System.out.print(" control: " + control + " reward " + config.getRewardLevel(i) + newline);
            Assert.assertEquals( control , config.getRewardLevel(i));
            if( k < config.repeatedLevels.size() - 1){
                k++;
            } else { k = 0;}

        }
    }

}