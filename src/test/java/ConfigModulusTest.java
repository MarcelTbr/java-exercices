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

        int endTestingLevel = 100;

        List<Integer> repeatedLevels = new LinkedList<Integer>();

        repeatedLevels.add(4);
        repeatedLevels.add(5);
        repeatedLevels.add(6);

        ConfigModulus config = new ConfigModulus(8,repeatedLevels);

        //just printing out all the levels up to endTestingLevel for visual feedback
        printLegend(endTestingLevel, config);

        // testing all level rewards up to 'maxLevel'
        testInitialLevels(config);

        // testing from next to 'maxLevel' up to 'endTestingLevel'
        testRepeatingLevels(endTestingLevel, config);


    }

    private void testRepeatingLevels(int endTestingLevel, ConfigModulus config) {
        // 1) iterate from start to end of repeatedLevels and fill repeatedRewards.
        int j = 0;
        for(int i = config.maxLevel + 1 ; i <= endTestingLevel; i++){
            // 2) get the correct reward Level from 'repeatedLevels'
            int control = config.repeatedLevels.get(j);
            // 3) checking if the method is returning the correct reward level
            Assert.assertEquals( control , config.getRewardLevel(i));
            // 4) go back to the start of the 'repeatedLevels' if the end is reached
            if ( j < config.repeatedLevels.size() - 1) {
                j++;
            } else {
                j = 0;
            }
        }
    }

    private void testInitialLevels(ConfigModulus config) {
        for(int i = 1; i <= config.maxLevel; i++ ){

            Assert.assertEquals(i,config.getRewardLevel(i));

        }
    }

    private void printLegend(int endTestingLevel, ConfigModulus config) {

        String newline = System.getProperty("line.separator");

        for(int i = 1; i <= endTestingLevel; i++){

            System.out.println("level: " + i + newline + "reward level: " + config.getRewardLevel(i));
            System.out.print(newline + newline);

        }
    }

}