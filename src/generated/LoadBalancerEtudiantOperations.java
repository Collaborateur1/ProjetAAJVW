package generated;

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
    public generated.GestionDesProfils getProfil(String ine)
        throws generated.DonneesInvalides;

    /**
     * Operation getServProfil
     */
    public generated.GestionDesProfils getServProfil(short num)
        throws generated.DonneesInvalides;

    /**
     * Operation inscriptionGDP
     */
    public void inscriptionGDP(generated.GestionDesProfils iorGestionDesProfils, short numero)
        throws generated.DonneesInvalides;

    /**
     * Operation getAllGDP
     */
    public generated.GestionDesProfils[] getAllGDP();

}
