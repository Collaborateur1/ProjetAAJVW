package PostLicence;

/**
 * Interface definition : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
public interface GestionDesVoeuxOperations
{
    /**
     * Read accessor for numeroGDV attribute
     * @return the attribute value
     */
    public short numeroGDV();

    /**
     * Operation inscriptionIE
     */
    public void inscriptionIE(String ine, PostLicence.IEtudiant iorEtudiant)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation rechercherFormation
     */
    public PostLicence.Formation[] rechercherFormation(String motscles);

    /**
     * Operation chargerVoeux
     */
    public PostLicence.Voeu[] chargerVoeux(String ine)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation faireUnVoeu
     */
    public void faireUnVoeu(String ine, PostLicence.Voeu monVoeux, short ordre)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite;

    /**
     * Operation repondreAuxPropositions
     */
    public void repondreAuxPropositions(String ine, PostLicence.decision choixEtu)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite;

    /**
     * Operation modifierVoeu
     */
    public void modifierVoeu(String ine, short numeroVoeu, short ordre)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite;

    /**
     * Operation supprimerVoeux
     */
    public void supprimerVoeux(String ine, short numeroVoeu)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite;

    /**
     * Operation transmettreDecisionCandidatureRectorat
     */
    public void transmettreDecisionCandidatureRectorat(String ine, PostLicence.Voeu Reponse)
        throws PostLicence.DonneesInvalides;

}
