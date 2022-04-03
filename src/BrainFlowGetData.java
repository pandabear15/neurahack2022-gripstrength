import java.util.Arrays;

import brainflow.*;

public class BrainFlowGetData {

    public static void getData() throws Exception {

        // initialize board
        BoardShim.enable_board_logger();
        BrainFlowInputParams params = new BrainFlowInputParams();
        int board_id = BoardIds.CYTON_BOARD.get_code();
        params.set_serial_port("COM4");
        BoardShim board_shim = new BoardShim(board_id, params);
        board_shim.prepare_session();
        board_shim.config_board("2345678x1060100X");
        System.out.println(board_shim.get_version());


        // start stream
        // board_shim.start_stream (); // use this for default options
        board_shim.start_stream(450000, "file://file_stream.csv:w");
        BoardShim.log_message(LogLevels.LEVEL_INFO.get_code(), "Start sleeping in the main thread");
        Thread.sleep(5000);
        board_shim.stop_stream();

        // print data
        System.out.println(board_shim.get_board_data_count());
//        double[][] data = board_shim.get_current_board_data(30); // doesnt flush it from ring buffer
        double[][] data = board_shim.get_board_data(); // get all data and flush from ring buffer
        double[] channelOne = data[1];
        System.out.println(Arrays.toString(channelOne));

//        for (int i = 0; i < data.length; i++) {
//            System.out.println(Arrays.toString(data[i]));
//        }
        board_shim.release_session();
    }
}
