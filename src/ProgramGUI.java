import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        graph.setOpaque(true);
        pressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ps.hasScanStarted();
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

    private void createUIComponents() {
        graph = new JPanel() {
            public void paintComponents(Graphics g) {
                super.paintComponent(g);
                double[] data = ps.getCurrentReading().getData();
                int margin = 5;
                Graphics2D g1=(Graphics2D)g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                int width = this.getWidth();
                int height = this.getHeight();
                double minY = minValue();
                double maxY = maxValue();
                double deltaX = ((double) width - 2 * margin) / data.length;
                double deltaY = ((double) height - 2 * margin) / (maxY - minY);
                g1.setPaint(Color.blue);
                for(int i = 1; i < data.length; i++){
                    double x0 = margin + deltaX * (i - 1);
                    double y0 = margin + deltaY * (data[i - 1] - minY);
                    double x1 = margin + deltaX * i;
                    double y1 = margin + deltaY * (data[i] - minY);
                    g1.draw(new Line2D.Double(x0, y0, x1, y1));
                }
            }
        };
    }

    private double maxValue(){
        double max = Double.MIN_VALUE;
        for(double d : ps.getCurrentReading().getData()){
            max = Math.max(d, max);
        }
        return max;
    }

    private double minValue(){
        double min = Double.MAX_VALUE;
        for(double d : ps.getCurrentReading().getData()){
            min = Math.min(d, min);
        }
        return min;
    }
}
