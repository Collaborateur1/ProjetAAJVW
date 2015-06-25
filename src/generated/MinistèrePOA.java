package generated;

/**
 * Interface definition : Ministère
 * 
 * @author OpenORB Compiler
 */
public abstract class MinistèrePOA extends org.omg.PortableServer.Servant
        implements MinistèreOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Ministère _this()
    {
        return MinistèreHelper.narrow(_this_object());
    }

    public Ministère _this(org.omg.CORBA.ORB orb)
    {
        return MinistèreHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/Ministère:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("EnregistrerRectoratEtudiant",
                    new Operation_EnregistrerRectoratEtudiant());
            operationMap.put("GetRectoratEtudiant",
                    new Operation_GetRectoratEtudiant());
            operationMap.put("InscriptionGDVDansRectorats",
                    new Operation_InscriptionGDVDansRectorats());
            operationMap.put("containsEtudiant",
                    new Operation_containsEtudiant());
            operationMap.put("deliberationJury",
                    new Operation_deliberationJury());
            operationMap.put("deliberationJuryFinal",
                    new Operation_deliberationJuryFinal());
            operationMap.put("depotDesFormationsRectorat",
                    new Operation_depotDesFormationsRectorat());
            operationMap.put("inscriptionRectorat",
                    new Operation_inscriptionRectorat());
            operationMap.put("madDesFormationsFrance",
                    new Operation_madDesFormationsFrance());
            operationMap.put("rectoratRattacherUniv",
                    new Operation_rectoratRattacherUniv());
            operationMap.put("recupererRectorat",
                    new Operation_recupererRectorat());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke_GetRectoratEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Rectorat _arg_result = GetRectoratEtudiant(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_EnregistrerRectoratEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Rectorat arg1_in = generated.RectoratHelper.read(_is);

        EnregistrerRectoratEtudiant(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_InscriptionGDVDansRectorats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        generated.GestionDesVoeux arg1_in = generated.GestionDesVoeuxHelper.read(_is);

        InscriptionGDVDansRectorats(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_deliberationJuryFinal(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        deliberationJuryFinal();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_containsEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            boolean _arg_result = containsEtudiant(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                MinistèrePOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_madDesFormationsFrance extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_madDesFormationsFrance(_is, handler);
        }
    }

    private static final class Operation_depotDesFormationsRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_depotDesFormationsRectorat(_is, handler);
        }
    }

    private static final class Operation_inscriptionRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionRectorat(_is, handler);
        }
    }

    private static final class Operation_recupererRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_recupererRectorat(_is, handler);
        }
    }

    private static final class Operation_rectoratRattacherUniv extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_rectoratRattacherUniv(_is, handler);
        }
    }

    private static final class Operation_deliberationJury extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_deliberationJury(_is, handler);
        }
    }

    private static final class Operation_GetRectoratEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_GetRectoratEtudiant(_is, handler);
        }
    }

    private static final class Operation_EnregistrerRectoratEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_EnregistrerRectoratEtudiant(_is, handler);
        }
    }

    private static final class Operation_InscriptionGDVDansRectorats extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_InscriptionGDVDansRectorats(_is, handler);
        }
    }

    private static final class Operation_deliberationJuryFinal extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_deliberationJuryFinal(_is, handler);
        }
    }

    private static final class Operation_containsEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final MinistèrePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_containsEtudiant(_is, handler);
        }
    }

}
