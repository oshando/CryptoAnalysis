package main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import android.zoo.Downloader;

public class Executor {
	public static void main(String... args) {
		String classpath = System.getProperty("java.class.path");
		String javaHome = System.getProperty("java.home");
		int i = 0;
		File[] listFiles = Downloader.DOWNLOAD_DIRECTORY.listFiles();
		for (File file : listFiles) {
			System.out.println(file);
			if (file.getName().endsWith(".apk") || file.getName().endsWith(".APK")) {
				String[] command = new String[] { javaHome + File.separator + "bin" + File.separator + "java","-Xmx4g","-Xss16m", "-cp",
						classpath, PerAPKAnalyzer.class.getName(), file.getAbsolutePath(), args[0]};
				System.out.println("Running command: " + Arrays.toString(command));
				try {
					ProcessBuilder pb = new ProcessBuilder(command);
					File reportsDir = new File("target/reports/");
					if(!reportsDir.exists())
						reportsDir.mkdirs();
					pb.redirectOutput(new File("target/reports/"+file.getName() + "-out.txt"));
					pb.redirectError(new File("target/reports/" +  file.getName() + "-err.txt"));
					Process proc = pb.start();
					proc.waitFor();
				} catch (IOException ex) {
					System.err.println("Could not execute timeout command: " + ex.getMessage());
					ex.printStackTrace();
				} catch (InterruptedException ex) {
					System.err.println("Process was interrupted: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
//			break;
////			i++;
//			if(i > 10)
//				break;
		}
	}

}
