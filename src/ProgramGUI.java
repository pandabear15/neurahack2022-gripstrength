import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;

public class ProgramGUI extends Thread{
    private JPanel rootPanel;
    private JLabel status;
    private JButton pressButton;
    private JLabel imagePanel;
    private JPanel graph;

    private ProgramState ps;
    //boolean status_on = false;

    private final String soundName = "sfx.wav";
    private AudioInputStream audioIS;
    private Clip c = null;

    public ProgramGUI(ProgramState programState) {
        ps = programState;
        setButtonMessage("Start");
        graph.setOpaque(true);
        pressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ps.hasScanStarted();
                setButtonEnabled(false);
                Main.startDetection();
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    public void setStatusMessage(String statusMessage){
        status.setText(statusMessage);
    }

    public void setButtonMessage(String buttonMessage){
        pressButton.setText(buttonMessage);
    }

    public void setButtonEnabled(boolean enable){
        pressButton.setEnabled(enable);
    }

    public void render(){
        graph.paintComponents(graph.getGraphics());
    }

    public double[] getCurrentData(){
        return ps.getCurrentReading();
    }

    private void createUIComponents() {
        graph = new JPanel() {
            public void paintComponents(Graphics g) {
                super.paintComponent(g);
                double[] data = ps.getCurrentReading();
                if(data == null || data.length < 2){
                    return;
                }
                int margin = 25;
                Graphics2D g1=(Graphics2D)g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                int width = this.getWidth();
                int height = this.getHeight();
                double minY = minValue();
                double maxY = maxValue();
                double deltaX = ((double) width - 2 * margin) / (data.length - 1);
                double deltaY = ((double) height - 2 * margin) / (maxY - minY);
                g1.setPaint(Color.blue);
                //draw lines
//                for(int i = 1; i < data.length; i++){
//                    double x0 = margin + deltaX * (i - 1);
//                    double y0 = margin + deltaY * (maxY - data[i - 1]);
//                    double x1 = margin + deltaX * i;
//                    double y1 = margin + deltaY * (maxY - data[i]);
//                    g1.draw(new Line2D.Double(x0, y0, x1, y1));
//                }
                for(int i = 0; i < data.length; i++){
                    double x = margin + deltaX * i;
                    double y = margin + deltaY * (maxY - data[i]);
                    int diameter = 1;
                    g1.draw(new Ellipse2D.Double(x, y, diameter, diameter));
                }
            }
        };
    }

    private double maxValue(){
        double max = Double.MIN_VALUE;
        for(double d : ps.getCurrentReading()){
            max = Math.max(d, max);
        }
        return max;
    }

    private double minValue(){
        double min = Double.MAX_VALUE;
        for(double d : ps.getCurrentReading()){
            min = Math.min(d, min);
        }
        return min;
    }
}
