package com.javaworld;

public class AppUtil {

	public static String memoryConsumed(long startMem) {
		long totalMemory = Runtime.getRuntime().totalMemory();
		long afterUsedMem = totalMemory - Runtime.getRuntime().freeMemory();
		long bytes = afterUsedMem - startMem;
		long kilobyte = 1024;
		long megabyte = kilobyte * 1024;
		long gigabyte = megabyte * 1024;
		long terabyte = gigabyte * 1024;

		if ((bytes >= 0) && (bytes < kilobyte)) {
			return bytes + " B";

		} else if ((bytes >= kilobyte) && (bytes < megabyte)) {
			return (bytes / kilobyte) + " KB";

		} else if ((bytes >= megabyte) && (bytes < gigabyte)) {
			return (bytes / megabyte) + " MB";

		} else if ((bytes >= gigabyte) && (bytes < terabyte)) {
			return (bytes / gigabyte) + " GB";

		} else if (bytes >= terabyte) {
			return (bytes / terabyte) + " TB";

		} else {
			return bytes + " Bytes";
		}
	}

	public static long startMemory() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}


}
