package fr.ocr.domain.pret;


import lombok.Value;

import java.io.Serializable;
import java.util.Date;

@Value
public class PretDtoWeb implements Serializable {
    static final long serialVersionUID = 8453281303625368221L;

     int ouvrageIdouvrage;
     int usagerIdusager;
     Date dateEmprunt;
     String auteur;
     String titre;
}


