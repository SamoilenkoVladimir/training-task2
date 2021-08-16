

public class Replacement {
	
	public static String wordReplace(String arrString,String r,Integer length) {
		//замена слов заданной длины на последовательность символов (при этом строка разбивается на слова)
		arrString=" "+arrString+" ";
		r=" "+r+" ";
		String newString[]=arrString.split(" ");
		arrString="";
        for (String string : newString) {
        	string=" "+string+" ";
            string=string.replaceAll(String.format("\\s\\S{%d}\\s+", length), r);
            arrString=arrString+string;
           // System.out.println("after ="+string);
        }
        arrString=" "+arrString+" ";
        arrString = arrString.replaceAll("\\p{Blank}+", " ");
		
		
		return arrString.substring(1, arrString.length()-1);
	}

}

