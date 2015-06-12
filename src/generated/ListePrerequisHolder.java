package generated;

/**
 * Holder class for : ListePrerequis
 * 
 * @author OpenORB Compiler
 */
final public class ListePrerequisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListePrerequis value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public ListePrerequisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListePrerequisHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read ListePrerequis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListePrerequisHelper.read(istream);
    }

    /**
     * Write ListePrerequis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListePrerequisHelper.write(ostream,value);
    }

    /**
     * Return the ListePrerequis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListePrerequisHelper.type();
    }

}
