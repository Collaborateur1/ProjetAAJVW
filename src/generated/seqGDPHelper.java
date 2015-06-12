package generated;

/** 
 * Helper class for : seqGDP
 *  
 * @author OpenORB Compiler
 */ 
public class seqGDPHelper
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
     * Insert seqGDP into an any
     * @param a an any
     * @param t seqGDP value
     */
    public static void insert(org.omg.CORBA.Any a, generated.GestionDesProfils[] t)
    {
        a.insert_Streamable(new generated.seqGDPHolder(t));
    }

    /**
     * Extract seqGDP from an any
     * @param a an any
     * @return the extracted seqGDP value
     */
    public static generated.GestionDesProfils[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof generated.seqGDPHolder)
                    return ((generated.seqGDPHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            generated.seqGDPHolder h = new generated.seqGDPHolder(read(a.create_input_stream()));
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
     * Return the seqGDP TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"seqGDP",orb.create_sequence_tc(0,generated.GestionDesProfilsHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the seqGDP IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/seqGDP:1.0";

    /**
     * Read seqGDP from a marshalled stream
     * @param istream the input stream
     * @return the readed seqGDP value
     */
    public static generated.GestionDesProfils[] read(org.omg.CORBA.portable.InputStream istream)
    {
        generated.GestionDesProfils[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new generated.GestionDesProfils[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = generated.GestionDesProfilsHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write seqGDP into a marshalled stream
     * @param ostream the output stream
     * @param value seqGDP value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.GestionDesProfils[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            generated.GestionDesProfilsHelper.write(ostream,value[i7]);

        }
    }

}
