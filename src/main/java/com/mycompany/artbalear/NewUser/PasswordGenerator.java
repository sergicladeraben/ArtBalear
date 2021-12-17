
package com.mycompany.artbalear.NewUser;

public class PasswordGenerator {
 
	public static String numeros = "0123456789";
 
	public static String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
	public static String minusculas = "abcdefghijklmnopqrstuvwxyz";
 
	public static String especiales = "ñÑ";
 

 
	public static String getPassword() {
		return getPassword(8);
	}
 
	public static String getPassword(int length) {
		return getPassword(numeros + mayusculas + minusculas, length);
	}
 
	public static String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
	}
        
        public static void main(String[] args) {
        PasswordGenerator contra = new PasswordGenerator();
            System.out.println(PasswordGenerator.getPassword());
    }
}