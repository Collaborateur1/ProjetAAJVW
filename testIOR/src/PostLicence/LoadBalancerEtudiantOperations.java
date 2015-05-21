package PostLicence;

/**
 * Interface definition : LoadBalancerEtudiant
 * 
 * @author OpenORB Compiler
 */
public interface LoadBalancerEtudiantOperations
{
    /**
     * Operation getProfil
     */
    public PostLicence.GestionDesProfils getProfil(String ine)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation getServProfil
     */
    public PostLicence.GestionDesProfils getServProfil(short num)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation inscriptionGDP
     */
    public void inscriptionGDP(PostLicence.GestionDesProfils iorGestionDesProfils, short numero)
        throws PostLicence.DonneesInvalides;

}
