public  class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player,"Magaza");
    }
    @Override
    public boolean onLocation() {// normalLoc ölme ihtimalimiz olmadığı için return true yapıyoruz
        System.out.println("---Magazaya hosgeldiniz---");
        boolean showMenu=true;
       while (showMenu){ // Çıkış İşlemini yapmak için While Döndüsüne Aldık
           System.out.println("1-Silahlar");
           System.out.println("2-Zirhlar");
           System.out.println("3-Cikis yap");
           System.out.println("--Seciminiz--");
           int selecCase=Location.input.nextInt();
           while (selecCase<1 || selecCase>3 ){
               System.out.println("Gecersiz bir deger girdiniz. Tekrar deneyiniz");
               selecCase=input.nextInt();
           }
           switch (selecCase){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("bir daha bekleriz");
                   showMenu=false;// Anahtar Görevini Yaptık
                   break;
           }
       }
        return true;
    }
        public void printWeapon(){// Ekrana Yazdırma işlemlerini burada yaptık
            System.out.println("---Silahlar---");
            for(Weapon w:Weapon.weapon()){
                System.out.println(w.getId()+" - "+w.getName()+" |-> Para: "+w.getPrice()+" Hasar: "+w.getDamage()+" <-|");
            }
            System.out.println("0-Cikis Yap");
        }

        public void buyWeapon(){// Silah seçim ve satın alma işlemlerini burada yaptık

            System.out.print("Bir Silah Seciniz: ");
            int selectWeaponID=input.nextInt();
            while (selectWeaponID<0 || selectWeaponID>Weapon.weapon().length){
                System.out.println("Gecersiz bir deger tekrar giriniz:");
                selectWeaponID=input.nextInt();
            }
           if (selectWeaponID !=0){
               Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponID);
               if (selectedWeapon!=null){
                   if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                       System.out.println("Yeterli Paraniz bulunmamaktadir.");
                   }else{
                       // Satın alma işlemlerinin gerçekleştiği alan
                       System.out.println(selectedWeapon.getName()+ " Silahini satin aldiniz");
                       int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                       this.getPlayer().setMoney(balance);
                       System.out.println("Kalan Paraniz: "+this.getPlayer().getMoney());
                       System.out.println("Onceki silahiniz: "+this.getPlayer().getInventory().getWeapon().getName());
                       this.getPlayer().getInventory().setWeapon(selectedWeapon);// silahımızı değiştirdik
                       System.out.println("Yeni silahiniz: "+this.getPlayer().getInventory().getWeapon().getName());

                   }
               }
           }

        }
        public void printArmor(){
            System.out.println("---Zirhlar---");
            for (Armor a: Armor.armors()) {
                System.out.println(a.getId()+"-"+a.getName()+" |-> Para "+a.getPrice()+", Zirh "+a.getBlock()+" <-|");

            }
            System.out.println("0-Cikis Yap");


        }
        public void buyArmor(){
            System.out.println("-------------------------------------------");
            System.out.print("Bir Zirh Seciniz: ");
            int selectArmorID=input.nextInt();
            while (selectArmorID<0 || selectArmorID>Armor.armors().length){
                System.out.println("Gecersiz bir deger tekrar giriniz:");
                selectArmorID=input.nextInt();
            }
           if (selectArmorID != 0){
               Armor selectedArmor=Armor.getArmorObjById(selectArmorID);
               if (selectedArmor!=null){
                   if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                       System.out.println("Yeterli Paraniz Bulunmamaktadir.");
                   } else {
                       // Satın alma işlemlerinin gerçekleştiği alan
                       System.out.println(selectedArmor.getName()+" Zirhini satin aldiniz.");
                       int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                       this.getPlayer().setMoney(balance);
                       System.out.println("Kalan Paraniz: "+this.getPlayer().getMoney());
                       System.out.println("Onceki Zirhiniz: "+this.getPlayer().getInventory().getArmor().getName());
                       this.getPlayer().getInventory().setArmor(selectedArmor);// Zırhımızı değiştirdik
                       System.out.println("Yeni Zirhiniz: "+this.getPlayer().getInventory().getArmor().getName());
                       System.out.println("-------------------------------------------");
                   }
               }
           }

        }


}
