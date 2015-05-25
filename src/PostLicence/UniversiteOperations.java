package PostLicence;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public interface UniversiteOperations
{
    /**
     * Read accessor for nomUniversite attribute
     * @return the attribute value
     */
    public String nomUniversite();

    /**
     * Read accessor for villeUniversite attribute
     * @return the attribute value
     */
    public String villeUniversite();

    /**
     * Read accessor for academieUniversite attribute
     * @return the attribute value
     */
    public String academieUniversite();

    /**
     * Operation envoyerCandidature
     */
    public void envoyerCandidature(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation envoyerCandidatureD
     */
    public void envoyerCandidatureD(PostLicence.dossierEtudiant dossierEtu, String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation madDossier
     */
    public PostLicence.dossierEtudiant madDossier(String ine);

    /**
     * Operation repondrePropositionvoeux
     */
    public void repondrePropositionvoeux(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

}
