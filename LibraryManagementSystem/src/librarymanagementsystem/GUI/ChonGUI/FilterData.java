package librarymanagementsystem.GUI.ChonGUI;

public class FilterData {
    public static String choice_1;
    public static String choice_2;
    public static String value_1;
    public static String value_2;
    public static int andOr; // 0: -and, -or; 1: and, -or; 2: -and, or
    
    public void setData(String choice_1, String choice_2, String value_1, String value_2, int andOr){
        this.choice_1 = choice_1;
        this.value_1 = value_1;
        this.choice_2 = choice_2;
        this.value_2 = value_2;
        this.andOr = andOr;
    }
    
    public boolean hasChoice_1(){
        return !value_1.equals("");
    }
    
    public boolean hasChoice_2(){
        return hasChoice_1() && !value_2.equals("");
    }
    
    public int getandOr(){
        return this.andOr;
    }
    
}
