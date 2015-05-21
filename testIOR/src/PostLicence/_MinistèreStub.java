package PostLicence;

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

    private final static Class _opsClass = PostLicence.MinistèreOperations.class;

    /**
     * Operation madDesFormationsFrance
     */
    public PostLicence.Formation[] madDesFormationsFrance()
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
                    PostLicence.Formation[] _arg_ret = PostLicence.seqFormationsHelper.read(_input);
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
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
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
    public void depotDesFormationsRectorat(PostLicence.Formation[] ListeFormation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("depotDesFormationsRectorat",true);
                    PostLicence.seqFormationsHelper.write(_output,ListeFormation);
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
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
                try
                {
                    _self.depotDesFormationsRectorat( ListeFormation);
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
    public void inscriptionRectorat(String nomRectorat, PostLicence.Rectorat iorRectorat)
        throws PostLicence.DonneesInvalides
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
                    PostLicence.RectoratHelper.write(_output,iorRectorat);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionRectorat",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
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
    public PostLicence.Rectorat recupererRectorat(String nomRectorat)
        throws PostLicence.DonneesInvalides
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
                    PostLicence.Rectorat _arg_ret = PostLicence.RectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererRectorat",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
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
    public PostLicence.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws PostLicence.DonneesInvalides
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
                    PostLicence.Rectorat _arg_ret = PostLicence.RectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rectoratRattacherUniv",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
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
                PostLicence.MinistèreOperations _self = (PostLicence.MinistèreOperations) _so.servant;
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
