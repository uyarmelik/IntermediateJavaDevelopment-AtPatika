import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("Kaç takım olacak: ");
        String ts = sc.next();

        while (sayiMi(ts)) {
            System.out.print("Lütfen bir sayı giriniz: ");
            ts = sc.next();
        }

        int takimSayisi = Integer.parseInt(ts);
        Set<String> takimlar = new TreeSet<>();

        for (int i = 0; i < takimSayisi; i++) {
            System.out.print((i + 1) + ". takımı giriniz: ");
            takimlar.add(sc.next());
        }

        if (takimlar.size() % 2 == 1) takimlar.add("BAY");

        int randomSayi, hafta=0, ayniMacVarMi=0, toplamHafta = (takimlar.size() - 1) * 2, haftalikMac = takimlar.size() / 2;
        String temp="";
        boolean dongu = true;
        String[][] fikstur = new String[toplamHafta][haftalikMac];
        String[] haftaKontrol = new String[(takimlar.size())];
        List<String> takimlarTemp = new ArrayList<>(takimlar);

        for (int kacDefaDonecegi = 0; kacDefaDonecegi < takimlar.size()-1; kacDefaDonecegi++) {
            while (dongu) {
                takimlarTemp.clear();
                takimlarTemp.addAll(takimlar);

                for (int i = 0; i < takimlar.size(); i++) {

                    randomSayi = ran.nextInt(takimlarTemp.size());

                    if (i % 2 == 0) {
                        temp = takimlarTemp.get(randomSayi);
                        takimlarTemp.remove(randomSayi);
                    }

                    else {
                        haftaKontrol[i / 2] = temp + " - " + takimlarTemp.get(randomSayi);
                        haftaKontrol[(i / 2) + haftalikMac] = takimlarTemp.get(randomSayi) + " - " + temp;
                        takimlarTemp.remove(randomSayi);
                    }
                }

                if (hafta == 0) break;

                for (int i = 0; i < hafta; i++) {
                    for (int j = 0; j < haftalikMac; j++) {
                        for (int k = 0; k < takimlar.size(); k++){
                            if (fikstur[i][j].equals(haftaKontrol[k]) || fikstur[hafta-1][j].startsWith(temp)) ayniMacVarMi++;
                        }
                    }
                }

                if (ayniMacVarMi==0) dongu=false;
                ayniMacVarMi=0;
            }

            for (int sutun = 0; sutun<haftalikMac; sutun++){
                fikstur[hafta][sutun] = haftaKontrol[sutun];
                fikstur[hafta+(takimlar.size()-1)][sutun] = haftaKontrol[sutun+haftalikMac];
            }

            hafta++;
            dongu=true;
        }

        for (int i=0; i<toplamHafta; i++){
            System.out.println("\n" + (i+1) + ". Hafta: ");
            for (int j=0; j<haftalikMac; j++){
                System.out.println(fikstur[i][j]);
            }
        }

    }

    private static boolean sayiMi(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return true;
        }
        return false;
    }

}