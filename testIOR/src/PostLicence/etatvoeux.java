package PostLicence;

/**
 * Enum definition : etatvoeux
 *
 * @author OpenORB Compiler
*/
public final class etatvoeux implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member soumis value 
     */
    public static final int _soumis = 0;

    /**
     * Enum member soumis
     */
    public static final etatvoeux soumis = new etatvoeux(_soumis);

    /**
     * Enum member nonValide value 
     */
    public static final int _nonValide = 1;

    /**
     * Enum member nonValide
     */
    public static final etatvoeux nonValide = new etatvoeux(_nonValide);

    /**
     * Enum member valide value 
     */
    public static final int _valide = 2;

    /**
     * Enum member valide
     */
    public static final etatvoeux valide = new etatvoeux(_valide);

    /**
     * Enum member accepter value 
     */
    public static final int _accepter = 3;

    /**
     * Enum member accepter
     */
    public static final etatvoeux accepter = new etatvoeux(_accepter);

    /**
     * Enum member refuser value 
     */
    public static final int _refuser = 4;

    /**
     * Enum member refuser
     */
    public static final etatvoeux refuser = new etatvoeux(_refuser);

    /**
     * Enum member listeDattente value 
     */
    public static final int _listeDattente = 5;

    /**
     * Enum member listeDattente
     */
    public static final etatvoeux listeDattente = new etatvoeux(_listeDattente);

    /**
     * Internal member value 
     */
    private final int _etatvoeux_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private etatvoeux( final int value )
    {
        _etatvoeux_value = value;
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
        return _etatvoeux_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static etatvoeux from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return soumis;
        case 1 :
            return nonValide;
        case 2 :
            return valide;
        case 3 :
            return accepter;
        case 4 :
            return refuser;
        case 5 :
            return listeDattente;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_etatvoeux_value)
        {
        case 0 :
            return "soumis";
        case 1 :
            return "nonValide";
        case 2 :
            return "valide";
        case 3 :
            return "accepter";
        case 4 :
            return "refuser";
        case 5 :
            return "listeDattente";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
