public class NormalLoc extends Location{

    public NormalLoc(Player player,String name) {
        super(player,name);
    }

    @Override
    public boolean onLocation() {// normalLoc ölme ihtimalimiz olmadığı için return true yapıyoruz
        return true;
    }
}
