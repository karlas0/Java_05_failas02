package failas;

import com.company.Main;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class failas {
    private Scanner _sc;
    private FileWriter _out;
    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;

    public static void main(String[] args) {
        Main objektas = new Main();
        objektas.irasymasIFaila();
        objektas.skaitymasIsFailo();
        objektas.atidarytiFaila();
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
                for (int i = 0; i < zodziai.length; i++) {
                    System.out.println(zodziai[i]);
                    System.out.println();
                    eilute = _bufferis.readLine();


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
        System.out.println("Iveskite teksta ka rasysiti i faila");
        System.out.println("parasius pabaiga irasymas bus nutrauktas");
        String tekstas = _sc.nextLine();
        try {
            _out = new FileWriter(_failoVardas);
            while (!tekstas.equals("pabaiga")) {
                _out.write(tekstas);
                _out.write('\n' + tekstas);
                tekstas = _sc.nextLine();
            }
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


