package Util;

import android.nfc.Tag;
import android.util.Log;

import java.text.SimpleDateFormat;

/**
 * Created by kapil.kumar1 on 01/10/18.
 */

public class LoggerUtils {

    /**
     *			LoggerUtils will allow user to report various logs with
     *         level like info, debug, warning and error. this also does log in
     *         console and also puts that in testNG reporter output.
     */


    private LoggerUtils() {

    }

    /**
     * Log Info, this is the highest level of logging. Should be used for
     * logging test intent, and actions.
     */
    public static void info(String text) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("INFO: [%s] %s", timestamp, text);
        System.out.println("----> " + text);
        Log.d("",String.format("<div style=\"color:green\">%s</div>", text));

        //	Reporter.log(String.format("<div style=\"color:green\">%s</div>", text), false);
    }

    public static void error(String text) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("ERROR: [%s] %s", timestamp, text);
        System.out.println("!---- " + text);
        Log.d("",String.format("<div style=\"background-color:red; color:white\">%s</div>", text));
    }

}
