import java.util.Scanner;

public class Solution {

    /**
     * Converts 12-hour AM/PM format to 24-hour format.
     * @param s The time string in 'hh:mm:ssAM' or 'hh:mm:ssPM' format.
     * @return The time string in 'HH:mm:ss' format.
     */
    public static String timeConversion(String s) {
        // Get the AM/PM suffix
        String modifier = s.substring(8);
        // Get the hour part as an integer
        int hour = Integer.parseInt(s.substring(0, 2));
        // Get the mm:ss part
        String minutesSeconds = s.substring(2, 8);

        if (modifier.equals("AM")) {
            // Special case: 12:00:00AM becomes 00:00:00
            if (hour == 12) {
                return "00" + minutesSeconds;
            }
            // Other AM hours remain the same (with leading zero)
            return String.format("%02d", hour) + minutesSeconds;
        } else {
            // Special case: 12:00:00PM remains 12:00:00
            if (hour == 12) {
                return "12" + minutesSeconds;
            }
            // Other PM hours: add 12 (e.g., 07PM becomes 19)
            return (hour + 12) + minutesSeconds;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Read input (e.g., 07:05:45PM)
        if (scan.hasNextLine()) {
            String inputTime = scan.nextLine();
            
            // Call the conversion function
            String result = timeConversion(inputTime);
            
            // Print output (e.g., 19:05:45)
            System.out.println(result);
        }
        
        scan.close();
    }
}
