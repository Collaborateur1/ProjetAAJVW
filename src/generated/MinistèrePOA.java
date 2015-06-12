package generated;

/**
 * Interface definition : Minist�re
 * 
 * @author OpenORB Compiler
 */
public abstract class Minist�rePOA extends org.omg.PortableServer.Servant
        implements Minist�reOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Minist�re _this()
    {
        return Minist�reHelper.narrow(_this_object());
    }

    public Minist�re _this(org.omg.CORBA.ORB orb)
    {
        return Minist�reHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/Minist�re:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("deliberationJury")) {
                return _invoke_deliberationJury(_is, handler);
        } else if (opName.equals("depotDesFormationsRectorat")) {
                return _invoke_depotDesFormationsRectorat(_is, handler);
        } else if (opName.equals("inscriptionRectorat")) {
                return _invoke_inscriptionRectorat(_is, handler);
        } else if (opName.equals("madDesFormationsFrance")) {
                return _invoke_madDesFormationsFrance(_is, handler);
        } else if (opName.equals("rectoratRattacherUniv")) {
                return _invoke_rectoratRattacherUniv(_is, handler);
        } else if (opName.equals("recupererRectorat")) {
                return _invoke_recupererRectorat(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_madDesFormationsFrance(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        generated.Formation[] _arg_result = madDesFormationsFrance();

        _output = handler.createReply();
        generated.seqFormationsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_depotDesFormationsRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.Formation arg0_in = generated.FormationHelper.read(_is);

        depotDesFormationsRectorat(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Rectorat arg1_in = generated.RectoratHelper.read(_is);

        try
        {
            inscriptionRectorat(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Rectorat _arg_result = recupererRectorat(arg0_in);

            _output = handler.createReply();
            generated.RectoratHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rectoratRattacherUniv(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Rectorat _arg_result = rectoratRattacherUniv(arg0_in);

            _output = handler.createReply();
            generated.RectoratHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_deliberationJury(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        deliberationJury();

        _output = handler.createReply();

        return _output;
    }

}
