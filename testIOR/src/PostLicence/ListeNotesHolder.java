package PostLicence;

/**
 * Holder class for : ListeNotes
 * 
 * @author OpenORB Compiler
 */
final public class ListeNotesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeNotes value
     */
    public PostLicence.Resultat[] value;

    /**
     * Default constructor
     */
    public ListeNotesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeNotesHolder(PostLicence.Resultat[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeNotes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeNotesHelper.read(istream);
    }

    /**
     * Write ListeNotes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeNotesHelper.write(ostream,value);
    }

    /**
     * Return the ListeNotes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeNotesHelper.type();
    }

}
