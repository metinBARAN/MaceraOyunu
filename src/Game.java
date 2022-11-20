import java.util.Scanner;

public class Game {

  Scanner input=new Scanner(System.in);
    public void start(){

        System.out.println("Macera oyununa hosgeldiniz ");
        //System.out.println("Lutfen bir isim giriniz:");
       // String playerName=input.nextLine();
        Player player=new Player("metin");
        System.out.println("Sayin "+player.getName()+" Hosgeldiniz");
        System.out.println("Lutfen bir karakter seciniz: ");
        player.selectChar();
        Location location=null;
        while (true){
            player.printInfo();// Player'in durumu ekrana bastırıyoruz
            System.out.println("--Bolgeler--");
            System.out.println("1-Guvenli Ev");
            System.out.println("2-Magaza");
            System.out.println("3-Magara");
            System.out.println("4-Orman");
            System.out.println("5-Nehir");
            System.out.println("0-Cikis");
            System.out.println("Lutfen gitmek istediginiz bolgeyi secin");
            int selectLoc=input.nextInt();

            switch (selectLoc){//kullanıcıdan değer aldık
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Lutfen gecerli bir bolge giriniz! ");

            }
            if (location==null){
                System.out.println("Oyundan vazgectin");
                break;

            }
            if (!location.onLocation()){
                System.out.println("Oyun bitti");
                break;
            }

        }

    }
}
