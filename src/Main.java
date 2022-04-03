import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("AudioGUI");
        ProgramGUI gui = new ProgramGUI();
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        gui.setStatusMessage("Grip Strength Diagnostic. Apply electrodes as depicted. \nWhen complete, press start.");
        
        frame.setVisible(true);
    }
}
