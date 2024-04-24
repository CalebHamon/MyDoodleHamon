import java.util.ArrayList;

import doodlepad.*;
import doodlepad.Shape.ShapeMouseEventHandler;


public class Screen {
    public class PushButton {
        
        public static ArrayList<ButtonManager> b1 = new ArrayList<ButtonManager>();
        private boolean isOn;
        

        public PushButton() {
            // Create button shape and initialize
            int heightFact = 0;
            RoundRect r1;
            int vertFact = 0;
            for(int i = 0; i < 16; i++){
                if(i % 4 == 0){
                    vertFact = 0;
                    heightFact = heightFact++;
                    r1 = new RoundRect((vertFact*200+10), (heightFact*150 + 10), 200, 150, 30, 30);
                }
                else{
                    r1 = new RoundRect((vertFact*200+10), (heightFact*150 + 10), 200, 150, 30, 30);
                }
                ButtonManager addArr = new ButtonManager(r1, i+1);
                b1.add(addArr);
            }

            for(int i = 0; i < b1.size(); i++){
                b1.get(i).retRect().setFillColor(255,255,220,255);
            }
    
            // Starts off
            isOn = false;
    
            // Set button click event handler method
            b1.get(0).actRect.setMousePressedHandler(onPressed(0));
        }
    
        private ShapeMouseEventHandler onPressed(int i) {
            // Toggle button state
            isOn = !isOn;
    
            // Set button fill color based on state
            if (isOn) {
                b1.get(i).actRect.setFillColor(0, 255, 0);
            } else {
                b1.get(i).actRect.setFillColor(200);
            }
            return null;
        }
    }
}
