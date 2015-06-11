package generated;

/**
 * Interface definition : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionDesVoeuxPOA extends org.omg.PortableServer.Servant
        implements GestionDesVoeuxOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionDesVoeux _this()
    {
        return GestionDesVoeuxHelper.narrow(_this_object());
    }

    public GestionDesVoeux _this(org.omg.CORBA.ORB orb)
    {
        return GestionDesVoeuxHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/GestionDesVoeux:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_numeroGDV",
                    new Operation__get_numeroGDV());
            operationMap.put("chargerVoeux",
                    new Operation_chargerVoeux());
            operationMap.put("existFormation",
                    new Operation_existFormation());
            operationMap.put("faireUnVoeu",
                    new Operation_faireUnVoeu());
            operationMap.put("inscriptionIE",
                    new Operation_inscriptionIE());
            operationMap.put("lancementVague",
                    new Operation_lancementVague());
            operationMap.put("modifierVoeu",
                    new Operation_modifierVoeu());
            operationMap.put("possedeVoeux",
                    new Operation_possedeVoeux());
            operationMap.put("rechercherFormation",
                    new Operation_rechercherFormation());
            operationMap.put("repondreAuxPropositions",
                    new Operation_repondreAuxPropositions());
            operationMap.put("supprimerVoeux",
                    new Operation_supprimerVoeux());
            operationMap.put("transmettreDecisionCandidatureRectorat",
                    new Operation_transmettreDecisionCandidatureRectorat());
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
    private org.omg.CORBA.portable.OutputStream _invoke__get_numeroGDV(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg = numeroGDV();
        _output = handler.createReply();
        _output.write_short(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionIE(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.IEtudiant arg1_in = generated.IEtudiantHelper.read(_is);

        try
        {
            inscriptionIE(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercherFormation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        generated.Formation[] _arg_result = rechercherFormation(arg0_in);

        _output = handler.createReply();
        generated.seqFormationsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_chargerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Voeu[] _arg_result = chargerVoeux(arg0_in);

            _output = handler.createReply();
            generated.seqVoeuxHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_faireUnVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);
        short arg2_in = _is.read_short();

        try
        {
            generated.Voeu[] _arg_result = faireUnVoeu(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            generated.seqVoeuxHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        catch (generated.UtilisationInterdite _exception)
        {
            _output = handler.createExceptionReply();
            generated.UtilisationInterditeHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondreAuxPropositions(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.decision arg1_in = generated.decisionHelper.read(_is);
        short arg2_in = _is.read_short();

        try
        {
            repondreAuxPropositions(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        catch (generated.UtilisationInterdite _exception)
        {
            _output = handler.createExceptionReply();
            generated.UtilisationInterditeHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        short arg1_in = _is.read_short();
        short arg2_in = _is.read_short();

        try
        {
            generated.Voeu[] _arg_result = modifierVoeu(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            generated.seqVoeuxHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        catch (generated.UtilisationInterdite _exception)
        {
            _output = handler.createExceptionReply();
            generated.UtilisationInterditeHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        short arg1_in = _is.read_short();

        try
        {
            generated.Voeu[] _arg_result = supprimerVoeux(arg0_in, arg1_in);

            _output = handler.createReply();
            generated.seqVoeuxHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        catch (generated.UtilisationInterdite _exception)
        {
            _output = handler.createExceptionReply();
            generated.UtilisationInterditeHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_transmettreDecisionCandidatureRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            transmettreDecisionCandidatureRectorat(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_possedeVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = possedeVoeux(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_existFormation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = existFormation(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_lancementVague(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        lancementVague(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionDesVoeuxPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_numeroGDV extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_numeroGDV(_is, handler);
        }
    }

    private static final class Operation_inscriptionIE extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionIE(_is, handler);
        }
    }

    private static final class Operation_rechercherFormation extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_rechercherFormation(_is, handler);
        }
    }

    private static final class Operation_chargerVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_chargerVoeux(_is, handler);
        }
    }

    private static final class Operation_faireUnVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_faireUnVoeu(_is, handler);
        }
    }

    private static final class Operation_repondreAuxPropositions extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_repondreAuxPropositions(_is, handler);
        }
    }

    private static final class Operation_modifierVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierVoeu(_is, handler);
        }
    }

    private static final class Operation_supprimerVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerVoeux(_is, handler);
        }
    }

    private static final class Operation_transmettreDecisionCandidatureRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_transmettreDecisionCandidatureRectorat(_is, handler);
        }
    }

    private static final class Operation_possedeVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_possedeVoeux(_is, handler);
        }
    }

    private static final class Operation_existFormation extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_existFormation(_is, handler);
        }
    }

    private static final class Operation_lancementVague extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_lancementVague(_is, handler);
        }
    }

}
