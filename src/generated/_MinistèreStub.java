package generated;

/**
 * Interface definition : Minist�re
 * 
 * @author OpenORB Compiler
 */
public class _Minist�reStub extends org.omg.CORBA.portable.ObjectImpl
        implements Minist�re
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/Minist�re:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = generated.Minist�reOperations.class;

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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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
                generated.Minist�reOperations _self = (generated.Minist�reOperations) _so.servant;
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

}
