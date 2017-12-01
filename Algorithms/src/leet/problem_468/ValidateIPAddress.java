package leet.problem_468;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	public static void main(String[] args) {
		String ip = "255.234.2.2";
		// String ip = "172.16.254.1";
		// String ip = "01.01.01.01";
		// String ip =
		// "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111.";
		// String ip = "2001:0db8:85a3:0:0:8A2E:0370:734";

		System.out.println(new ValidateIPAddress().validIPAddress(ip));
	}

	public String validIPAddress(String IP) {
		if (IP == null || IP.isEmpty())
			return "Neither";
		if (IP.contains(":")) {
			return (isV6(IP) ? "IPv6" : "Neither");
		} else {
			return (isV4(IP) ? "IPv4" : "Neither");
		}
	}

	private boolean isV6(String ip) {
		int colonCount = 0;
		//Count the number of colons. if its more than 7, return false
		for (int i = 0; i < ip.length(); i++)
			if (ip.charAt(i) == ':')
				colonCount++;
		if (colonCount != 7)
			return false;
		
		String gr[] = ip.split(":");
		//Split the string, and recheck if its split into 8 parts
		//Return false if its less than 8
		if (gr.length != 8)
			return false;
		for (String g : gr) {
			//Each part has to be non empty
			if (g.isEmpty())
				return false;
			//Each part should be 4 characters long
			if (g.length() > 4) {
				return false;
			}
			//Each character should only be a alphanumeric
			for (int i = 0; i < g.length(); i++) {
				char ch = g.charAt(i);
				if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
					return false;
			}
		}
		return true;
	}

	private boolean isV4(String ip) {
		int dotCount = 0;
		//Count the number of dots.
		for (int i = 0; i < ip.length(); i++)
			if (ip.charAt(i) == '.')
				dotCount++;
		//Return false if more than 3 dots exist
		if (dotCount != 3)
			return false;
		//Split and check the length of the array returned
		String gr[] = ip.split("\\.");
		if (gr.length != 4)
			return false;
		
		for (String g : gr) {
			//Check if each part is non empty
			if (g.isEmpty())
				return false;
			try {
				//Parse the integer, and verify if its less than 256
				int val = Integer.parseInt(g);
				if ((val + "").equals(g) == false)
					return false;
				if (val > 255 || val < 0)
					return false;
				//There shouldnt be any trailing 0s
				//The value should be a '000000'
				if (g.charAt(0) == '0' && (val != 0 || g.length() != 1))
					return false;
			} catch (NumberFormatException ex) {
				return false;
			}

		}
		return true;
	}
}
