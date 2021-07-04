package br.ipen.cestoque.utils;

import org.apache.commons.lang3.StringUtils;

public class UpperCaseAndTrim {

	public UpperCaseAndTrim() {
		// TODO Auto-generated constructor stub
	}
	
	public static String upperAndTrim(String str) {
        return str == null ? null : str.toUpperCase().trim();
    }
	
	public static String upperAndTrimAndWitespace(String str) {
        return str == null ? null : StringUtils.deleteWhitespace(str.toUpperCase().trim());
    }

}
