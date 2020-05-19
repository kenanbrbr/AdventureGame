package survivalGame;

import java.util.Scanner;

public class ToolStore extends NormalLocation {

    ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public boolean getLocation(){
        System.out.println("Para : "+player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.print("Seçiminiz : ");
        int selectTool = scanner.nextInt();

        switch (selectTool){
            case 1:
                buyWeapon(weaponMenu());
                break;
            case 2:
                buyArmor(armorMenu());
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("1.Tabanca \t <Para : 25 - Hasar : 2>");
        System.out.println("2.Kılıç \t <Para : 35 - Hasar : 3>");
        System.out.println("3.Tüfek \t <Para : 45 - Hasar : 7>");
        System.out.println("4.Çıkış");
        System.out.print("Silah Seçiniz : ");
        int sellWeaponID = scanner.nextInt();
        return sellWeaponID;
    }

    public void buyWeapon(int itemID){
        int damage=0,price=0;
        String weaponName = null;

            switch (itemID){
                case 1:
                    weaponName="Tabanca";
                    damage=2;
                    price=5;
                    break;
                case 2:
                    weaponName="Kılıç";
                    damage=3;
                    price=35;
                    break;
                case 3:
                    weaponName="Tüfek";
                    damage=7;
                    price=45;
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor");
                default:
                    System.out.println("Geçersiz İşlem!");
                    break;
            }

            if(player.getMoney()>=price && price>0 ){
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-price);

                System.out.println(weaponName+" Satın aldınız, Önceki Hasar :"+player.getDamage()+
                        "Yeni Hasar:"+player.getTotalDamage());
                System.out.println("Kalan para :" +player.getMoney());
            }else{
                System.out.println("\n !! Para Yetersiz !!");
            }
    }

    public int armorMenu(){
        System.out.println("1.Hafif \t <Para : 15 - Hasar : 1>");
        System.out.println("2.Orta \t <Para : 25 - Hasar : 3>");
        System.out.println("3.Ağır \t <Para : 40 - Hasar : 5>");
        System.out.println("4.Çıkış");
        System.out.print("Silah Seçiniz : ");
        int armorID = scanner.nextInt();
        return armorID;
    }

    public void buyArmor(int selectItemID){

        int avoid=0,price=0;
        String armorName = null;

        switch (selectItemID){
            case 1:
                armorName="Hafif Zırh";
                avoid=1;
                price=15;
                break;
            case 2:
                armorName="Orta Zırh";
                avoid=3;
                price=25;
                break;
            case 3:
                armorName="Ağır Zırh";
                avoid=5;
                price=40;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor");
            default:
                System.out.println("Geçersiz İşlem!");
                break;
        }

        if(player.getMoney()>=price && price>0 ){

            player.getInventory().setArmor(avoid);
            player.getInventory().setArmorName(armorName);
            player.setMoney(player.getMoney()-price);

            System.out.println(armorName+" Satın aldınız, Engellenen Hasar :"+player.getInventory().getArmor());
            System.out.println("Kalan para :" +player.getMoney());
        }else{
            System.out.println("\n !! Para Yetersiz !!");
        }

    }
}
