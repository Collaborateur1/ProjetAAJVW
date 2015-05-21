package PostLicence;

/** 
 * Helper class for : seqVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class seqVoeuxHelper
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
     * Insert seqVoeux into an any
     * @param a an any
     * @param t seqVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.Voeu[] t)
    {
        a.insert_Streamable(new PostLicence.seqVoeuxHolder(t));
    }

    /**
     * Extract seqVoeux from an any
     * @param a an any
     * @return the extracted seqVoeux value
     */
    public static PostLicence.Voeu[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof PostLicence.seqVoeuxHolder)
                    return ((PostLicence.seqVoeuxHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            PostLicence.seqVoeuxHolder h = new PostLicence.seqVoeuxHolder(read(a.create_input_stream()));
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
     * Return the seqVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"seqVoeux",orb.create_sequence_tc(0,PostLicence.VoeuHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the seqVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/seqVoeux:1.0";

    /**
     * Read seqVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed seqVoeux value
     */
    public static PostLicence.Voeu[] read(org.omg.CORBA.portable.InputStream istream)
    {
        PostLicence.Voeu[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new PostLicence.Voeu[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = PostLicence.VoeuHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write seqVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value seqVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.Voeu[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            PostLicence.VoeuHelper.write(ostream,value[i7]);

        }
    }

}
