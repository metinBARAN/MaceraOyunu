public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    @Override
    public boolean onLocation() {// normalLoc ölme ihtimalimiz olmadığı için return true yapıyoruz
        System.out.println("Guvenli Evdesiniz");
        System.out.println("Caniniz yenilendi");
        this.getPlayer().setHealty(this.getPlayer().getOriginalHealth());// safeHouse gittiğimizde canımızın yenilenme işlemi
        return true;
    }
}
