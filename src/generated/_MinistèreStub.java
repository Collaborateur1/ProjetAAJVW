package generated;

/**
 * Interface definition : Ministère
 * 
 * @author OpenORB Compiler
 */
public class _MinistèreStub extends org.omg.CORBA.portable.ObjectImpl
        implements Ministère
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/Ministère:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = generated.MinistèreOperations.class;

    /**
     * Operation madDesFormationsFrance
     */
    public generated.Formation[] madDesFormationsFrance()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("madDesFormationsFrance",true);
                    _input = this._invoke(_output);
                    generated.Formation[] _arg_ret = generated.seqFormationsHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("madDesFormationsFrance",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    return _self.madDesFormationsFrance();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation depotDesFormationsRectorat
     */
    public void depotDesFormationsRectorat(generated.Formation Formation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("depotDesFormationsRectorat",true);
                    generated.FormationHelper.write(_output,Formation);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("depotDesFormationsRectorat",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.depotDesFormationsRectorat( Formation);
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
     * Operation inscriptionRectorat
     */
    public void inscriptionRectorat(String nomRectorat, generated.Rectorat iorRectorat)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionRectorat",true);
                    _output.write_string(nomRectorat);
                    generated.RectoratHelper.write(_output,iorRectorat);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionRectorat",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.inscriptionRectorat( nomRectorat,  iorRectorat);
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
     * Operation recupererRectorat
     */
    public generated.Rectorat recupererRectorat(String nomRectorat)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererRectorat",true);
                    _output.write_string(nomRectorat);
                    _input = this._invoke(_output);
                    generated.Rectorat _arg_ret = generated.RectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererRectorat",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    return _self.recupererRectorat( nomRectorat);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation rectoratRattacherUniv
     */
    public generated.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rectoratRattacherUniv",true);
                    _output.write_string(nomAcademie);
                    _input = this._invoke(_output);
                    generated.Rectorat _arg_ret = generated.RectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rectoratRattacherUniv",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    return _self.rectoratRattacherUniv( nomAcademie);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation deliberationJury
     */
    public void deliberationJury()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("deliberationJury",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deliberationJury",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.deliberationJury();
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
     * Operation GetRectoratEtudiant
     */
    public generated.Rectorat GetRectoratEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("GetRectoratEtudiant",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    generated.Rectorat _arg_ret = generated.RectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("GetRectoratEtudiant",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    return _self.GetRectoratEtudiant( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation EnregistrerRectoratEtudiant
     */
    public void EnregistrerRectoratEtudiant(String ine, generated.Rectorat recto)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("EnregistrerRectoratEtudiant",true);
                    _output.write_string(ine);
                    generated.RectoratHelper.write(_output,recto);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("EnregistrerRectoratEtudiant",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.EnregistrerRectoratEtudiant( ine,  recto);
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
     * Operation InscriptionGDVDansRectorats
     */
    public void InscriptionGDVDansRectorats(short num, generated.GestionDesVoeux gdv)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("InscriptionGDVDansRectorats",true);
                    _output.write_short(num);
                    generated.GestionDesVoeuxHelper.write(_output,gdv);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("InscriptionGDVDansRectorats",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.InscriptionGDVDansRectorats( num,  gdv);
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
     * Operation deliberationJuryFinal
     */
    public void deliberationJuryFinal()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("deliberationJuryFinal",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deliberationJuryFinal",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    _self.deliberationJuryFinal();
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
     * Operation containsEtudiant
     */
    public boolean containsEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("containsEtudiant",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("containsEtudiant",_opsClass);
                if (_so == null)
                   continue;
                generated.MinistèreOperations _self = (generated.MinistèreOperations) _so.servant;
                try
                {
                    return _self.containsEtudiant( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
