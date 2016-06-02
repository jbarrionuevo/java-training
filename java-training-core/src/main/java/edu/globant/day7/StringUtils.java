package edu.globant.day7;

public class StringUtils {

	public boolean isEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public boolean isBlank(String s) {
		return s == null || s.trim().isEmpty();
	}
}
