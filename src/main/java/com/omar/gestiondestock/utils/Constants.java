package com.omar.gestiondestock.utils;

public interface Constants {
    String APP_ROOT = "gestiondestock/v1";
    String COMMMANDE_FOURNISSEUR_ENDPOINT = APP_ROOT + "/commandesfournisseurs";

    String CREATE_COMMMANDE_FOUNISSEUR_ENDPOINT = COMMMANDE_FOURNISSEUR_ENDPOINT + "/create";
    String FIND_COMMMANDE_FOURNISSEUR_BY_ID_ENDPOINT = COMMMANDE_FOURNISSEUR_ENDPOINT + "/{idCommandeFournisseur}";

    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT = COMMMANDE_FOURNISSEUR_ENDPOINT + "/{codeCommandeFournisseur}";

    String FIND_ALL_COMMMANDE_FOURNISSEUR_ENDPOINT = COMMMANDE_FOURNISSEUR_ENDPOINT + "/all";

    String DELETE_COMMMANDE_FOURNISSEUR_ENDPOINT = COMMMANDE_FOURNISSEUR_ENDPOINT + "/delete/{idCommandeFournisseur}";

    String ENTREPRISE_ENDPOINT = APP_ROOT + "/entreprises";

    String FOURNISSEUR_ENDPOINT = APP_ROOT + "/fournisseurs";

    String UTILISATEUR_ENDPOINT = APP_ROOT + "/utilisateurs";

    String VENTE_ENDPOINT = APP_ROOT + "/ventes";

    String AUTHENTICATION_ENDPOINT = APP_ROOT + "/auth";

}
