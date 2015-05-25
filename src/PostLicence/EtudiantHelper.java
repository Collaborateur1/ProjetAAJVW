package PostLicence;

/** 
 * Helper class for : Etudiant
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantHelper
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
     * Insert Etudiant into an any
     * @param a an any
     * @param t Etudiant value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.Etudiant t)
    {
        a.insert_Streamable(new PostLicence.EtudiantHolder(t));
    }

    /**
     * Extract Etudiant from an any
     * @param a an any
     * @return the extracted Etudiant value
     */
    public static PostLicence.Etudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof PostLicence.EtudiantHolder)
                    return ((PostLicence.EtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            PostLicence.EtudiantHolder h = new PostLicence.EtudiantHolder(read(a.create_input_stream()));
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
     * Return the Etudiant TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[6];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "nomEtudiant";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "prenomEtudiant";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "ineEtudiant";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "nomUniv";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "adresse";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "formation";
                _members[5].type = PostLicence.FormationHelper.type();
                _tc = orb.create_struct_tc(id(),"Etudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Etudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/Etudiant:1.0";

    /**
     * Read Etudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed Etudiant value
     */
    public static PostLicence.Etudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        PostLicence.Etudiant new_one = new PostLicence.Etudiant();

        new_one.nomEtudiant = istream.read_string();
        new_one.prenomEtudiant = istream.read_string();
        new_one.ineEtudiant = istream.read_string();
        new_one.nomUniv = istream.read_string();
        new_one.adresse = istream.read_string();
        new_one.formation = PostLicence.FormationHelper.read(istream);

        return new_one;
    }

    /**
     * Write Etudiant into a marshalled stream
     * @param ostream the output stream
     * @param value Etudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.Etudiant value)
    {
        ostream.write_string(value.nomEtudiant);
        ostream.write_string(value.prenomEtudiant);
        ostream.write_string(value.ineEtudiant);
        ostream.write_string(value.nomUniv);
        ostream.write_string(value.adresse);
        PostLicence.FormationHelper.write(ostream,value.formation);
    }

}
