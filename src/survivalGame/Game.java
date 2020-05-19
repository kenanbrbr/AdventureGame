package survivalGame;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Oyuna başlamadan önce isminizi giriniz : ");

        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCharacter();

        start();
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("==================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz");
            System.out.println("1. Güvenli ev --> Size ait güvenli bir mekan, düşma yok!");
            System.out.println("2. Mağara --> Karşınıza zombi çıkabilir!");
            System.out.println("3. Orman  --> Karşınıza vampir çıkabilir!");
            System.out.println("4. Nehir  --> Karşınıza ayı çıkabilir!");
            System.out.println("5. Mağaza --> Silah veya zırh alabilirsiniz!");
            System.out.print("Gitmek İstediğiniz Yer : ");
            int selectLocation = scanner.nextInt();
            while(selectLocation<0 || selectLocation>5){
                System.out.println("Lütfen geçerli bir yer seçiniz.");
                selectLocation = scanner.nextInt();

            }

            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInventory().isFood() && player.getInventory().isFirewood()
                && player.getInventory().isWater()){
                    System.out.println("Tebrikler Oyunu Kazandınız!!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("!! Oyun Bitti !!");
                break;
            }
        }
    }
}
