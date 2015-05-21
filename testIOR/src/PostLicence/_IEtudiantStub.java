package PostLicence;

/**
 * Interface definition : IEtudiant
 * 
 * @author OpenORB Compiler
 */
public class _IEtudiantStub extends org.omg.CORBA.portable.ObjectImpl
        implements IEtudiant
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/IEtudiant:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = PostLicence.IEtudiantOperations.class;

    /**
     * Operation notifier
     */
    public void notifier(String message)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifier",false);
                    _output.write_string(message);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifier",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.IEtudiantOperations _self = (PostLicence.IEtudiantOperations) _so.servant;
                try
                {
                    _self.notifier( message);
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
     * Operation majEtatVoeux
     */
    public void majEtatVoeux(PostLicence.Voeu[] listeVoeux)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majEtatVoeux",true);
                    PostLicence.seqVoeuxHelper.write(_output,listeVoeux);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("majEtatVoeux",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.IEtudiantOperations _self = (PostLicence.IEtudiantOperations) _so.servant;
                try
                {
                    _self.majEtatVoeux( listeVoeux);
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
