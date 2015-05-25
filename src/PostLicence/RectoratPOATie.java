package PostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class RectoratPOATie extends RectoratPOA
{

    //
    // Private reference to implementation object
    //
    private RectoratOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public RectoratOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(RectoratOperations delegate_)
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
     * Read accessor for nomRectorat attribute
     */
    public String nomRectorat()
    {
        return _tie.nomRectorat();
    }

    /**
     * Operation transfertDossier
     */
    public void transfertDossier(PostLicence.dossierEtudiant dossierEtu, PostLicence.Voeu voeu)
    {
        _tie.transfertDossier( dossierEtu,  voeu);
    }

    /**
     * Operation envoyerListeVoeuxGDV
     */
    public void envoyerListeVoeuxGDV(PostLicence.Voeu[] lv, PostLicence.Etudiant etu)
        throws PostLicence.DonneesInvalides
    {
        _tie.envoyerListeVoeuxGDV( lv,  etu);
    }

    /**
     * Operation envoyerDecisionCandidatureRectorat
     */
    public void envoyerDecisionCandidatureRectorat(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        _tie.envoyerDecisionCandidatureRectorat( ine,  voeu);
    }

    /**
     * Operation envoyerDecisionCandidatureUniv
     */
    public void envoyerDecisionCandidatureUniv(PostLicence.Etudiant etu, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        _tie.envoyerDecisionCandidatureUniv( etu,  voeu);
    }

    /**
     * Operation inscriptionUniv
     */
    public void inscriptionUniv(PostLicence.Universite iorLUniversite)
    {
        _tie.inscriptionUniv( iorLUniversite);
    }

    /**
     * Operation inscriptionGDV
     */
    public void inscriptionGDV(PostLicence.GestionDesVoeux Gdv)
    {
        _tie.inscriptionGDV( Gdv);
    }

    /**
     * Operation repondrePropositionVoeux
     */
    public void repondrePropositionVoeux(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        _tie.repondrePropositionVoeux( ine,  voeu);
    }

    /**
     * Operation deliberationJury
     */
    public void deliberationJury()
    {
        _tie.deliberationJury();
    }

}
