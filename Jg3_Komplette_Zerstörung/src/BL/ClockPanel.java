
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
        
        this.add(sec1);
        this.add(sec2);

        this.add(dp1);
        
        this.add(min1);
        this.add(min2);

        this.add(dp2);
        
        this.add(hour1);
        this.add(hour2);
      }

    @Override
    public void run() {
        
    }
    
    private ImageIcon getIcon(int z){
        return new ImageIcon("bilder/" + z + ".PNG");
    }
    
}
