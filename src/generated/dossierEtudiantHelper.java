package generated;

/** 
 * Helper class for : dossierEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class dossierEtudiantHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert dossierEtudiant into an any
     * @param a an any
     * @param t dossierEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, generated.dossierEtudiant t)
    {
        a.insert_Streamable(new generated.dossierEtudiantHolder(t));
    }

    /**
     * Extract dossierEtudiant from an any
     * @param a an any
     * @return the extracted dossierEtudiant value
     */
    public static generated.dossierEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof generated.dossierEtudiantHolder)
                    return ((generated.dossierEtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            generated.dossierEtudiantHolder h = new generated.dossierEtudiantHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the dossierEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "etu";
                _members[0].type = generated.EtudiantHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "listnotes";
                _members[1].type = generated.ListeNotesHelper.type();
                _tc = orb.create_struct_tc(id(),"dossierEtudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the dossierEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/dossierEtudiant:1.0";

    /**
     * Read dossierEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed dossierEtudiant value
     */
    public static generated.dossierEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        generated.dossierEtudiant new_one = new generated.dossierEtudiant();

        new_one.etu = generated.EtudiantHelper.read(istream);
        new_one.listnotes = generated.ListeNotesHelper.read(istream);

        return new_one;
    }

    /**
     * Write dossierEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value dossierEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.dossierEtudiant value)
    {
        generated.EtudiantHelper.write(ostream,value.etu);
        generated.ListeNotesHelper.write(ostream,value.listnotes);
    }

}
