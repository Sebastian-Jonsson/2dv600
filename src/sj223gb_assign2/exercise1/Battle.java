package sj223gb_assign2.exercise1;

/**
* Class that sets rules and runs the simulations between different character parties for Battle.
*
* @version 1.2 22 September 2021
* @author Sebastian Jonsson
*/
public class Battle {

    Character[] party1;
    Character[] party2;
    
    public Battle(Character[] party1, Character[] party2) {
        this.party1 = party1;
        this.party2 = party2;
    }

    public static void printStatistics(Character[] party) {
        System.out.println("\nAverage party level: " + getAveragePartyLevel(party));
        numberSpells(party);
        numberAbilities(party);
    }

    public static Character[] resolve(Character[] party1, Character[] party2) {
        Character[] winner = compareParties(party1, party2);
        
        return winner;
    }

    public static Character[] singleCombat(Character char1, Character char2) {
        
        // Decided to put the single characters into lists in order to be able to reuse rulesets which shared similar if not .
        Character[] character1 = new Character[1];
        Character[] character2 = new Character[1];

        for (int i = 0; i < 1; i++) {
            character1[i] = char1;
            character2[i] = char2;
        }

        Character[] winner = compareParties(character1, character2);

        return winner;

    }

    public static void isTie() {
        System.out.println("You're all winners... It's a tie.");
    } 

    private static void numberSpells(Character[] party) {
        int mageCount = 0;
        int clericCount = 0;

        for (int i = 0; i < party.length; i++) {

            if (party[i].getClassName() == NPCClass.Mage) {
                Mage mage = (Mage)party[i];
                mageCount += mage.getKnownSpells().size();
            }
            else if (party[i].getClassName() == NPCClass.Cleric) {
                Cleric cleric = (Cleric)party[i];
                clericCount += cleric.getKnownSpells().size();
            }
        }

        System.out.println("Mage spells: " + mageCount + "\nCleric spells: " + clericCount + "\nTotal spells: " + (mageCount + clericCount) + "\n");
    }

    private static void numberAbilities(Character[] party) {
        int warriorCount = 0;
        int rogueCount = 0;

        for (int i = 0; i < party.length; i++) {

            if (party[i].getClassName() == NPCClass.Warrior) {
                Warrior warrior = (Warrior)party[i];
                warriorCount += warrior.getKnownAbilities().size();
            }
            else if (party[i].getClassName() == NPCClass.Rogue) {
                Rogue rogue = (Rogue)party[i];
                rogueCount += rogue.getKnownAbilities().size();
            }
        }

        System.out.println("Warrior abilities: " + warriorCount + "\nRogue abilities: " + rogueCount + "\nTotal abilities: " + (warriorCount + rogueCount) + "\n");
    }

    private static Character[] compareParties(Character[] party1, Character[] party2) {

        // First rule layer to check, size of parties.
        if (party1.length > party2.length) {
            return party1;
        }
        else if (party1.length < party2.length) {
            return party2;
        }
        else if (party1.length == party2.length) {
            return partyLevelRule(party1, party2);
        }
        else {
            throw new IllegalArgumentException("No valid parties.)");
        }
    }

    private static Character[] partyLevelRule(Character[] party1, Character[] party2) {
        int party1Values = getAveragePartyLevel(party1);
        int party2Values = getAveragePartyLevel(party2);

        // Second layer of rules to check, average party level.
        if (party1Values > party2Values) {
            return party1;
        }
        else if (party1Values < party2Values) {
            return party2;
        }
        else if (party1Values == party2Values) {
            return partyAttributesRule(party1, party2);
        }
        else {
            throw new IllegalArgumentException("No valid parties.)");
        }
    }

    private static int getAveragePartyLevel(Character[] party) {
        int partyValues = 0;

        // Adds all characters levels together and then returns the average from it.
        for (int i = 0; i < party.length; i++) {
            partyValues += party[i].getLevel();
        }

        return average(partyValues, party.length);
    }

    private static Character[] partyAttributesRule(Character[] party1, Character[] party2) {
        int party1Values = getPrimaryPartyAttributes(party1);
        int party2Values = getPrimaryPartyAttributes(party2);

        // Third rule layer, primary attributes comparison.
        if (party1Values > party2Values) {
            return party1;
        }
        else if (party1Values < party2Values) {
            return party2;
        }
        else if (party1Values == party2Values) {

            // In order to be able to reuse code it is considered single combat if both parties only contain 1 character.
            if (party1.length == 1 && party2.length == 1) {
                int party1Count = partyKnowledgeCount(party1);
                int party2Count = partyKnowledgeCount(party2);

                // Whoever knows more is the winner, else a tie.
                if (party1Count > party2Count) {
                    return party1;
                }
                if (party2Count > party1Count) {
                    return party2;
                }
                else {
                    // If an empty party is returned, it is a tie.
                    return new Character[0];
                }
            }
            else {
                // If an empty party is returned, it is a tie.
                return new Character[0];
            }
        }
        else {
            throw new IllegalArgumentException("No valid parties.)");
        }
    }

    private static int partyKnowledgeCount(Character[] party) {
        int partyCount = 0;
        
        // Counts any class spells or abilities and returns the value for comparison.
        for (int i = 0; i < party.length; i++) {
            
            if (party[i].getClassName() == NPCClass.Mage) {
                Mage mage = (Mage)party[i];
                partyCount += mage.getKnownSpells().size();
            }
            else if (party[i].getClassName() == NPCClass.Cleric) {
                Cleric cleric = (Cleric)party[i];
                partyCount += cleric.getKnownSpells().size();
            }
            else if (party[i].getClassName() == NPCClass.Warrior) {
                Warrior warrior = (Warrior)party[i];
                partyCount += warrior.getKnownAbilities().size();
            }
            else if (party[i].getClassName() == NPCClass.Rogue) {
                Rogue rogue = (Rogue)party[i];
                partyCount += rogue.getKnownAbilities().size();
            }
        }

        return partyCount;
    }

    private static int getPrimaryPartyAttributes(Character[] party) {
        int partyValues = 0;
        
        // Gets the total of primary attributes from any class.
        for (int i = 0; i < party.length; i++) {
            partyValues += party[i].getPrimaryAttribute(party[i].getClassName());
        }

        return partyValues;
    }

    private static int average(int values, int partySize) {
        return values / partySize;
    }

}
