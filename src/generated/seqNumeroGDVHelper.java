package generated;

/** 
 * Helper class for : seqNumeroGDV
 *  
 * @author OpenORB Compiler
 */ 
public class seqNumeroGDVHelper
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
     * Insert seqNumeroGDV into an any
     * @param a an any
     * @param t seqNumeroGDV value
     */
    public static void insert(org.omg.CORBA.Any a, short[] t)
    {
        a.insert_Streamable(new generated.seqNumeroGDVHolder(t));
    }

    /**
     * Extract seqNumeroGDV from an any
     * @param a an any
     * @return the extracted seqNumeroGDV value
     */
    public static short[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof generated.seqNumeroGDVHolder)
                    return ((generated.seqNumeroGDVHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            generated.seqNumeroGDVHolder h = new generated.seqNumeroGDVHolder(read(a.create_input_stream()));
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
     * Return the seqNumeroGDV TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"seqNumeroGDV",orb.create_sequence_tc(0,orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short)));
        }
        return _tc;
    }

    /**
     * Return the seqNumeroGDV IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/seqNumeroGDV:1.0";

    /**
     * Read seqNumeroGDV from a marshalled stream
     * @param istream the input stream
     * @return the readed seqNumeroGDV value
     */
    public static short[] read(org.omg.CORBA.portable.InputStream istream)
    {
        short[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new short[size7];
        istream.read_short_array(new_one, 0, new_one.length);
        }

        return new_one;
    }

    /**
     * Write seqNumeroGDV into a marshalled stream
     * @param ostream the output stream
     * @param value seqNumeroGDV value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, short[] value)
    {
        ostream.write_ulong(value.length);
        ostream.write_short_array(value, 0,value.length);
    }

}
