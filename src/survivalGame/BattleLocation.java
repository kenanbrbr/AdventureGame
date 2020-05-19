package survivalGame;

public abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    BattleLocation(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle= obstacle;
        this.award = award;
    }

    public boolean getLocation(){
        int obstacleCount = obstacle.count();
        System.out.println("Şuan Buradasınız : "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obstacleCount+" tane " + obstacle.getName() +" yaşıyor.");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            if(combat(obstacleCount)){
                System.out.println(this.getName()+" Bölgesindeki tüm düşmanları temizlediniz.");
                if(award.equals("Yemek") && player.getInventory().isFood() == false){
                    System.out.println(this.award+" Kazandınız!");
                    player.getInventory().setFood(true);
                }
                else if(award.equals("Su") && player.getInventory().isWater() == false){
                    System.out.println(this.award+" Kazandınız!");
                    player.getInventory().setWater(true);
                }
                else if(award.equals("Odun") && player.getInventory().isFirewood() == false){
                    System.out.println(this.award+" Kazandınız!");
                    player.getInventory().setFirewood(true);
                }
                return true;

            }if(player.getHealthy()<=0){
                System.out.println("Öldünüz");
                return false;
            }
        }
        return true;
    }

    BattleLocation(Player player) {
        super(player);
    }

    public boolean combat(int obsCount){

        for(int i=0; i<obsCount; i++){
            int defaultObstacleHealth =obstacle.getHealthy();
            playerStats();
            enemyStats();

            while(player.getHealthy() > 0 && obstacle.getHealthy()>0) {
                System.out.println("<V>ur veya <K>aç : ");
                String selectCase = scanner.nextLine();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("V")) {
                    System.out.println("Siz Vurdunuz !");
                    obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealthy() > 0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

                if(obstacle.getHealthy()<=0 && player.getHealthy()>0){
                    System.out.println("Düşmanı yendiniz!");
                    player.setMoney(player.getMoney()+obstacle.getAward());
                    System.out.println("Güncel Paranız : "+player.getMoney());
                    obstacle.setHealthy(defaultObstacleHealth);
                }
                System.out.println("------------------------------");

        }
        return true;
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri \n-----------------");
        System.out.println("Can : "+player.getHealthy());
        System.out.println("Hasar: "+player.getDamage());
        System.out.println("Para : "+player.getMoney());
        if(player.getInventory().getDamage()>0){
            System.out.println("Silah : "+player.getInventory().getWeaponName());
        }
        if(player.getInventory().getArmor()>0){
            System.out.println("Zırh : "+player.getInventory().getArmorName());
        }
    }

    public void enemyStats(){
        System.out.println("\n"+obstacle.getName() +" Değerleri \n-----------------");
        System.out.println("Can : "+obstacle.getHealthy());
        System.out.println("Hasar: "+obstacle.getDamage());
        System.out.println("Para : "+obstacle.getAward());
    }

    public void afterHit(){
        System.out.println("Oyuncu Canı : "+player.getHealthy());
        System.out.println(obstacle.getName()+" Canı : "+obstacle.getHealthy());
        System.out.println();
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
