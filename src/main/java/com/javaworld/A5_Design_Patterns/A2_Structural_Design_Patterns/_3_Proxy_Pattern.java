package com.javaworld.A5_Design_Patterns.A2_Structural_Design_Patterns;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 * 
 *         Proxy pattern intent is to �Provide a surrogate or placeholder for
 *         another object to control access to it�. The definition itself is
 *         very clear and proxy pattern is used when we want to provide
 *         controlled access of a functionality.
 * 
 *         Let�s say we have a class that can run some command on the system.
 *         Now if we are using it, its fine but if we want to give this program
 *         to a client application, it can have severe issues because client
 *         program can issue command to delete some system files or change some
 *         settings that you don�t want. Therefore we want to provide only admin
 *         users to have full access of above class, if the user is not admin
 *         then only limited commands will be allowed. So CommandExecutorProxy
 *         is our simple proxy class implementation.
 * 
 *         Proxy design pattern common uses are to control access or to provide
 *         a wrapper implementation for better performance. Java RMI package
 *         uses proxy pattern.
 * 
 * 
 */

interface CommandExecutor {

	public void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws java.io.IOException {
		// some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}

class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String user, String pwd) {
		if ("Pankaj".equals(user) && "pass".equals(pwd))
			isAdmin = true;
		executor = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new RuntimeException("rm command is not allowed for non-admin users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}

public class _3_Proxy_Pattern {
	public static void main(String... args) {
		CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("cmd.exe /c dir");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}

}
