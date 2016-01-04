package com.sumit.runcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdUtil {
	ProcessBuilder builder;

	public CmdUtil() {
		builder = new ProcessBuilder();
	}

	public String execute(String command) throws IOException {
		String commandArray[] = {"cmd", "/c", command};
		builder.command(commandArray);
		// ProcessBuilder builder = new ProcessBuilder(
		// "cmd.exe", "/c",
		// "cd \"C:\\Users\\sumit gupta\\workspaceLuna\\FindMyTrain\" && \"C:\\Users\\sumit gupta\\Downloads\\eclipse\\plugins\\com.google.appengine.eclipse.sdkbundle_1.9.30\\appengine-java-sdk-1.9.30\\bin\\appcfg.cmd\" update run\\FindMyTrain");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String wholeLine="";
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			wholeLine+=line+"\n";
		}
		r.close();
		return wholeLine;
	}
}
