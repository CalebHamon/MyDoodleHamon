public class YellowBlock {
    
    String yellTopic = "";
    String yell1 = "";
    String yell2 = "";
    String yell3 = "";
    String yell4 = "";

    public YellowBlock(String yelT,String yel1, String yel2, String yel3, String yel4){
        
        yellTopic = yelT;
        yell1 = yel1;
        yell2 = yel2;
        yell3 = yel3;
        yell4 = yel4;
    }

    public String retTop(){
        return yellTopic;
    }

    public String retYe1(){
        return yell1;
    }
    public String retYe2(){
        return yell2;
    }
    public String retYe3(){
        return yell3;
    }
    public String retYe4(){
        return yell4;
    }

    public boolean matching(String y1, String y2, String y3, String y4){
        if(y1.equals(yell1) || y1.equals(yell2) || y1.equals(yell3) || y1.equals(yell4)){
            if(y2.equals(yell1) || y2.equals(yell2) || y2.equals(yell3) || y2.equals(yell4)){
                if(y3.equals(yell1) || y3.equals(yell2) || y3.equals(yell3) || y3.equals(yell4)){
                    if(y4.equals(yell1) || y4.equals(yell2) || y4.equals(yell3) || y4.equals(yell4)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
