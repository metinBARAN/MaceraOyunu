import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int healty;
    private int money;
    private int originalHealth;
    private String charName;
    Scanner input=new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
       // geri kalanları oyunda kullanıcıya seçtireceğimiz için yazmamıza gerek yok
    }

    public void selectChar(){
       /* Samurai samurai=new Samurai();
        Archer archer=new Archer();
        Knight knight=new Knight();

        */
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};

        System.out.println("----------------------------------------");
        for (GameChar gameChar:charList) {
            System.out.println("Karakter: "+gameChar.getName()+
                               "\tid: "+gameChar.getId()+
                               "\tHasar: "+gameChar.getDamage()+
                               "\tSaglik: "+gameChar.getHealth()+
                               "\tPara: "+gameChar.getMoney());
        }
        System.out.println("----------------------------------------");
        System.out.println("Bir Karakter Seciniz:");
        int selectChar=input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());


        }
       /* System.out.println("Karakter: "+ this.getName()+
                " Hasar: "+this.getDamage()+
                " Saglik: "+this.getHealty()+
                " Money: "+this.getMoney());

        */

    }


    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealty(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());// safeHouse gittiğimizde canımızın yenilenme işlemi
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());

    }
    public void printInfo(){// Player'in durumu ekrana bastırıyoruz
        System.out.println("Silah: "+ this.getInventory().getWeapon().getName()+
                ", Zirh: "+this.getInventory().getArmor().getName()+
                ", Blocklama: "+this.getInventory().getArmor().getBlock()+
                ", Hasariniz: "+this.getTotalDamage()+
                ", Saglik: "+this.getHealty()+
                ", Money: "+this.getMoney());

    }



    // Satın aldığımız silah ile toplam Hasarımızı yansıttık
    public int  getTotalDamage(){
        return damage+damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        if (healty<0){
            healty=0;
        }
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
