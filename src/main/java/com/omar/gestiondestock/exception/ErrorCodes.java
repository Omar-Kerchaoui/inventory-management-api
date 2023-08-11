package com.omar.gestiondestock.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    CATEGORY_ALREADY_IN_USE(2002),
    // TODO complete the rest of the Error Codes
    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(4001),
    COMMANDE_CLIENT_NON_MODIFIABLE(4002),

    COMMANDE_FOUTNISSEUR_NOT_FOUND(5000),
    COMMANDE_FOURNISSEUR_NON_MODIFIABLE(5002),
    COMMANDE_FOUTNISSEUR_NOT_VALID(5001),
    ENTREPRISE_NOT_FOUND(6000),
    ENTREPRISE_NOT_VALID(6001),
    FOURNISSEUR_NOT_FOUND(7000),
    FOURNISSEUR_NOT_VALID(7001),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVT_STK_NOT_FOUND(11000),
    UTILISATEUR_NOT_FOUND(12000),
    UTILISATEUR_NOT_VALID(12001),
    UTILISATEUR_ALREADY_EXISTS(12002),
    VENTE_NOT_FOUND(13000),
    VENTE_NOT_VALID(13001),

    // liste des exceptions techniques
    UPDATE_PHOTO_EXCEPTION(14000),
    UNKNOWN_CONTEXT(14001)

    ;
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
