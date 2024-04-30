public class GreenBlock {
    
    String greTopic = "";
    String gre1 = "";
    String gre2 = "";
    String gre3 = "";
    String gre4 = "";

    public GreenBlock(String ginT,String gin1, String gin2, String gin3, String gin4){
        
        greTopic = ginT;
        gre1 = gin1;
        gre2 = gin2;
        gre3 = gin3;
        gre4 = gin4;
    }

    public String retTop(){
        return greTopic;
    }

    public String retYe1(){
        return gre1;
    }
    public String retYe2(){
        return gre2;
    }
    public String retYe3(){
        return gre3;
    }
    public String retYe4(){
        return gre4;
    }

    public boolean matching(String y1, String y2, String y3, String y4){
        if(y1.equals(gre1) || y1.equals(gre2) || y1.equals(gre3) || y1.equals(gre4)){
            if(y2.equals(gre1) || y2.equals(gre2) || y2.equals(gre3) || y2.equals(gre4)){
                if(y3.equals(gre1) || y3.equals(gre2) || y3.equals(gre3) || y3.equals(gre4)){
                    if(y4.equals(gre1) || y4.equals(gre2) || y4.equals(gre3) || y4.equals(gre4)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
