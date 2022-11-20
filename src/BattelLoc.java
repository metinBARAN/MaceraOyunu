import java.util.Locale;
import java.util.Random;

public abstract class BattelLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattelLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Suan buradasiniz: "+this.getName());
        System.out.println("Dikkatli ol burada "+obsNumber+" tane "+this.getObstacle().getName()+" yasiyor");
        System.out.println("<S>avas veya <K>ac ");
        String selectBattelLocCase=input.nextLine().toUpperCase();// her iki kullanımda alınabilir hangisini istersen
      //  selectBattelLocCase=selectBattelLocCase.toUpperCase();
        if (selectBattelLocCase.equals("S")){
              if (combat(obsNumber)){
                  System.out.println(this.getName()+" tüm düsmanlari yendiniz");
                  return true;
              }

        }
        if (this.getPlayer().getHealty()<=0){
            System.out.println("Oldunuz!");
            return false;
        }

        return true;// burada true bir üst menüye geri dönmemizi sağlıyor
    }
    public boolean combat(int obsNumber){ // karşı taraf ile savaşma metodumuz olacaktır
         for(int i=1;i<=obsNumber;i++){// Kaç canavarla çatışacaksam onu döngülüyor
             this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());//Canavarın her zaman başlangıçtaki canını orjinal canı ile değiştirme
             playerStarts();// Oyuncunun değerleri
             obstacleStarts(i); // Canavarın değerleri


             //Player veya canavarın birbirine kaç kez vuracağını bilmediğimiz için döngüyü kurduk
             while (this.getPlayer().getHealty()>0 && this.getObstacle().getHealth()>0){
                 System.out.println("<V>ur veya <K>ac :");
                 String selectCombat=input.nextLine().toUpperCase();
                 if (selectCombat.equals("V")){
                     System.out.println("Siz vurdunuz");
                     this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                     afterHit();
                     if (this.getObstacle().getHealth()>0){
                         System.out.println("Canavar size Vurdu");
                         int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                         if (obstacleDamage<0){
                             obstacleDamage=0;
                         }
                         this.getPlayer().setHealty(this.getPlayer().getHealty()-obstacleDamage);
                         afterHit();
                     }
                 }else{
                     return false;
                 }
             }
             if (this.getObstacle().getHealth()<this.getPlayer().getHealty()){
                 System.out.println("Dusmani yendiniz");
                 System.out.println(this.getObstacle().getAward()+" para kazandiniz");
                 this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                 System.out.println("Guncel paraniz: "+this.getPlayer().getMoney());
             }else {
                 return false;
             }
         }

        return true;
    }
    public void afterHit(){ // Canava vurduktan sonra yapılan işlem
        System.out.println("Caniniz: "+this.getPlayer().getHealty());
        System.out.println();

    }

    public void playerStarts(){ //Player istatistiklerini ekrana yazdırma işlemleri
        System.out.println("---Oyuncu Degerleri---");
        System.out.println("-------------------------------------");
        System.out.println("Saglik: "+this.getPlayer().getHealty());
        System.out.println("Silah: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Zirh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: "+this.getPlayer().getMoney());

    }

    public void obstacleStarts(int i){//Obstacle istatistiklerini ekrana yazdırma işlemleri
        System.out.println("--- "+i+". "+this.getObstacle().getName()+" Degerleri---");
        System.out.println("-------------------------------------");
        System.out.println("Saglik: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Odul: "+this.getObstacle().getAward());

    }


    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.maxObstacle)+1;//Random sıfır degerden başladığı için +1 ekledik
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
