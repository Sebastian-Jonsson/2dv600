package sj223gb_assign2.exercise1;

/*
* Date: 2020-09-22.
* File Name: App.Java
* Author: Sebastian Jonsson
*
* Copyright (c): Here comes the copyright statement if any ...
*/

/**
 * Class that initiates automated character creation for group-battles and manual/hard-coded characters for single-battles.
 * Further starts battles between different parties of characters.
 */
public class App {

    // Lists of random names, spells, and abilities. 
    // Names can be the same, since there can be more people with the same name.
    private static final String[] nameList = {"Bob", "Ross", "Leroy", "Jenkins", "John", "Bearded Barry", "Hairy Dorothy", "Grawlmasher Smochum", "Viktor the Tall", "Stefan the Glorious", "Simon the Bold", "Sebastian the Hairless", "Rick Astley", "Gandalf", "Gimli", "Harry Potter", "The One Ring"};
    private static final Ability[][] rogueAbilities = {
        {new Ability("Barrel Roll", Proficiency.Acrobatics)},
        {new Ability("Quiet Sprint", Proficiency.Stealth)},
        {new Ability("Shadowmeld", Proficiency.Stealth)},
        {new Ability("Windwalk", Proficiency.Acrobatics)},
        {new Ability("High Jump", Proficiency.Acrobatics)}
    };
    private static final Ability[][] warriorAbilities = {
        {new Ability("Far Jump", Proficiency.Athletics)},
        {new Ability("Find Food", Proficiency.Survival)},
        {new Ability("Find the Path", Proficiency.Survival)},
        {new Ability("High Jump", Proficiency.Athletics)},
        {new Ability("Be Macho", Proficiency.Athletics)},
    };
    private static final Spell[][] mageSpells = {
        {new Spell("Fireball", SchoolOfMagic.Evocation)}, 
        {new Spell("Mending", SchoolOfMagic.Alteration)},
        {new Spell("Stone Shape", SchoolOfMagic.Alteration)},
        {new Spell("Eldritch Blast", SchoolOfMagic.Evocation)},
        {new Spell("Meteor Swarm", SchoolOfMagic.Evocation)}
    };
    private static final Spell[][] clericSpells = {
        {new Spell("Healing Word", SchoolOfMagic.Restoration)},
        {new Spell("Scrying", SchoolOfMagic.Divination)},
        {new Spell("Tongues", SchoolOfMagic.Divination)},
        {new Spell("Mass Cure Wounds", SchoolOfMagic.Restoration)},
        {new Spell("Revive", SchoolOfMagic.Restoration)}
    };
    
    public static void main(String[] args) {
        initiateRPGSequence();
    }

    private static void initiateRPGSequence() {
        initializeSingleCombat();
        System.out.println("\n-----------------------");
        initializeGroupCombat();
    }

    private static void initializeGroupCombat() {
        Character[] party1 = createParty();
        Character[] party2 = createParty();
        
        Character[] battleWinner = Battle.resolve(party1, party2);

        System.out.println("\nGroup combat statistics: ");
        Battle.printStatistics(party1);
        Battle.printStatistics(party2);

        // If an empty party is returned it means both teams got eliminated.
        if (battleWinner.length > 1) {
            System.out.println("Winning group members: ");
            for (int i = 0; i < battleWinner.length; i++) {
                System.out.println(battleWinner[i].getName());
            }
        }
        else {
            Battle.isTie();
        }
    }

    private static void initializeSingleCombat() {

        // Manual creation of characters.
        Cleric bobRoss = new Cleric("Bob Ross", NPCClass.Cleric, randomizer(Boundaries.MIN_LEVEL, Boundaries.MAX_LEVEL), randomAttributes(Boundaries.MIN_ATTRIBUTE, Boundaries.MAX_ATTRIBUTE));
        Cleric leroyJenkins = new Cleric("Leroy Jenkins", NPCClass.Cleric, randomizer(Boundaries.MIN_LEVEL, Boundaries.MAX_LEVEL), randomAttributes(Boundaries.MIN_ATTRIBUTE, Boundaries.MAX_ATTRIBUTE));

        int bobNumbers = randomizer(Boundaries.MIN_AMOUNT_SPELLAB, Boundaries.MAX_AMOUNT_SPELLAB);
        int leroyNumbers = randomizer(Boundaries.MIN_AMOUNT_SPELLAB, Boundaries.MAX_AMOUNT_SPELLAB);

        // Learns a set amount of spells.
        for (int i = 0; i < bobNumbers; i++) {
            bobRoss.learnSpell(clericSpells[i][0]);
        }

        for (int i = 0; i < leroyNumbers; i++) {
            leroyJenkins.learnSpell(clericSpells[i][0]);
        }
        
        // They are converted to character arrays so that code can be reused.
        Character[] singleCombat = Battle.singleCombat(bobRoss, leroyJenkins);

        System.out.println("\nSingle combat winner statistics: ");
        Battle.printStatistics(singleCombat);

        // If nobody is left, then there is a tie.
        if (singleCombat.length == 1) {
            
            for (int i = 0; i < singleCombat.length; i++) {
                System.out.println("Winner: " + singleCombat[i].getName());
            }
        }
        else {
            Battle.isTie();
        }
    }

    private static Character[] createParty() {
        Character[] party = createCharacters(Boundaries.MIN_CHARACTERS, Boundaries.MAX_CHARACTERS);

        return party;
    }

    private static Character[] createCharacters(int min, int max) {
        int amount = randomizer(min, max);
        Character[] party = new Character[amount];

        // Sets the different character requirements for a randomized amount of characters in a party.
        for (int i = 0; i < amount; i++) {
            int level = randomizer(min, max);
            NPCClass npcClass = randomClass();
            Attributes attributes = randomAttributes(Boundaries.MIN_ATTRIBUTE, Boundaries.MAX_ATTRIBUTE);
            String name = nameList[randomizer(0, nameList.length - 1)];
            Character newNPC = getCompleteCharacter(name, npcClass, level, attributes);

            party[i] = newNPC;
        }

        return party;
    }

    private static Character getCompleteCharacter(String name, NPCClass npcClass, int level, Attributes attributes) {
        try {
            int number = randomizer(Boundaries.MIN_AMOUNT_SPELLAB, Boundaries.MAX_AMOUNT_SPELLAB);

            // Makes certain each class gets to learn a random amount of spells or abilities after knowing their class.
            if (npcClass == NPCClass.Cleric) {
                Cleric cleric = new Cleric(name, npcClass, level, attributes);
    
                for (int i = 0; i < number; i++) {
                    cleric.learnSpell(clericSpells[i][0]);
                }

                return cleric;
            }
            if (npcClass == NPCClass.Mage) {
                Mage mage = new Mage(name, npcClass, level, attributes);

                for (int i = 0; i < number; i++) {
                    mage.learnSpell(mageSpells[i][0]);
                }

                return mage;
            }
            if (npcClass == NPCClass.Warrior) {
                Warrior warrior = new Warrior(name, npcClass, level, attributes);

                for (int i = 0; i < number; i++) {
                    warrior.learnAbility(warriorAbilities[i][0]);
                }

                return warrior;
            }
            if (npcClass == NPCClass.Rogue) {
                Rogue rogue = new Rogue(name, npcClass, level, attributes);

                for (int i = 0; i < number; i++) {
                    rogue.learnAbility(rogueAbilities[i][0]);
                }

                return rogue;
            }
        } 
        catch (IllegalArgumentException e) {
            
        }

        return null;
    }

    private static NPCClass randomClass() {
        int number = randomizer(0, 3);
        // Randomizes a class from the enum.
        NPCClass npcClass = NPCClass.values()[number];

        return npcClass;
    }

    private static Attributes randomAttributes(int min, int max) {
        int strength = randomizer(min, max);
        int agility = randomizer(min, max);
        int intelligence = randomizer(min, max);
        int wisdom = randomizer(min, max);

        return new Attributes(strength, agility, intelligence, wisdom);
    }

    private static int randomizer(int minValue, int maxValue) {
        return minValue + (int) (Math.random() * (maxValue + 1 - minValue));
    }
    
}