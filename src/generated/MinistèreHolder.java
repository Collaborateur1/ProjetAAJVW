package generated;

/**
 * Holder class for : Minist�re
 * 
 * @author OpenORB Compiler
 */
final public class Minist�reHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Minist�re value
     */
    public generated.Minist�re value;

    /**
     * Default constructor
     */
    public Minist�reHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public Minist�reHolder(generated.Minist�re initial)
    {
        value = initial;
    }

    /**
     * Read Minist�re from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = Minist�reHelper.read(istream);
    }

    /**
     * Write Minist�re into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        Minist�reHelper.write(ostream,value);
    }

    /**
     * Return the Minist�re TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return Minist�reHelper.type();
    }

}
