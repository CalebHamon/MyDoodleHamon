public class PurpleBlock {

    String purpTopic = "";
    String purp1 = "";
    String purp2 = "";
    String purp3 = "";
    String purp4 = "";

    public PurpleBlock(String pinT,String pin1, String pin2, String pin3, String pin4){
        
        purpTopic = pinT;
        purp1 = pin1;
        purp2 = pin2;
        purp3 = pin3;
        purp4 = pin4;
    }

    public String retTop(){
        return purpTopic;
    }

    public String retYe1(){
        return purp1;
    }
    public String retYe2(){
        return purp2;
    }
    public String retYe3(){
        return purp3;
    }
    public String retYe4(){
        return purp4;
    }

    public boolean matching(String y1, String y2, String y3, String y4){
        if(y1.equals(purp1) || y1.equals(purp2) || y1.equals(purp3) || y1.equals(purp4)){
            if(y2.equals(purp1) || y2.equals(purp2) || y2.equals(purp3) || y2.equals(purp4)){
                if(y3.equals(purp1) || y3.equals(purp2) || y3.equals(purp3) || y3.equals(purp4)){
                    if(y4.equals(purp1) || y4.equals(purp2) || y4.equals(purp3) || y4.equals(purp4)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
