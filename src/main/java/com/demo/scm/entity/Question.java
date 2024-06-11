package com.demo.scm.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.HttpClientErrorException.Forbidden;

public class Question {

	public static void main(String[] args) {
	String  [] words= {"babel","tcbel","mcbel"};
	System.out.println("words"+words.length);
	String word=words[0];
	System.out.println(word.length());
List<Character> finalChar=new ArrayList<>();
	for(int i=1;i<words.length;i++) {
		String compWord=words[i];
		for(int j=0;j<word.length();j++) {
			int m=1;
			char ch=word.charAt(j);
			System.out.println("comp"+compWord.length());
			for(int k=0;k<compWord.length();k++) {
				if(ch==compWord.charAt(k)) {
					m++;
					if(m==words.length) {
						if(finalChar.contains(m)) {
							finalChar.add(ch);
							
						}
						}	
				}
			
				
			}
		}
		
	}
	
	
	for(Character ch:finalChar) {
		
		System.out.println("finalval"+ch.charValue());
	}
}

}
