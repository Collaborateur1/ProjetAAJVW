package generated;

/** 
 * Helper class for : seqFormations
 *  
 * @author OpenORB Compiler
 */ 
public class seqFormationsHelper
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
     * Insert seqFormations into an any
     * @param a an any
     * @param t seqFormations value
     */
    public static void insert(org.omg.CORBA.Any a, generated.Formation[] t)
    {
        a.insert_Streamable(new generated.seqFormationsHolder(t));
    }

    /**
     * Extract seqFormations from an any
     * @param a an any
     * @return the extracted seqFormations value
     */
    public static generated.Formation[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof generated.seqFormationsHolder)
                    return ((generated.seqFormationsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            generated.seqFormationsHolder h = new generated.seqFormationsHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the seqFormations TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"seqFormations",orb.create_sequence_tc(0,generated.FormationHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the seqFormations IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/seqFormations:1.0";

    /**
     * Read seqFormations from a marshalled stream
     * @param istream the input stream
     * @return the readed seqFormations value
     */
    public static generated.Formation[] read(org.omg.CORBA.portable.InputStream istream)
    {
        generated.Formation[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new generated.Formation[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = generated.FormationHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write seqFormations into a marshalled stream
     * @param ostream the output stream
     * @param value seqFormations value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.Formation[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            generated.FormationHelper.write(ostream,value[i7]);

        }
    }

}
