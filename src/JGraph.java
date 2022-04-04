import javax.swing.*;
import java.awt.*;

public class JGraph extends JPanel {

    private double deltaX;
    private double deltaY;

    private int margin;

    private double[] data;

    public void drawGraph(Graphics g){
        super.paintComponent(g);
        Graphics2D g1=(Graphics2D)g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int width = this.getWidth();
        int height = this.getHeight();

    }

    public void setData(double[] newData){
        data = newData;
    }

    private double maxValue(){
        double max = Double.MIN_VALUE;
        for(double d : data){
            max = Math.max(d, max);
        }
        return max;
    }

    private double minValue(){
        double min = Double.MAX_VALUE;
        for(double d : data){
            min = Math.min(d, min);
        }
        return min;
    }
}
