public class BendingPractice {
    public static void main(String[] args) {

        // WaterBenders - FF7
        WaterBender Aerith = new WaterBender("Aerith", 20, 100, true);
        WaterBender Cloud = new WaterBender("Cloud", 30, 100, false);
        WaterBender Vincent = new WaterBender("Vincent", 20, 100, false);

        // FireBenders - FF16
        FireBender Clive = new FireBender("Clive", 30, 100);
        FireBender Cid = new FireBender("Cid", 25, 100);
        FireBender Torgal = new FireBender("Torgal", 5, 30);

        //EarthBenders - FF Enemies
        EarthBender Sephiroth = new EarthBender("Sephiroth", 60, 100, false);
        EarthBender Benedikta = new EarthBender("Benedikta", 35, 35, false);

        Bender[] enemies = new Bender[2];
        enemies[0] = Sephiroth;
        enemies[1] = Benedikta;

        Bender[] allMembers = new Bender[8];
        allMembers[0] = Aerith;
        allMembers[1] = Cloud;
        allMembers[2] = Vincent;
        allMembers[3] = Clive;
        allMembers[4] = Cid;
        allMembers[5] = Torgal;
        allMembers[6] = Sephiroth;
        allMembers[7] = Benedikta;


        System.out.println("======================STATS======================");
        System.out.println("Name: " + Aerith.getName() + ",      Health: " + Aerith.getHealth() + ",    Strength Level: " + Aerith.getStrengthLevel());
        System.out.println("Name: " + Cloud.getName() + ",       Health: " + Cloud.getHealth() + ",    Strength Level: " + Cloud.getStrengthLevel());
        System.out.println("Name: " + Vincent.getName() + ",     Health: " + Vincent.getHealth() + ",    Strength Level: " + Vincent.getStrengthLevel());
        System.out.println();
        System.out.println("Name: " + Clive.getName() + ",       Health: " + Clive.getHealth() + ",    Strength Level: " + Clive.getStrengthLevel());
        System.out.println("Name: " + Cid.getName() + ",         Health: " + Cid.getHealth() + ",    Strength Level: " + Cid.getStrengthLevel());
        System.out.println("Name: " + Torgal.getName() + ",      Health: " + Torgal.getHealth() + ",    Strength Level: " + Torgal.getStrengthLevel());
        System.out.println();
        System.out.println("Name: " + Sephiroth.getName() + ",   Health: " + Sephiroth.getHealth() + ",    Strength Level: " + Sephiroth.getStrengthLevel());
        System.out.println("Name: " + Benedikta.getName() + ",   Health: " + Benedikta.getHealth() + ",    Strength Level: " + Benedikta.getStrengthLevel());
        System.out.println("\n=================================================\n");

        //Potion = 20HP
        //Hi Potion = 40HP
        //Elixer = 60HP

        System.out.println("\n....Battle Starts!....\n");
        //Aerith only attack Benedikta, and will continually revive party members
        //Torgal only attacks Benedikta
        //Everyone else attacks Sephiroth
        //Sephiroth attacks Cid and Cloud first
        //Benedikta attacks Clive and Torgal only
        //Benedikta recovers with Potion and Hi Potion only after each attack

        Aerith.attack(Benedikta);
        Torgal.attack(Benedikta);

        Benedikta.attack(Aerith);
        Benedikta.recover(20);

        Clive.attack(Sephiroth);
        Cid.attack(Sephiroth);
        Sephiroth.attack(Cloud);
        Sephiroth.attack(Vincent);
        Torgal.attack(Benedikta);

        Benedikta.attack(Aerith);
        Benedikta.recover(20);

        Aerith.heal(Cloud);
        Aerith.heal(Vincent);
        Aerith.heal(Aerith);

        Benedikta.attack(Torgal);
        Benedikta.recover(20);
        Benedikta.attack(Aerith);
        Benedikta.recover(20);

        //Clive deals FlameCircle
        Clive.flameCircle(enemies);

        Aerith.heal(Cloud);

        //Aerith and Torgal are dead
        Sephiroth.attack(Aerith);
        Benedikta.attack(Torgal);

        //Sephiroth uses Elixer
        Sephiroth.recover(60);

        //Cid and Benedikta fight
        Cid.attack(Benedikta);
        Benedikta.attack(Cid);
        Benedikta.recover(20);
        Cid.attack(Benedikta);
        Benedikta.attack(Cid);
        Benedikta.recover(20);

        //Sephiroth kills Cid
        Sephiroth.attack(Cid);

        //Cloud uses Hi Potion, Vincent uses Hi Potion
        Cloud.recover(30);
        Vincent.recover(30);

        //Cloud attacks Sephiroth
        Cloud.attack(Sephiroth);

        //Accidentally Benedikta attacks Sephiroth
        Benedikta.attack(Sephiroth);


        //Sephiroth deals heavy attack on Cloud, Vincent and Clive
        Sephiroth.attack(Cloud);
        Sephiroth.attack(Vincent);
        Sephiroth.attack(Clive);

        //Benedikta Kills Vincent
        Benedikta.attack(Vincent);
        Benedikta.recover(20);

        //Clive deals FlameCircle
        Clive.flameCircle(enemies);

        //Sephiroth uses Elixer
        Sephiroth.recover(60);

        Cloud.recover(30);

        //Benedikta uses EarthArmor and continually attacks Cloud
        Benedikta.buildArmor();
        Benedikta.attack(Cloud);

        Cloud.recover(30);
        Cloud.recover(30);

        Benedikta.attack(Cloud);

        //Clive summons Ifrit, deals heavy damage and kills off Benedikta
        FireBender Ifrit = new FireBender("Ifrit", 70, 100);
        System.out.println("\nClive summons Ifrit................~~~~~~~");
        Ifrit.attack(Benedikta);

        //Sephiroth and Benedikta concentrate on Ifrit
        Benedikta.attack(Ifrit);
        Benedikta.recover(20);
        Sephiroth.attack(Ifrit);

        System.out.println("\nIfrit uses FlameCircle at low health... all members get hurt!!");
        Ifrit.flameCircle(allMembers);

        //Benedikta finishes Ifrit
        Benedikta.attack(Ifrit);
        Benedikta.recover(30);

        //Cloud and Clive attacks Benedikta
        Cloud.attack(Benedikta);


        //Final Battle Ensues
        System.out.println("\n FINAL BATTLE \n");

        //Sephiroth uses Elixer
        Sephiroth.recover(60);

        //Cloud and Clive are out of potions!
        //Cloud Summons Shiva for healing
        WaterBender Shiva = new WaterBender("Shiva", 60, 100, true);
        Shiva.heal(Cloud);
        Shiva.heal(Cloud);

        //Sephiroth Kills Clive
        Sephiroth.buildArmor();
        Sephiroth.attack(Clive);

        //Cloud attacks Sephiroth
        Cloud.attack(Sephiroth);

        //Sephiroth uses elixer
        Sephiroth.recover(60);
        Sephiroth.attack(Cloud);
        Sephiroth.buildArmor();

        Shiva.heal(Cloud);
        Sephiroth.recover(60);
        Cloud.attack(Sephiroth);

        Sephiroth.recover(60);

        //Sephiroth uses Healing Charm 70HP!
        Sephiroth.recover(70);

        //Cloud obtains Hi Potion!
        Cloud.recover(40);
        Cloud.attack(Sephiroth);

        //Sephiroth uses Healing Charm 70HP
        Sephiroth.recover(70);

        //Shiva heals Aerith
        Shiva.heal(Aerith);

        Aerith.attack(Sephiroth);
        Sephiroth.attack(Aerith);

        Sephiroth.recover(80);

        Cloud.attack(Sephiroth);

        Sephiroth.recover(80);
        Cloud.attack(Sephiroth);

        Sephiroth.attack(Cloud);




        System.out.println("\n\n\n======================SCORE======================");
        System.out.println("\nWATERPOINTS:");
        System.out.println("Waterpoints from Aerith: " + WaterBender.getWaterPoints());
        System.out.println("Waterpoints from Cloud: " + WaterBender.getWaterPoints());
        System.out.println("Waterpoints from Vincent: " + WaterBender.getWaterPoints());

        System.out.println("\nFIREPOINTS:");
        System.out.println("Firepoints from Clive: " + Clive.getFirePoints());
        System.out.println("Firepoints from Cid: " + Cid.getFirePoints());
        System.out.println("Firepoints from Torgal: " + Torgal.getFirePoints());

        System.out.println("\nEARTHPOINTS:");
        System.out.println("Earthpoints from Sephiroth: " + Sephiroth.getEarthPoints());
        System.out.println("Earthpoints from Benedikta: " + Benedikta.getEarthPoints());
        System.out.println("\n=================================================\n");

        System.out.println("\n======================STATS======================");
        System.out.println("Name: " + Aerith.getName() + ",      Health: " + Aerith.getHealth() + ",    Strength Level: " + Aerith.getStrengthLevel());
        System.out.println("Name: " + Cloud.getName() + ",       Health: " + Cloud.getHealth() + ",    Strength Level: " + Cloud.getStrengthLevel());
        System.out.println("Name: " + Vincent.getName() + ",     Health: " + Vincent.getHealth() + ",    Strength Level: " + Vincent.getStrengthLevel());
        System.out.println();
        System.out.println("Name: " + Clive.getName() + ",       Health: " + Clive.getHealth() + ",    Strength Level: " + Clive.getStrengthLevel());
        System.out.println("Name: " + Cid.getName() + ",         Health: " + Cid.getHealth() + ",    Strength Level: " + Cid.getStrengthLevel());
        System.out.println("Name: " + Torgal.getName() + ",      Health: " + Torgal.getHealth() + ",    Strength Level: " + Torgal.getStrengthLevel());
        System.out.println();
        System.out.println("Name: " + Sephiroth.getName() + ",   Health: " + Sephiroth.getHealth() + ",    Strength Level: " + Sephiroth.getStrengthLevel());
        System.out.println("Name: " + Benedikta.getName() + ",   Health: " + Benedikta.getHealth() + ",    Strength Level: " + Benedikta.getStrengthLevel());
        System.out.println("\n=================================================\n");




        /**
        WaterBender katara = new WaterBender("Katara", 80, 100, true);
        WaterBender mermaidMan = new WaterBender("Mermaid Man");

        FireBender ace = new FireBender("Ace", 120, 20);
        FireBender mushu = new FireBender("Mushu");

        EarthBender whitebeard = new EarthBender("Whitebeard", 100, 80, true);

        System.out.println(katara.toString());
        System.out.println(mushu.toString());
        System.out.println(whitebeard.toString());

        System.out.println();

        ace.attack(mermaidMan);
        whitebeard.attack(mermaidMan);
        katara.heal(mermaidMan);
        whitebeard.buildArmor();
        mermaidMan.attack(mushu);

        Bender[] b = new Bender[2];
        b[0] = whitebeard;
        b[1] = katara;
        mushu.flameCircle(b);

        katara.recover(5);

        System.out.println(katara.toString());
        System.out.println(mushu.toString());
        System.out.println(whitebeard.toString());

        System.out.println();

        System.out.println("Earth Points from whitebeard: " + whitebeard.getEarthPoints());

        System.out.println("Water Points from Katara: " + katara.getWaterPoints());
        System.out.println("Water Points from MermaidMan: " + mermaidMan.getWaterPoints());

        System.out.println("Fire Points from Ace: " + ace.getFirePoints());
        System.out.println("Fire Points from Mushu: " + mushu.getFirePoints());
        **/

    }
}
