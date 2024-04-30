public class BlueBlock {
    
    String bluTopic = "";
    String blu1 = "";
    String blu2 = "";
    String blu3 = "";
    String blu4 = "";

    public BlueBlock(String binT,String bin1, String bin2, String bin3, String bin4){
        
        bluTopic = binT;
        blu1 = bin1;
        blu2 = bin2;
        blu3 = bin3;
        blu4 = bin4;
    }

    public String retTop(){
        return bluTopic;
    }

    public String retYe1(){
        return blu1;
    }
    public String retYe2(){
        return blu2;
    }
    public String retYe3(){
        return blu3;
    }
    public String retYe4(){
        return blu4;
    }

    public boolean matching(String y1, String y2, String y3, String y4){
        if(y1.equals(blu1) || y1.equals(blu2) || y1.equals(blu3) || y1.equals(blu4)){
            if(y2.equals(blu1) || y2.equals(blu2) || y2.equals(blu3) || y2.equals(blu4)){
                if(y3.equals(blu1) || y3.equals(blu2) || y3.equals(blu3) || y3.equals(blu4)){
                    if(y4.equals(blu1) || y4.equals(blu2) || y4.equals(blu3) || y4.equals(blu4)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
