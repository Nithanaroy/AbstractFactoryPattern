package utilities;

public class Logger {
	public static boolean DEBUG = true;

	public static boolean logErrorIfDebug(String message) {
		if (DEBUG)
			System.out.println(String.format("D: %s", message));
		return DEBUG;
	}
}
