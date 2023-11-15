package com.example;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class App {
/**
 * @param args
 */
public static void main(String[] args) {
try {
System.out.println("Server in avvio");


ServerSocket server = new ServerSocket(3000);
Socket s = server.accept();


System.out.println("un client si è collegato");
BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
DataOutputStream output = new DataOutputStream(s.getOutputStream());

//logica
String[] parole = {"kawasaki", "bmw", "ducati", "yamaha", "porche", "lamborghini", "ferrari", "mazda", "wacos", "lasagna"};
                        int n = (int)(Math.random()*10+1);
                        String a = parole[n];
                        System.out.println("la parola è --> " + a);
                        String temp = "";

                        for(int i = 0 ; i<a.length();i++){
                            temp+="*";
                        }


                        String tentativo = "";
                        do{
                            tentativo = input.readLine();
                            String mandalclient = "";
                            System.out.println(tentativo + "\n");


                            if (tentativo.length()==1) {
                                if (a.contains(tentativo)) {
                                    for(int i = 0; i < a.length();i++){
                                        if(a.charAt(i) == tentativo.charAt(0)){
                                            mandalclient+=tentativo;
                                            char[] caratteri = temp.toCharArray();
                                            caratteri[i] = tentativo.charAt(0);
                                            temp = String.valueOf(caratteri);
                                        }
                                        else{
                                            mandalclient+="*";
                                        }
                                    }
                                }
                                else{
                                    mandalclient = "f";
                                }
                                System.out.println("1" + mandalclient);
                                output.writeBytes(temp + "\n");
                                if(!temp.contains("*"))
                                    output.writeBytes("@" + "\n");
                            }
                            else{
                                System.out.println("tentativo = " + tentativo + "\nparola = " + a);
                                if(a.equals(tentativo)){
                                    output.writeBytes("@" + "\n");
                                    System.out.println("indovinata");
                                }
                                else{
                                    output.writeBytes("f" + "\n");
                                    System.out.println("errore");
                                }
                                    
                            }





                        
                        }while(!tentativo.equals(a));


                        output.writeBytes("@" + "\n");




s.close();
server.close();


} catch (Exception e) {
System.out.println(e.getMessage());
System.out.println("errore durante l'istanza del server");
System.exit(1);
}
}
}
