import brainflow.*;

public class Cyton {
    // object representing the OpenBCI Cyton board
    private BoardShim board_shim;

    /**
     * Creates a new instance of Cyton class and:
     *  - configures the board's hardware to only channel 1 on with SRB2 off
     *  - opens COM4 port
     * @throws Exception
     */
    public Cyton() throws Exception {
        BoardShim.enable_board_logger();
        BrainFlowInputParams params = new BrainFlowInputParams();
        int board_id = BoardIds.CYTON_BOARD.get_code();
        params.set_serial_port("COM4");
        this.board_shim = new BoardShim(board_id, params);
        this.board_shim.prepare_session();
        this.board_shim.config_board("2345678x1060100X");
    }

    /**
     * Gets data from the board
     * @param seconds -- int representing the number of seconds the stream should be
     * @throws Exception
     */
    public CytonData streamData(int seconds) throws Exception {
        int ms = seconds * 1000;

        // start stream
         board_shim.start_stream (); // use this for default options
//        this.board_shim.start_stream(450000, "file://file_stream.csv:w");
        BoardShim.log_message(LogLevels.LEVEL_INFO.get_code(), "Start sleeping in the main thread");
        Thread.sleep(ms);
        this.board_shim.stop_stream();

        // print data
        double[][] data = this.board_shim.get_board_data(); // get all data and flush from ring buffer
        double[] channelOne = data[1];

        CytonData cd = new CytonData(channelOne, seconds);
        return cd;
    }

    public void releaseSession() throws Exception {
        this.board_shim.release_session();
    }
}
