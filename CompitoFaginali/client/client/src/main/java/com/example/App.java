package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


/**
* Hello world!
*
*/
public class App
{
public static void main( String[] args )
{
try {
System.out.println( "Il client è partito" );
Socket s = new Socket("localhost", 3000);
Scanner tastiera = new Scanner(System.in);




BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
DataOutputStream output = new DataOutputStream(s.getOutputStream());



                        String rispostaS;
                        String inputUser = "";
                        do{
                        System.out.println("indovina la parola \n");
                        inputUser = tastiera.nextLine();
                        output.writeBytes(inputUser + "\n");
                        rispostaS = input.readLine();
                        System.out.println(rispostaS);
                        }while(!rispostaS.equals("@"));


                        System.out.println("Hai indovinato");




s.close();


} catch (Exception e) {
System.out.println(e.getMessage());
System.out.println("errore durante l'istanza del server");
System.exit(1);
}
}
}
