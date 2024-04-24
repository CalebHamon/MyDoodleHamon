import doodlepad.*;

public class ButtonManager {

    RoundRect actRect;
    int coor;
    
    public ButtonManager(RoundRect r1, int num){
        coor = num;
        actRect = r1;
    }

    public RoundRect retRect(){
        return actRect;
    }
    
    public int retCoor(){
        return coor;
    }
}
