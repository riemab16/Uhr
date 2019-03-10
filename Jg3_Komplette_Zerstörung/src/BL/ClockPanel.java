
package BL;

import java.awt.GridLayout;
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockPanel extends JPanel implements Runnable{
    private LocalTime localtime;
    private JLabel sec1, sec2, min1, min2, hour1, hour2, dp1, dp2;
    
    public ClockPanel(LocalTime localtime) {
        this.localtime = localtime;
        init();
    }

    private int getZiffer(boolean pos, int z){
        if(pos){
            z /= 10;
        }
        if(!pos){
            z %= 10;
        }
        
        return z;
    }
    
  
    private void init(){
        this.setLayout(new GridLayout(1, 8));
        
        sec1 = new JLabel(getIcon(getZiffer(true, localtime.getSecond())));
        sec2 = new JLabel(getIcon(getZiffer(false, localtime.getSecond())));
        
        min1 = new JLabel(getIcon(getZiffer(true, localtime.getMinute())));
        min2 = new JLabel(getIcon(getZiffer(false, localtime.getMinute())));
        
        hour1 = new JLabel(getIcon(getZiffer(true, localtime.getHour())));
        hour2 = new JLabel(getIcon(getZiffer(false, localtime.getHour())));
        
        dp1 = new JLabel(new ImageIcon("bilder/doppelpunkt.PNG"));
        dp2 = new JLabel(new ImageIcon("bilder/doppelpunkt.PNG"));
        
        this.add(hour1);
        this.add(hour2);

        this.add(dp1);
        
        this.add(min1);
        this.add(min2);

        this.add(dp2);
        
        this.add(sec1);
        this.add(sec2);
         
      }

    @Override
    public void run() {
        while(true){
            localtime = localtime.plusSeconds(1);
            draw();
            try{
                Thread.sleep(1000);
            }
            catch(Exception ex){

            }
        }
    }
    
    public void draw(){
        hour1.setIcon(logic(localtime.getHour()/10));
        hour2.setIcon(logic(localtime.getHour()%10));
        dp1.setIcon(logic(10));
        min1.setIcon(logic(localtime.getMinute()/10));
        min2.setIcon(logic(localtime.getMinute()%10));
        dp2.setIcon(logic(10));
        sec1.setIcon(logic(localtime.getSecond()/10));
        sec2.setIcon(logic(localtime.getSecond()%10));
    }
    
    public ImageIcon logic(int z1){
        switch(z1){
            case 0:
                return getIcon(z1); 
            case 1:
                return getIcon(z1);
            case 2:
                return getIcon(z1);
            case 3:
                return getIcon(z1);
            case 4:
                return getIcon(z1);
            case 5:
                return getIcon(z1);
            case 6:
                return getIcon(z1);
            case 7:
                return getIcon(z1);
            case 8:
                return getIcon(z1);
            case 9:
                return getIcon(z1);
            case 10:
                return new ImageIcon("bilder/doppelpunkt.PNG");
            default: return getIcon(1);
        }
        
    }
    private ImageIcon getIcon(int z){
        return new ImageIcon("bilder/" + z + ".PNG");
    }
    
}
