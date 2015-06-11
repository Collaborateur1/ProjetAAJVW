package generated;

/**
 * Holder class for : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
final public class GestionDesVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionDesVoeux value
     */
    public generated.GestionDesVoeux value;

    /**
     * Default constructor
     */
    public GestionDesVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionDesVoeuxHolder(generated.GestionDesVoeux initial)
    {
        value = initial;
    }

    /**
     * Read GestionDesVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionDesVoeuxHelper.read(istream);
    }

    /**
     * Write GestionDesVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionDesVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the GestionDesVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionDesVoeuxHelper.type();
    }

}
