package myProject;

import java.util.Arrays;
import java.util.Scanner;

public class SortingWords {

	//globalde tanımlamamım herhangi bir sebebi yok öylesine :D
	static Scanner sc = new Scanner(System.in);
	static String alfabe = "defgauğıvijçklümnocöprsyhbştz"; 
	static String[] kelime = {"Ahmet","Ayşe","Mehmet","Defassa","Defazzz","dEfine","SElam","NAber"};
	public static String[] siraKontrol(String[] kelimeler) 
	{	char[] tempArr1 ;
		char[] tempArr2 ;
		String temp = "";
		// bubble sort
		for (int x = 0; x <= kelimeler.length-1; x++) {
			
			//int ind = getIndex2(tempArr1, tempArr2);
		for (int i = 1; i <= kelimeler.length-1 ; i++) {
			//tek tek harflerin alfabe sırası kontrol etmek için char array oluşturdum.
			tempArr1 = kelimeler[i-1].toLowerCase().toCharArray();
			tempArr2 = kelimeler[i].toLowerCase().toCharArray();
			//eğer ilk kelimenin ilk harfinin sırası bir sonraki kelimeninkinden büyükse true dönüyor ve yerleri değişiyor. 
			if (getIndex2(tempArr1, tempArr2)==true)
			{
				temp = kelimeler[i-1];
				kelimeler[i-1]=kelimeler[i];
				kelimeler[i]=temp;
			}
		}
		}
		return kelimeler;
	}
	
	public static boolean getIndex2(char[] x1,char[] x2) 
	{ 
		int x = 0;
		if(x1.length > x2.length) 
		{
			x = x2.length;
		}
		else if(x1.length < x2.length) 
		{
			x = x1.length;
		}
		else 
		{
			x = x1.length;
		}
		//x değeri 2 kelimeden en küçük uzunluğa sahip olanın uzunluğunu atadım Array.outofbound hatası almamak için
		//
		for(int i = 0 ;i<x;i++) 
		{
			//eğer ilk kelimenin ilk harfinin sırası bir sonraki kelimeninkinden büyükse true dönüyor
			if (getIndex(x1[i]) > getIndex(x2[i]))
			{
				return true;
			}
			//eğer ilk kelimenin ilk harfinin sırası bir sonraki kelimeninkinden büyük değilse false dönüyor
			else if(getIndex(x1[i]) < getIndex(x2[i]))
			{return false;}
			// eğer kelimenin tamamına bakıldı ve büyüklük küçüklük durumu oluşmadıysa ve ilk kelimenin uzunluğuna eşitse false
			// bu sayede örneğin emre ve emrey diye iki girdimiz varsa kodda karışıklık oluşmayacak
			// kısa olan kelime ilk kelime ise yer değişikliği yapmıyoruz ancak kısa olan kelime ikince kelime ise yer değişiyoruz
			else if(i == x-1 && x1.length==x) {
				return false;}
			else if(i == x-1 && x2.length==x) {
				return true;}
			
		}
		return true;
		
	}
	//karakterin alfabe sırasını bulan method
	public static int getIndex(char ch)
	{
		return alfabe.indexOf(ch);
	} 
	{
		
	}
	public static void main(String[] args) {
		String sa ="rdbms postgresql";
		System.out.println(sa.toUpperCase());
		int option = 0;
		System.out.println("sistemdeki alfabe ve string dizisini kullanmak için 1 giriniz");
		System.out.println("yeni alfabe ve yeni string dizisi girmek için 2");
		option = sc.nextInt();
		if(option == 1) 
		{
			System.out.println("mevcut alfabe: "+alfabe);
			System.out.println("düzenlenmesi istenilen kelime dizisi: "+ Arrays.toString(kelime));
			System.out.println("düzenleme sonrası: "+Arrays.toString(siraKontrol(kelime)));
		}
		else if(option == 2) 
		{
			alfabe="";
			System.out.println("alfabe giriniz");
			alfabe = sc.next();
			//System.out.println(alfabe);
			System.out.println("String dizisi giriniz her kelimeden sonra virgül birakmayi unutmayin");
			String str = sc.next();
			// girilen string'i virgülü referans alıp  array e aktarıyorum 
			String[] strArr = str.split(",");
			System.out.println("mevcut alfabe: "+alfabe);
			System.out.println("düzenlenmesi istenilen kelime dizisi: "+ Arrays.toString(strArr));
			System.out.println("düzenleme sonrası: "+Arrays.toString(siraKontrol(strArr)));
			
		}
		sc.close();	
	}

}

