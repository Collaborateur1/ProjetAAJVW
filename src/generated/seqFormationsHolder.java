package generated;

/**
 * Holder class for : seqFormations
 * 
 * @author OpenORB Compiler
 */
final public class seqFormationsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal seqFormations value
     */
    public generated.Formation[] value;

    /**
     * Default constructor
     */
    public seqFormationsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public seqFormationsHolder(generated.Formation[] initial)
    {
        value = initial;
    }

    /**
     * Read seqFormations from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = seqFormationsHelper.read(istream);
    }

    /**
     * Write seqFormations into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        seqFormationsHelper.write(ostream,value);
    }

    /**
     * Return the seqFormations TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return seqFormationsHelper.type();
    }

}
