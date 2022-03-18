package sj223gb_assign2.exercise1;

/**
* Class that sets  and validates rules for Character.
*
* @version 1.2 22 September 2021
* @author Sebastian Jonsson
*/
public class Character {
    
    private String name = "";
    private NPCClass className;
    private int level;
    protected Attributes attributes;

    public Character(String charName, NPCClass className, int lvl, Attributes attr) {
        this.setName(charName);
        this.setClassName(className);
        this.setLevel(lvl);
        this.setAttributes(attr);
    }

    /**
     * Checks that the correct attribute is assigned to it's proper class.
     * 
     * @param className - The class that is being checked.
     * @return - The primary attribute of the specific class.
     */
    public int getPrimaryAttribute(NPCClass className) {
        Attribute attribute = className.getPrimaryAttribute();
        int primaryAttribute = 0;
        
        if (attribute == NPCClass.Warrior.getPrimaryAttribute()) {
            primaryAttribute = this.attributes.getStrength();
        }
        else if (attribute == NPCClass.Rogue.getPrimaryAttribute()) {
            primaryAttribute = this.attributes.getAgility();
        }
        else if (attribute == NPCClass.Mage.getPrimaryAttribute()) {
            primaryAttribute = this.attributes.getIntelligence();
        }
        else if (attribute == NPCClass.Cleric.getPrimaryAttribute()) {
            primaryAttribute = this.attributes.getWisdom();
        }

        return primaryAttribute;

    }

    public void setAttributes(Attributes attr) {
        this.attributes = attr;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        // Validates level.
        if (validateLevel(level)) {
            this.level = level;        
        }
    }

    public NPCClass getClassName() {
        return className;
    }

    public void setClassName(NPCClass className) {

        // Checks that the class is a valid class.
        if (NPCClass.isValid(className)) {
            this.className = className;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        // Validates name.
        if (validateName(name)) {
            this.name = name;
        }
    }

    /**
     * Validates that the name length is within acceptable boundaries.
     * 
     * @param name - The name of the character.
     * @return - Boolean.
     */
    private boolean validateName(String name) {

        if (name.length() >= Boundaries.MIN_CHAR_NAME && name.length() <= Boundaries.MAX_CHAR_NAME) {
            return true;
        }
        throw new IllegalArgumentException("Name " + name + " out of bounds.");
    }

    /**
     * Validates that the level is within acceptable boundaries.
     * 
     * @param level - The level of the character.
     * @return - Boolean.
     */
    private boolean validateLevel(int level) {

        if (level >= Boundaries.MIN_LEVEL && level <= Boundaries.MAX_LEVEL) {
            return true;        
        }
        throw new IllegalArgumentException("Level " + level + " is out of bounds.");
    }
}
