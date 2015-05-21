package PostLicence;

/** 
 * Helper class for : Resultat
 *  
 * @author OpenORB Compiler
 */ 
public class ResultatHelper
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
     * Insert Resultat into an any
     * @param a an any
     * @param t Resultat value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.Resultat t)
    {
        a.insert_Streamable(new PostLicence.ResultatHolder(t));
    }

    /**
     * Extract Resultat from an any
     * @param a an any
     * @return the extracted Resultat value
     */
    public static PostLicence.Resultat extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof PostLicence.ResultatHolder)
                    return ((PostLicence.ResultatHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            PostLicence.ResultatHolder h = new PostLicence.ResultatHolder(read(a.create_input_stream()));
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
     * Return the Resultat TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "semestre";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "moyenne";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_float);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "codeObtention";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "classement";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"Resultat",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Resultat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/Resultat:1.0";

    /**
     * Read Resultat from a marshalled stream
     * @param istream the input stream
     * @return the readed Resultat value
     */
    public static PostLicence.Resultat read(org.omg.CORBA.portable.InputStream istream)
    {
        PostLicence.Resultat new_one = new PostLicence.Resultat();

        new_one.semestre = istream.read_short();
        new_one.moyenne = istream.read_float();
        new_one.codeObtention = istream.read_short();
        new_one.classement = istream.read_short();

        return new_one;
    }

    /**
     * Write Resultat into a marshalled stream
     * @param ostream the output stream
     * @param value Resultat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.Resultat value)
    {
        ostream.write_short(value.semestre);
        ostream.write_float(value.moyenne);
        ostream.write_short(value.codeObtention);
        ostream.write_short(value.classement);
    }

}
