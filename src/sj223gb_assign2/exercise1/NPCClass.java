package sj223gb_assign2.exercise1;

/**
* Enum that sets primary attributes by linking the Attribute enum and a few rules for validity.
*
* @version 1.2 22 September 2021
* @author Sebastian Jonsson
*/
public enum NPCClass {
    Warrior(Attribute.Strength),
    Rogue(Attribute.Agility),
    Mage(Attribute.Intelligence),
    Cleric(Attribute.Wisdom);

    public Attribute primaryAttribute;

    private NPCClass(Attribute primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    /**
     * Validates classes to be an existing class.
     * 
     * @param className - Generic class.
     * @return - Boolean.
     */
    public static boolean isValid(NPCClass className) {
        
        for (NPCClass s : NPCClass.values()) {
    
            if (s.equals(className)) {
                return true;
            }
        }
        throw new IllegalArgumentException("The class: " + className + " is not a valid class");
    }
    
    /**
     * Used to aid in finding the primary attribute based on class.
     * 
     * @return - Primary attribute.
     */
    public Attribute getPrimaryAttribute() {
            return this.primaryAttribute;
    }

}
