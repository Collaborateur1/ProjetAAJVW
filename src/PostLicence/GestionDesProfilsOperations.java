package PostLicence;

/**
 * Interface definition : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
public interface GestionDesProfilsOperations
{
    /**
     * Read accessor for numeroGDP attribute
     * @return the attribute value
     */
    public short numeroGDP();

    /**
     * Operation connexion
     */
    public PostLicence.GestionDesVoeux connexion(PostLicence.IEtudiant iorEtudiant, String ine, String mdp)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation consulterProfil
     */
    public PostLicence.Etudiant consulterProfil(String ine)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation modifierProfil
     */
    public void modifierProfil(String ine, String adr)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation inscriptionGestionDesVoeux
     */
    public void inscriptionGestionDesVoeux(PostLicence.GestionDesVoeux GDesVx);

}
