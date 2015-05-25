package PostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Read accessor for nomRectorat attribute
     * @return the attribute value
     */
    public String nomRectorat();

    /**
     * Operation transfertDossier
     */
    public void transfertDossier(PostLicence.dossierEtudiant dossierEtu, PostLicence.Voeu voeu);

    /**
     * Operation envoyerListeVoeuxGDV
     */
    public void envoyerListeVoeuxGDV(PostLicence.Voeu[] lv, PostLicence.Etudiant etu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation envoyerDecisionCandidatureRectorat
     */
    public void envoyerDecisionCandidatureRectorat(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation envoyerDecisionCandidatureUniv
     */
    public void envoyerDecisionCandidatureUniv(PostLicence.Etudiant etu, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation inscriptionUniv
     */
    public void inscriptionUniv(PostLicence.Universite iorLUniversite);

    /**
     * Operation inscriptionGDV
     */
    public void inscriptionGDV(PostLicence.GestionDesVoeux Gdv);

    /**
     * Operation repondrePropositionVoeux
     */
    public void repondrePropositionVoeux(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

}
