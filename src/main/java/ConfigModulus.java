import java.util.List;

/**
 * Created by marceltauber on 23/1/17.
 */
public class ConfigModulus {

    int maxLevel;
    List<Integer> repeatedLevels;

    public ConfigModulus(){}

    public ConfigModulus(int maxLevel, List<Integer> repeatedLevels){


        this.maxLevel = maxLevel;
        this.repeatedLevels = repeatedLevels;
    }

    public int getRewardLevel(int userLevel){

        int diff = calcDifference();
        int module = (userLevel-diff)%this.repeatedLevels.size();

        if(userLevel <= maxLevel){ return userLevel;
        }else {
            return this.repeatedLevels.get(module);
        }

    }

    private int calcDifference() {

        int specialCase = this.repeatedLevels.size() - 1;
        int module = this.maxLevel%this.repeatedLevels.size();
         if( module != specialCase){

             return module + 1;
         } else {
             return 0;
         }

    }

    public int getMaxLevel(){ return this.maxLevel;}

    public List<Integer> getRepeatedLevels() { return this.repeatedLevels; }

}
