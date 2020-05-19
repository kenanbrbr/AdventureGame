package survivalGame;

import java.util.Scanner;

public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        switch (characterMenu()){
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Şovalye",8,24,5);
                break;
            default:
                initPlayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter : "+getcName()+" ,Hasar:"+getDamage()+" ,Sağlık: "+getHealthy()+" ,Para:"+getMoney());

    }

    public int characterMenu(){
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1- Samuray \t Hasar : 5 \t Sağlık : 21 \t Para : 15 ");
        System.out.println("2- Okçu    \t Hasar : 7 \t Sağlık : 18 \t Para : 20 ");
        System.out.println("3- Şovalye \t Hasar : 8 \t Sağlık : 24 \t Para : 5 ");
        System.out.print("Karakter Seçiminiz : ");
        int characterID = scanner.nextInt();
        while(characterID<1 || characterID>3){
            System.out.print("Lütfen geçerli bir karakter seçiniz.");
            characterID= scanner.nextInt();
        }


        return characterID;
    }

    public void initPlayer(String cName, int damage, int healthy,int money){
        setcName(cName);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setrHealthy(healthy);
    }

    public int getTotalDamage(){
        return this.getDamage()+this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
}
