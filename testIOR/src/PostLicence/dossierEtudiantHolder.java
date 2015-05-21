package PostLicence;

/**
 * Holder class for : dossierEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class dossierEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal dossierEtudiant value
     */
    public PostLicence.dossierEtudiant value;

    /**
     * Default constructor
     */
    public dossierEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public dossierEtudiantHolder(PostLicence.dossierEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read dossierEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = dossierEtudiantHelper.read(istream);
    }

    /**
     * Write dossierEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        dossierEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the dossierEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return dossierEtudiantHelper.type();
    }

}
