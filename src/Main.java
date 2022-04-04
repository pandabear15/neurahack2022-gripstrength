import javax.swing.*;

public class Main {

    private static JFrame frame;
    private static ProgramState ps;
    private static ProgramGUI gui;

    public static final double DATA_COLLECTION_TIME = 10;

    public static void main(String[] args){
        frame = new JFrame("Grip Strength");
        ps = new ProgramState();
        gui = new ProgramGUI(ps);

        BrainFlowMain dataUpdater = new BrainFlowMain(ps);
        dataUpdater.start();

        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        gui.setStatusMessage("<html>Grip Strength Diagnostic. Apply electrodes as depicted.<br/>When complete, press start.</html>");
    }

    public static void startDetection(){
        gui.setStatusMessage("<html>Relax your lower arm on a horizontal surface. <br/>Slowly grip and release.</html>");
        //ps.setCurrentReading(new CytonData(new double[]{2, 7, 9, 4}, 3));
        //System.out.println("Check 1");
        while(true){
            //if(gui.getCurrentData() != null) {
            //    for (double d : gui.getCurrentData()) {
            //        System.out.print(d + " ");
            //    }
            //}
            //System.out.println("\nCheck 2");
            gui.render();
            try {
                Thread.sleep((int)DATA_COLLECTION_TIME * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
