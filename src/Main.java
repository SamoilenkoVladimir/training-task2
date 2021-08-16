

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Создать программу обработки текста учебника по программированию с использованием классов (по необходимости) для представления: символа, слова, предложения, знака препинания и др. Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом. Программа должна обрабатывать адреса электронной почты и номера телефонов в формате +XXX(XX)XXX-XX-XX как отдельные слова.
 		//в15  В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
		
		
        try (BufferedReader br = new BufferedReader(new FileReader("book1.txt"))) //книга считывается из файла
        {

           String sCurrentLine;
           Sentence sent=new Sentence("");
            while ((sCurrentLine = br.readLine()) != null) {
            	sCurrentLine = sCurrentLine+" ";
            	sCurrentLine = sCurrentLine.replaceAll("\\p{Blank}+", " ");
              	sent.setS(sent.getS()+sCurrentLine);
            }

      
        
        
        String[] book = sent.getS().split("[?!\\.]+\\s");
        for(String sentSplit : book){
        	
        	System.out.println(sentSplit);
        }
      		 
		    
		    
		    @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
		    Integer num;
		    Integer wordLength;
		    String replace = "";
		    
		    System.out.println("\n в книге "+book.length+" строк");
		    Boolean exit = false;
			while (!exit) {
		    System.out.println("ведите номер строки книги для замены слов");
		    num=in.nextInt();
		    if (num >0 && num<=book.length) {
		    	System.out.println("Выбранная строка:");
		    	System.out.println(book[num-1].toString());
		    	System.out.println("ведите количество букв в слове, которое будем менять на подстроку");
		    	wordLength=in.nextInt();
		    	
		    	System.out.println("ведите подстроку");
		    	Scanner str = new Scanner(System.in);
		    	replace=str.nextLine();
		    	str.close();
		    	System.out.println("Ваша подстрока:\n"+replace);
		    	replace=Replacement.wordReplace(book[num-1],replace,wordLength);
		    	System.out.println("Новая строка:\n"+replace);
		    	book[num-1]=replace;
		    	exit = true;
		    }
			 
			} 
			for (String str : book)
			{
			    str=str+"\\n";
			}

		
		    in.close();
		    
		    //вывод измененной книги в файл output.txt
		    BufferedWriter bw1 
	        = new BufferedWriter(new FileWriter("output.txt"));
		    bw1.write("");
		    bw1.close();
		    
		    for(int i = 0; i < book.length; i++) {
		    	  try (BufferedWriter bw 
		    	        = new BufferedWriter(new FileWriter("output.txt", true))) {
		    	    String s;
		    	    s = book[i];
		    	    bw.write(s);
		    	    bw.newLine();
		    	    bw.flush();
		    	  } catch(IOException ex) { 
		    	    ex.printStackTrace();
		    	  }
		    	} 
		    
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
        
	}

}
