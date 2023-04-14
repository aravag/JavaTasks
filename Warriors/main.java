package Warriors;
public class main {
    public static void main(String[] args) {
        Team<Archer> archers = new Team<>();
        Team<Paladin> paladins = new Team<>();
        archers.addPerson(new Archer("Robin", 100, new Bow(20), null))
            .addPerson(new Archer("Bill", 100, new Bow(15), null));
        paladins.addPerson(new Paladin("Tom", 150, new Sword(), new MetalShield()))
            .addPerson(new Paladin("Septimus", 150, new Sword(), new PlatinumShield()));
        Archer attacker = archers.getTeam().get(0);
        Paladin defender = paladins.getTeam().get(0);            
        Battle fight = new Battle(attacker, defender);
        fight.run();
}
}
