package edu.globant.day1.designpatterns;

import java.io.PrintStream;

public final class SingletonPatternLazy {

	private final PrintStream out;

	private SingletonPatternLazy() {
		out = System.out;
	}

	private static class Loader {
		static final SingletonPatternLazy INSTANCE = new SingletonPatternLazy();
	}

	public static SingletonPatternLazy getInstance() {
		return Loader.INSTANCE;
	}

	public void info(String s) {
		out.println("[INFO] " + s);
	}

	public void error(String s, Exception e) {
		out.println("[ERROR] " + s);
		if (e != null) {
			e.printStackTrace(out);
		}
	}

	public void error(String s) {
		error(s, null);
	}
}
