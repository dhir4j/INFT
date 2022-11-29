package javaprogram;

import java.io.DataInputStream;

public class exp1 {
    public static void main(String[] args) {

        Double GS, NS, DA, BS, HRA, CCA = 240.0, PF;
        String EN;
        int END;
        DataInputStream in = new DataInputStream(System.in);

        try {
            System.out.println("Please neter the employee name: ");
            EN = in.readLine();
            System.out.print("Please enter the employee number: ");
            END = Integer.parseInt(in.readLine());
            System.out.println("Please enter the BS: ");
            BS = Double.parseDouble(in.readLine());

            DA = BS * 0.7;
            HRA = BS * 0.3;
            PF = BS * 0.1;
            GS = DA + HRA + PF + CCA;
            System.out.println("The gross salary:" + GS);
            NS = GS - 100;
            System.out.println("The net salary: " + NS);

        } catch (Exception e) {
            System.out.println("Error: " + e);

        }

    }
}