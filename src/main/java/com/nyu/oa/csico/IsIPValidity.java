package com.nyu.oa.csico;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://leetcode-cn.com/problems/validate-ip-address/

/**
 * Given an input IPv4 address as a string. Check whether the iPv4address is valid.
 * <p>
 * Input
 * The first line of the input consists of a string - addressIP, representing the IPv4 address.
 * <p>
 * Output
 * Print a string "VALID" if the IPv4 address is valid. Otherwise, print "INVALID".
 * <p>
 * Note
 * <p>
 * The output should be VALID or INVALID
 * <p>
 * Examples
 * Example 1:
 * input:
 * 10.102.34.48
 * <p>
 * Output:
 * VALID
 * Explanation:
 * Here, all four parts or thsevalid.255.So the IP address is valid.
 * <p>
 * Example 2:
 * input:
 * 64.233.161.256
 * Output:
 * INVALID
 * Explanation:
 * Here, not all four parts of the IP address have ranges between 0 to 255. So, the IP address is invalid.
 */
public class IsIPValidity {

    public static String checkIPValidity(String addressIP) {
        // write your code here
        // Regex for digit from 0 to 255.
        String zeroTo255
                = "(\\d{1,2]|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

        // Regex for a digit from 0 to 255 and
        // followed by a dot，repeat 4 times.
        // this is the regex to validate an IP address.
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;
        // compile the ReGex
        Pattern p = Pattern.compile(regex);
        // If the IP address is empty
        // return false
        if (addressIP == null) {
            return "INVALID";
        }
        // Pattern class contains matcher() metho
        // to find matching between given IP address
        // and regular expression.
        Matcher m = p.matcher(addressIP);
        return m.matches() ? "VALID" : "INVALID";
    }

    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) return "INVALID";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) return "INVALID";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (! Character.isDigit(ch)) return "INVALID";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "INVALID";
        }
        return "VALID";
    }

    public String validIPAddress(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattenIPv4 =
                Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
        return (pattenIPv4.matcher(IP).matches()) ? "VALID" : "INVALID";
    }
}
