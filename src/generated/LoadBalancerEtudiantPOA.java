package generated;

/**
 * Interface definition : LoadBalancerEtudiant
 * 
 * @author OpenORB Compiler
 */
public abstract class LoadBalancerEtudiantPOA extends org.omg.PortableServer.Servant
        implements LoadBalancerEtudiantOperations, org.omg.CORBA.portable.InvokeHandler
{
    public LoadBalancerEtudiant _this()
    {
        return LoadBalancerEtudiantHelper.narrow(_this_object());
    }

    public LoadBalancerEtudiant _this(org.omg.CORBA.ORB orb)
    {
        return LoadBalancerEtudiantHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/LoadBalancerEtudiant:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("getProfil")) {
                return _invoke_getProfil(_is, handler);
        } else if (opName.equals("getServProfil")) {
                return _invoke_getServProfil(_is, handler);
        } else if (opName.equals("inscriptionGDP")) {
                return _invoke_inscriptionGDP(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getProfil(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.GestionDesProfils _arg_result = getProfil(arg0_in);

            _output = handler.createReply();
            generated.GestionDesProfilsHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getServProfil(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            generated.GestionDesProfils _arg_result = getServProfil(arg0_in);

            _output = handler.createReply();
            generated.GestionDesProfilsHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionGDP(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.GestionDesProfils arg0_in = generated.GestionDesProfilsHelper.read(_is);
        short arg1_in = _is.read_short();

        try
        {
            inscriptionGDP(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

}
