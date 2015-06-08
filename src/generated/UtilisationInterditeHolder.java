package generated;

/**
 * Holder class for : UtilisationInterdite
 * 
 * @author OpenORB Compiler
 */
final public class UtilisationInterditeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UtilisationInterdite value
     */
    public generated.UtilisationInterdite value;

    /**
     * Default constructor
     */
    public UtilisationInterditeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UtilisationInterditeHolder(generated.UtilisationInterdite initial)
    {
        value = initial;
    }

    /**
     * Read UtilisationInterdite from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UtilisationInterditeHelper.read(istream);
    }

    /**
     * Write UtilisationInterdite into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UtilisationInterditeHelper.write(ostream,value);
    }

    /**
     * Return the UtilisationInterdite TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UtilisationInterditeHelper.type();
    }

}
