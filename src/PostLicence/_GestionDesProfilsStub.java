package PostLicence;

/**
 * Interface definition : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
public class _GestionDesProfilsStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionDesProfils
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/GestionDesProfils:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = PostLicence.GestionDesProfilsOperations.class;

    /**
     * Read accessor for numeroGDP attribute
     * @return the attribute value
     */
    public short numeroGDP()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_numeroGDP",true);
                    _input = this._invoke(_output);
                    return _input.read_short();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_numeroGDP",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesProfilsOperations _self = (PostLicence.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.numeroGDP();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation connexion
     */
    public PostLicence.GestionDesVoeux connexion(PostLicence.IEtudiant iorEtudiant, String ine, String mdp)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connexion",true);
                    PostLicence.IEtudiantHelper.write(_output,iorEtudiant);
                    _output.write_string(ine);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    PostLicence.GestionDesVoeux _arg_ret = PostLicence.GestionDesVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connexion",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesProfilsOperations _self = (PostLicence.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.connexion( iorEtudiant,  ine,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterProfil
     */
    public PostLicence.Etudiant consulterProfil(String ine)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterProfil",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    PostLicence.Etudiant _arg_ret = PostLicence.EtudiantHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterProfil",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesProfilsOperations _self = (PostLicence.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.consulterProfil( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierProfil
     */
    public void modifierProfil(String ine, String adr)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierProfil",true);
                    _output.write_string(ine);
                    _output.write_string(adr);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierProfil",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesProfilsOperations _self = (PostLicence.GestionDesProfilsOperations) _so.servant;
                try
                {
                    _self.modifierProfil( ine,  adr);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscriptionGestionDesVoeux
     */
    public void inscriptionGestionDesVoeux(PostLicence.GestionDesVoeux GDesVx)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGestionDesVoeux",true);
                    PostLicence.GestionDesVoeuxHelper.write(_output,GDesVx);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGestionDesVoeux",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesProfilsOperations _self = (PostLicence.GestionDesProfilsOperations) _so.servant;
                try
                {
                    _self.inscriptionGestionDesVoeux( GDesVx);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
