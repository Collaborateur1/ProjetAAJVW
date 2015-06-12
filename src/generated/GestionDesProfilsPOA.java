package generated;

/**
 * Interface definition : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionDesProfilsPOA extends org.omg.PortableServer.Servant
        implements GestionDesProfilsOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionDesProfils _this()
    {
        return GestionDesProfilsHelper.narrow(_this_object());
    }

    public GestionDesProfils _this(org.omg.CORBA.ORB orb)
    {
        return GestionDesProfilsHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/GestionDesProfils:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_numeroGDP",
                    new Operation__get_numeroGDP());
            operationMap.put("autorisationConnexion",
                    new Operation_autorisationConnexion());
            operationMap.put("connexion",
                    new Operation_connexion());
            operationMap.put("consulterProfil",
                    new Operation_consulterProfil());
            operationMap.put("etudiantInscrit",
                    new Operation_etudiantInscrit());
            operationMap.put("getFicheEtudiant",
                    new Operation_getFicheEtudiant());
            operationMap.put("getGDV",
                    new Operation_getGDV());
            operationMap.put("inscriptionEtudiant",
                    new Operation_inscriptionEtudiant());
            operationMap.put("inscriptionGestionDesVoeux",
                    new Operation_inscriptionGestionDesVoeux());
            operationMap.put("modifierProfil",
                    new Operation_modifierProfil());
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
    private org.omg.CORBA.portable.OutputStream _invoke__get_numeroGDP(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg = numeroGDP();
        _output = handler.createReply();
        _output.write_short(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_connexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.IEtudiant arg0_in = generated.IEtudiantHelper.read(_is);
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            generated.GestionDesVoeux _arg_result = connexion(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            generated.GestionDesVoeuxHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterProfil(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Etudiant _arg_result = consulterProfil(arg0_in);

            _output = handler.createReply();
            generated.EtudiantHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierProfil(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            modifierProfil(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionGestionDesVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.GestionDesVoeux arg0_in = generated.GestionDesVoeuxHelper.read(_is);

        inscriptionGestionDesVoeux(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_etudiantInscrit(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            boolean _arg_result = etudiantInscrit(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getFicheEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Etudiant _arg_result = getFicheEtudiant(arg0_in);

            _output = handler.createReply();
            generated.EtudiantHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_autorisationConnexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            boolean _arg_result = autorisationConnexion(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            boolean _arg_result = inscriptionEtudiant(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getGDV(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        generated.GestionDesVoeux _arg_result = getGDV();

        _output = handler.createReply();
        generated.GestionDesVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionDesProfilsPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_numeroGDP extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_numeroGDP(_is, handler);
        }
    }

    private static final class Operation_connexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_connexion(_is, handler);
        }
    }

    private static final class Operation_consulterProfil extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterProfil(_is, handler);
        }
    }

    private static final class Operation_modifierProfil extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierProfil(_is, handler);
        }
    }

    private static final class Operation_inscriptionGestionDesVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionGestionDesVoeux(_is, handler);
        }
    }

    private static final class Operation_etudiantInscrit extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_etudiantInscrit(_is, handler);
        }
    }

    private static final class Operation_getFicheEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getFicheEtudiant(_is, handler);
        }
    }

    private static final class Operation_autorisationConnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_autorisationConnexion(_is, handler);
        }
    }

    private static final class Operation_inscriptionEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionEtudiant(_is, handler);
        }
    }

    private static final class Operation_getGDV extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionDesProfilsPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getGDV(_is, handler);
        }
    }

}
