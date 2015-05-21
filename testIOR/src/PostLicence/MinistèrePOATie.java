package PostLicence;

/**
 * Interface definition : Ministère
 * 
 * @author OpenORB Compiler
 */
public class MinistèrePOATie extends MinistèrePOA
{

    //
    // Private reference to implementation object
    //
    private MinistèreOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public MinistèrePOATie(MinistèreOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public MinistèrePOATie(MinistèreOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public MinistèreOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(MinistèreOperations delegate_)
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
     * Operation madDesFormationsFrance
     */
    public PostLicence.Formation[] madDesFormationsFrance()
    {
        return _tie.madDesFormationsFrance();
    }

    /**
     * Operation depotDesFormationsRectorat
     */
    public void depotDesFormationsRectorat(PostLicence.Formation[] ListeFormation)
    {
        _tie.depotDesFormationsRectorat( ListeFormation);
    }

    /**
     * Operation inscriptionRectorat
     */
    public void inscriptionRectorat(String nomRectorat, PostLicence.Rectorat iorRectorat)
        throws PostLicence.DonneesInvalides
    {
        _tie.inscriptionRectorat( nomRectorat,  iorRectorat);
    }

    /**
     * Operation recupererRectorat
     */
    public PostLicence.Rectorat recupererRectorat(String nomRectorat)
        throws PostLicence.DonneesInvalides
    {
        return _tie.recupererRectorat( nomRectorat);
    }

    /**
     * Operation rectoratRattacherUniv
     */
    public PostLicence.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws PostLicence.DonneesInvalides
    {
        return _tie.rectoratRattacherUniv( nomAcademie);
    }

    /**
     * Operation deliberationJury
     */
    public void deliberationJury()
    {
        _tie.deliberationJury();
    }

}
