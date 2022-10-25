package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ModelBugSim.BuggySourceFileProperty;

public class DirectoryScanner {
	
	private static String projectName = "";
	private static String projectPath = "";
	private static List<BuggySourceFileProperty> buggyFiles = new ArrayList<BuggySourceFileProperty>();
	
	public static void scan(File[] files, boolean isProjectFolder) {
		if(files != null) {
			for (File file : files) {
				
				if (isProjectFolder) {
					projectName = file.getName();
					projectPath = file.getAbsolutePath();
				}
				
				if(file.isFile() && file.getName().endsWith(".java")) {
					buggyFiles.add(new BuggySourceFileProperty(file.getName(), file.getAbsolutePath(), projectName, projectPath));
					System.out.println("running..");
				}
				else if (file.isDirectory()) {
					scan(file.listFiles(), false);
				}
			}
		}
		
		//return buggyFiles;
	}
	
	public static List<BuggySourceFileProperty> getBuggyFiles(){
		return buggyFiles;
	}

}
