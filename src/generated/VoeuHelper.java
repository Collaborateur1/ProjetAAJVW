package generated;

/** 
 * Helper class for : Voeu
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuHelper
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
     * Insert Voeu into an any
     * @param a an any
     * @param t Voeu value
     */
    public static void insert(org.omg.CORBA.Any a, generated.Voeu t)
    {
        a.insert_Streamable(new generated.VoeuHolder(t));
    }

    /**
     * Extract Voeu from an any
     * @param a an any
     * @return the extracted Voeu value
     */
    public static generated.Voeu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof generated.VoeuHolder)
                    return ((generated.VoeuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            generated.VoeuHolder h = new generated.VoeuHolder(read(a.create_input_stream()));
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
     * Return the Voeu TypeCode
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
                _members[0].name = "formationVoeu";
                _members[0].type = generated.FormationHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "etatVoeu";
                _members[1].type = generated.etatvoeuxHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "dcsEtudiant";
                _members[2].type = generated.decisionHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "numeroVoeu";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"Voeu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Voeu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/Voeu:1.0";

    /**
     * Read Voeu from a marshalled stream
     * @param istream the input stream
     * @return the readed Voeu value
     */
    public static generated.Voeu read(org.omg.CORBA.portable.InputStream istream)
    {
        generated.Voeu new_one = new generated.Voeu();

        new_one.formationVoeu = generated.FormationHelper.read(istream);
        new_one.etatVoeu = generated.etatvoeuxHelper.read(istream);
        new_one.dcsEtudiant = generated.decisionHelper.read(istream);
        new_one.numeroVoeu = istream.read_short();

        return new_one;
    }

    /**
     * Write Voeu into a marshalled stream
     * @param ostream the output stream
     * @param value Voeu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.Voeu value)
    {
        generated.FormationHelper.write(ostream,value.formationVoeu);
        generated.etatvoeuxHelper.write(ostream,value.etatVoeu);
        generated.decisionHelper.write(ostream,value.dcsEtudiant);
        ostream.write_short(value.numeroVoeu);
    }

}
