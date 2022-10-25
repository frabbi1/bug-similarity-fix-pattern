package core;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ModelBugSim.BuggyMethod;

public class StructuralTokenSimilarityMetric {
	

	public void run(List<BuggyMethod> buggyMethods) throws IOException {
		//System.out.println(buggyMethods.get(0).methodDeclaration.getBody().toString());
		String methodBody = buggyMethods.get(0).methodDeclaration.getBody().toString();
		runPython(methodBody);
	}
	
	public void runPython(String methodBody) throws IOException 
	{ //need to call myscript.py and also pass arg1 as its arguments.
	  //and also myscript.py path is in C:\Demo\myscript.py

	    String[] cmd = {
	      "python",
	      "Python/structural_token_sim.py",
	      methodBody,
	    };
	    Process p = Runtime.getRuntime().exec(cmd);
	    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    String s = null;
	    while((s = in.readLine()) != null) {
	    	System.out.println(s);
	    }
	}

}
