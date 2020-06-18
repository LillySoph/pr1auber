package uebung01;
import static pr.MakeItSimple.*;
public class Wochentagsberechnung {

	public static void main(String[] args) {
	
	// Erklärung des Programms
	println("Bitte geben Sie ein gültiges Datum ein zwischen dem 01.01.1900 und dem 31.12.2019 und wir finden den Wochentag für Sie heraus ;) :");
	// Vereinbarung der Variable tag, monat und jahr als Integer (da Ganzzahl), Zuweisung der Methode readInt zur Variable 
	// und Eingabeaufforderung
	
	print("Tag im Format tt: ");
	int tag;
	tag = readInt();
	
	print("Monat im Format mm: ");
	int monat;
	monat = readInt();
	
	print("Jahr im Format jjjj: ");
	int jahr;
	jahr = readInt();
	
	
	
	// Vereinbarung von neuen Variablen für die Formel zur Berechnung des Wochentages
    int m = monat, j = jahr ;
    int wochentag;
    if (monat >=12 || monat <0) // || = oder
    	{
    	print("Monatseingabe ist falsch.");
    	}
    else {
		
    if (monat < 3)
    {
       m = monat + 12 ;
       j = jahr-1 ;
    }
   
    // Formel zur Berechnung des Wochentages
    wochentag = (tag+2*m + (3*m+3)/5 + j + j/4 - j/100 + j/400 + 1)%7 ;
    
    
    // Ausgabe des eingegeben Datums und des berechneten Wochentages
    print("\nIhr Datum ist der " + tag + "." + monat + "." + jahr + ". Dieser Tag ist ein ");
    
    if (wochentag==0)
       println("Sonntag.");
    else if (wochentag==1)
       println("Montag.");
    else if (wochentag==2)
       println("Dienstag.");
    else if (wochentag==3)
       println("Mittwoch.");
    else if (wochentag==4)
       println("Donnerstag.");
    else if (wochentag==5)
       println("Freitag.");
    else if (wochentag==6)
       println("Samstag.");

    // Falls eingegebener Tag = Heute, wird der folgende Print ausgegeben
    if (tag==10 && monat==10 && jahr==2019) 
    {
    	println("Das ist ja heute!!!");
    }
    } 
	}

}
