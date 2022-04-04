/**
 * Transforms raw CytonData into corresponding strength
 */
public class TransformRawData {

    public static double[] transform(double[] originalData) {
        // getting data
        int length = originalData.length;
        double timeInterval = Main.DATA_COLLECTION_TIME / (double)length;

        // absolute value transformation
        double[] transformedData = new double[length];
        for (int i = 0; i < length; i++) {
            transformedData[i] = Math.abs(originalData[i]);
        }

        // integral calculation (area by rectangles)
        double[] area = new double[length];
        for (int i = 0; i < length; i++) {
            area[i] = transformedData[i] * timeInterval;
        }

        return area;
    }

//    public static double[] transform(CytonData data) {
//        // getting data
//        double[] originalData = data.getData();
//        int time = data.getSeconds();
//        int length = originalData.length;
//        double timeInterval = time / length;
//
//        // absolute value transformation
//        double[] transformedData = new double[length];
//        for (int i = 0; i < length; i++) {
//            transformedData[i] = Math.abs(originalData[i]);
//        }
//
//        // integral calculation (area by rectangles)
//        double[] area = new double[length];
//        for (int i = 0; i < length; i++) {
//            area[i] = transformedData[i] * timeInterval;
//        }
//
//        return area;
//    }
}
