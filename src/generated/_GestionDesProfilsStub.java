package generated;

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

    private final static Class _opsClass = generated.GestionDesProfilsOperations.class;

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
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
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
    public generated.GestionDesVoeux connexion(generated.IEtudiant iorEtudiant, String ine, String mdp)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connexion",true);
                    generated.IEtudiantHelper.write(_output,iorEtudiant);
                    _output.write_string(ine);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    generated.GestionDesVoeux _arg_ret = generated.GestionDesVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
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
    public generated.Etudiant consulterProfil(String ine)
        throws generated.DonneesInvalides
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
                    generated.Etudiant _arg_ret = generated.EtudiantHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
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
        throws generated.DonneesInvalides
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
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
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
    public void inscriptionGestionDesVoeux(generated.GestionDesVoeux GDesVx)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGestionDesVoeux",true);
                    generated.GestionDesVoeuxHelper.write(_output,GDesVx);
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
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
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

    /**
     * Operation etudiantInscrit
     */
    public boolean etudiantInscrit(String ine)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("etudiantInscrit",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("etudiantInscrit",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.etudiantInscrit( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getFicheEtudiant
     */
    public generated.Etudiant getFicheEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getFicheEtudiant",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    generated.Etudiant _arg_ret = generated.EtudiantHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getFicheEtudiant",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.getFicheEtudiant( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation autorisationConnexion
     */
    public boolean autorisationConnexion(String ine, String mdp)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("autorisationConnexion",true);
                    _output.write_string(ine);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("autorisationConnexion",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesProfilsOperations _self = (generated.GestionDesProfilsOperations) _so.servant;
                try
                {
                    return _self.autorisationConnexion( ine,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
