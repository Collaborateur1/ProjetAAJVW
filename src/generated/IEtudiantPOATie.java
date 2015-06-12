package generated;

/**
 * Interface definition : IEtudiant
 * 
 * @author OpenORB Compiler
 */
public class IEtudiantPOATie extends IEtudiantPOA
{

    //
    // Private reference to implementation object
    //
    private IEtudiantOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public IEtudiantPOATie(IEtudiantOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public IEtudiantPOATie(IEtudiantOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public IEtudiantOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(IEtudiantOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation notifier
     */
    public void notifier(String message)
    {
        _tie.notifier( message);
    }

    /**
     * Operation majEtatVoeux
     */
    public void majEtatVoeux(generated.Voeu[] Voeux)
    {
        _tie.majEtatVoeux( Voeux);
    }

    /**
     * Operation lancementVague
     */
    public void lancementVague(short numero)
    {
        _tie.lancementVague( numero);
    }

}
