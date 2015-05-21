package PostLicence;

/**
 * Enum definition : decision
 *
 * @author OpenORB Compiler
*/
public final class decision implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member OUIdefinitif value 
     */
    public static final int _OUIdefinitif = 0;

    /**
     * Enum member OUIdefinitif
     */
    public static final decision OUIdefinitif = new decision(_OUIdefinitif);

    /**
     * Enum member OUImais value 
     */
    public static final int _OUImais = 1;

    /**
     * Enum member OUImais
     */
    public static final decision OUImais = new decision(_OUImais);

    /**
     * Enum member NONdefinitif value 
     */
    public static final int _NONdefinitif = 2;

    /**
     * Enum member NONdefinitif
     */
    public static final decision NONdefinitif = new decision(_NONdefinitif);

    /**
     * Enum member NONmais value 
     */
    public static final int _NONmais = 3;

    /**
     * Enum member NONmais
     */
    public static final decision NONmais = new decision(_NONmais);

    /**
     * Internal member value 
     */
    private final int _decision_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private decision( final int value )
    {
        _decision_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _decision_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static decision from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return OUIdefinitif;
        case 1 :
            return OUImais;
        case 2 :
            return NONdefinitif;
        case 3 :
            return NONmais;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_decision_value)
        {
        case 0 :
            return "OUIdefinitif";
        case 1 :
            return "OUImais";
        case 2 :
            return "NONdefinitif";
        case 3 :
            return "NONmais";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
