import java.util.LinkedList;
import java.util.List;

/**
 * Created by marceltauber on 23/1/17.
 */
public class Config {

    private int maxLevel;
    private List<Integer> higherLevels;
    private List<Integer> underMax;
    private List <Integer> overMax;
    private List <Integer> rewardsList;


    public Config(){}

    public Config(int maxLevel, List<Integer> higherLevels, int repeated){

        this.maxLevel = maxLevel;
        this.higherLevels = higherLevels;

        this.underMax = new LinkedList<Integer>();
        makeUnderMax();
        this.overMax = new LinkedList<Integer>();
        makeOverMaxConst(repeated);
        makeRewardsList();
    }

    public int getRewardByLevel(int level){

        return this.rewardsList.get(level - 1);

    }

    public void makeRewardsList() {
        this.rewardsList = new LinkedList<Integer>();

        for(int i = 0; i < this.underMax.size();i++ ){
            this.rewardsList.add(this.underMax.get(i));
        }
        for(int i = 0; i < this.overMax.size(); i++){
            this.rewardsList.add(this.overMax.get(i));
        }
    }

    public void setMax (int maxLevel){

        this.maxLevel = maxLevel;

    }
    public void setHigherLevels (List<Integer> higherLevels){

        this.higherLevels = higherLevels;

    }

    public void makeUnderMax(){
        List<Integer> underMax = new LinkedList<Integer>();
        for(int i = 1 ; i <= this.maxLevel; i++){
            underMax.add(i);
        }
        this.underMax = underMax;
    }
    public void makeOverMaxConst(int repeat){

        for(int i = 0; i < repeat; i++) {
            addHigherLevelsOnce();
        }

    }

    public void makeOverMax(int repeat){
        List<Integer> overMax = new LinkedList<Integer>();

        for(int i = 0; i < repeat; i++) {
            for(int j = 0; j < this.higherLevels.size(); j++){

                overMax.add(higherLevels.get(j));
            }
        }

        this.overMax = overMax;
    }

    public void addHigherLevelsOnce (){

        for(int i = 0; i < this.higherLevels.size(); i++){

            this.overMax.add(higherLevels.get(i));

        }
    }

    public void printRewards(){

        System.out.print(this.underMax);
        System.out.print(this.overMax);
        System.out.print(System.getProperty("line.separator"));
        System.out.print(this.rewardsList);
    }
}
