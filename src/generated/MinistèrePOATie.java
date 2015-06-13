package generated;

/**
 * Interface definition : Minist�re
 * 
 * @author OpenORB Compiler
 */
public class Minist�rePOATie extends Minist�rePOA
{

    //
    // Private reference to implementation object
    //
    private Minist�reOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public Minist�rePOATie(Minist�reOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public Minist�rePOATie(Minist�reOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public Minist�reOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(Minist�reOperations delegate_)
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
    public generated.Formation[] madDesFormationsFrance()
    {
        return _tie.madDesFormationsFrance();
    }

    /**
     * Operation depotDesFormationsRectorat
     */
    public void depotDesFormationsRectorat(generated.Formation Formation)
    {
        _tie.depotDesFormationsRectorat( Formation);
    }

    /**
     * Operation inscriptionRectorat
     */
    public void inscriptionRectorat(String nomRectorat, generated.Rectorat iorRectorat)
        throws generated.DonneesInvalides
    {
        _tie.inscriptionRectorat( nomRectorat,  iorRectorat);
    }

    /**
     * Operation recupererRectorat
     */
    public generated.Rectorat recupererRectorat(String nomRectorat)
        throws generated.DonneesInvalides
    {
        return _tie.recupererRectorat( nomRectorat);
    }

    /**
     * Operation rectoratRattacherUniv
     */
    public generated.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws generated.DonneesInvalides
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

    /**
     * Operation GetRectoratEtudiant
     */
    public generated.Rectorat GetRectoratEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.GetRectoratEtudiant( ine);
    }

    /**
     * Operation EnregistrerRectoratEtudiant
     */
    public void EnregistrerRectoratEtudiant(String ine, generated.Rectorat recto)
    {
        _tie.EnregistrerRectoratEtudiant( ine,  recto);
    }

    /**
     * Operation InscriptionGDVDansRectorats
     */
    public void InscriptionGDVDansRectorats(short num, generated.GestionDesVoeux gdv)
    {
        _tie.InscriptionGDVDansRectorats( num,  gdv);
    }

}
