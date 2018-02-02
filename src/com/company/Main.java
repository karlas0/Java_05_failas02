package com.company;

import failas.*;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    private Scanner _sc;
    private FileWriter _out;
    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;

    public static void main(String[] args) {
        Main objektas = new Main();
        objektas.vykdykProgramaBeGalo();
        objektas.atidarytiFaila();
        objektas.skaitymasIsFailo();
    }


    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }

    public void skaitymasIsFailo() {
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                for (int i = 0; i < eilute.length(); i++) {
                    System.out.println(zodziai[i]);
                }
            }
            System.out.println();
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }


    }

    public void irasymasIFaila() {
        _sc = new Scanner(System.in);
        System.out.println("Iveskite teksta ka rasysite i faila");
        System.out.println("parasius pabaiga irasymas bus nutrauktas");
        String tekstas = _sc.nextLine();
        try {
            _out = new FileWriter(_failoVardas);
            while (!tekstas.equals("pabaiga")) {
                _out.write(tekstas);
                _out.write('\n');
                tekstas = _sc.nextLine();
            }
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static final int EXIT_CODE = 0;
    public static final int ACTION_1 = 1;
    public static final int ACTION_2 = 2;
    public static final int ACTION_3 = 3;
    public static final int ACTION_4 = 4;
    public static final int ACTION_5 = 5;


    private void rodykPasirinkimus() {
        System.out.println("===============================");
        System.out.println("Koki veiksma norite atlikti");
        System.out.println(EXIT_CODE + " - Baigti darba");
        System.out.println(ACTION_1 + " - Parodyti visus irasus is failo ekrane");
        System.out.println(ACTION_2 + " - Prideti naujus irasu i faila");
        System.out.println(ACTION_3 + " - Trinti irasu is failo");
        System.out.println(ACTION_4 + " - Rasti visu zmones su norodyta akiu spalva");
        System.out.println(ACTION_5 + " - Rasti auksciausia zmogu is saraso");

        System.out.println("===============================");
    }

    public void vykdykProgramaBeGalo() {
        boolean arTesti = true;
        Scanner sc = new Scanner(System.in);
        failas objektas = new failas();
        while (arTesti == true) {
            rodykPasirinkimus();
            int veiksmas = sc.nextInt();
            switch (veiksmas) {
                case (EXIT_CODE):
                    arTesti = false;
                    break;
                case ACTION_1:
                    objektas.atidarytiFaila();
                    objektas.skaitymasIsFailo();
                    break;
                case ACTION_2:
                    objektas.atidarytiFaila();
                    objektas.irasymasIFaila();
                    break;
                case ACTION_3:
                    objektas.atidarytiFaila();
                    objektas.irasymasIFaila();
                    break;


            }

        }
    }
}
