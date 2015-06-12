package generated;

/**
 * Holder class for : seqGDP
 * 
 * @author OpenORB Compiler
 */
final public class seqGDPHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal seqGDP value
     */
    public generated.GestionDesProfils[] value;

    /**
     * Default constructor
     */
    public seqGDPHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public seqGDPHolder(generated.GestionDesProfils[] initial)
    {
        value = initial;
    }

    /**
     * Read seqGDP from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = seqGDPHelper.read(istream);
    }

    /**
     * Write seqGDP into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        seqGDPHelper.write(ostream,value);
    }

    /**
     * Return the seqGDP TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return seqGDPHelper.type();
    }

}
